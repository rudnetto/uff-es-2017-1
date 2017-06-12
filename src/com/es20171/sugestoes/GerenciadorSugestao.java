package com.es20171.sugestoes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class GerenciadorSugestao {
    /**
     * instância de GerenciadorSugestão via singleton
     */
    private static GerenciadorSugestao instance;
    private List<Sugestao> listaSugestao = new ArrayList<>();
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
     * @param titulo Nome do livro
     * @param autor Autor do livro
     * @param ISBN Código ISBN referente ao livro
     */
    public void criaSugestaoLivro(String titulo, String autor, String ISBN) {
        SugestaoLivro sug = new SugestaoLivro(contadorId++);
        sug.setData(LocalDateTime.now());
        sug.setTitulo(titulo);
        sug.setAutor(autor);
        sug.setISBN(ISBN);

        listaSugestao.add(sug);
    }

    /**
     * Cria sugestão de evento e adiciona à lista de Sugestões
     * @param nome Nome do evento
     * @param local Local do evento
     * @param descricao Descrição do evento
     */
    public void criaSugestaoEvento(String nome, String local, String descricao) {
        SugestaoEvento sug = new SugestaoEvento(contadorId++);
        sug.setData(LocalDateTime.now());
        sug.setNome(nome);
        sug.setLocal(local);
        sug.setDescricao(descricao);
        listaSugestao.add(sug);
    }

    /**
     * @return Lista de sugestões
     */
    public List<Sugestao> getSugestoes() {
        return listaSugestao;
    }

    public Sugestao getSugestaoAtIndex(int index) {
        return listaSugestao.get(index);
    }
}
