package com.es20171.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JPanel tab1;
    private JPanel tab3;
    private JPanel tab2;

    public MainMenu() {
        Container c = new Container();
        setTitle("Sistema de Sugestões");

        // sets window position and minimum size
        setLocation(200, 200);
        setMinimumSize(new Dimension(600, 300));

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
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void deploy() {
        MainMenu dialog = new MainMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
