package com.es20171.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rud on 11/06/2017.
 */
public class GerenciadorSugestao {
    /**
     * instância de GerenciadorSugestão via singleton
     */
    private static GerenciadorSugestao instance;
    private List<Sugestao> listaSugestao = new ArrayList<Sugestao>();
    private int contadorId = 0;

    private GerenciadorSugestao() { }

    /**
     * Construtor do singleton
     * @return GerenciadorSugestao
     */
    public static GerenciadorSugestao getInstance() {
        if (instance == null) {
            instance = new GerenciadorSugestao();
        }

        return instance;
    }

    /**
     * Cria sugestão de livro e adiciona à lista de Sugestões
     * @param nome Nome do livro
     * @param autor Autor do livro
     * @param ISBN Código ISBN referente ao livro
     */
    public void criaSugestaoLivro(String nome, String autor, String ISBN) {
        SugestaoLivro sug = new SugestaoLivro(contadorId++);
        sug.setData(LocalDateTime.now());
        sug.setTitulo(nome);
        sug.setAutor(autor);
        sug.setISBN(ISBN);

        listaSugestao.add(sug);
    }

    public void criaSugestaoEvento(String nome, String local, String descricao) {
        SugestaoEvento sug = new SugestaoEvento(contadorId++);
        sug.setData(LocalDateTime.now());
        sug.setNome(nome);
        sug.setLocal(local);
        sug.setDescricao(descricao);
        listaSugestao.add(sug);
    }

    public String sugestoesToString() {
        String output = "";

        for (Sugestao item: listaSugestao) {
            output += item.toString();
            output += "----------\n";
        }

        return output;
    }
}
