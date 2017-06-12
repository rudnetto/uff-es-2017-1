package com.es20171.sugestoes;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class MainMenu extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane1;

    private JPanel tab1;
    private JPanel tab3;
    private JPanel tab2;

    // Componentes da tab1
    private JTextField fieldEventoNome;
    private JTextField fieldEventoLocal;
    private JTextArea fieldEventoDesc;
    private JButton botaoCriarEvento;

    // Componentes da tab2
    private JTextField fieldLivroTitulo;
    private JTextField fieldLivroAutor;
    private JTextField fieldLivroISBN;
    private JButton botaoCriarLivro;
    private JList list1;
    private JTextArea textArea1;

    public MainMenu() {
        Container c = new Container();
        setTitle("Sistema de Sugestões");

        // sets window position and minimum size
        setLocation(200, 100);
        setMinimumSize(new Dimension(1000, 350));

        // bind default content pane to JDialog
        setContentPane(contentPane);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        botaoCriarEvento.addActionListener(e -> {
            String nome = fieldEventoNome.getText();
            String local = fieldEventoLocal.getText();
            String desc = fieldEventoDesc.getText();

            if (!nome.isEmpty() && !local.isEmpty() && !desc.isEmpty()) {
                GerenciadorSugestao.getInstance().criaSugestaoEvento(nome, local, desc);

                fieldEventoNome.setText("");
                fieldEventoLocal.setText("");
                fieldEventoDesc.setText("");
            }
        });

        botaoCriarLivro.addActionListener(e -> {
            String titulo = fieldLivroTitulo.getText();
            String autor = fieldLivroAutor.getText();
            String ISBN = fieldLivroISBN.getText();

            if (!titulo.isEmpty() && !autor.isEmpty() && !ISBN.isEmpty()) {
                GerenciadorSugestao.getInstance().criaSugestaoLivro(titulo, autor, ISBN);

                fieldLivroTitulo.setText("");
                fieldLivroAutor.setText("");
                fieldLivroISBN.setText("");
            }
        });

        tabbedPane1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (tabbedPane1.getSelectedIndex() == 2) {
                    DefaultListModel listModel = new DefaultListModel();

                    for(Sugestao item : GerenciadorSugestao.getInstance().getSugestoes()) {
                        if (item.getTipo() == 0) {
                            SugestaoEvento se = (SugestaoEvento) item;
                            listModel.addElement(se.getNome());
                        } else if (item.getTipo() == 1) {
                            SugestaoLivro sl = (SugestaoLivro) item;
                            listModel.addElement(sl.getTitulo());
                        }
                    }

                    list1.setModel(listModel);
                }
            }
        });

        list1.addListSelectionListener(e -> {
            int id = list1.getSelectedIndex();

            if (id >= 0) {
                Sugestao sg = GerenciadorSugestao.getInstance().getSugestaoAtIndex(id);
                textArea1.setText(sg.toString());
            }
        });
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void deploy() {
        MainMenu dialog = new MainMenu();
        dialog.pack();
        dialog.setVisible(true);
    }
}
