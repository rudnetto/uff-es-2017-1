package com.es20171.main;

import java.time.format.DateTimeFormatter;

/**
 * Created by rud on 11/06/2017.
 */
public class SugestaoLivro extends Sugestao {
    private String titulo;
    private String autor;
    private String ISBN;

    public SugestaoLivro(int id) {
        super(id);
        super.setTipo(1);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String toString() {
        String output = "";
        output += "Tipo da sugestão: Livro\n";
        output += "Data da sugestão: " + getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "\n";
        output += "Nome do livro: " + getTitulo() + "\n";
        output += "ISBN: " + getISBN() + "\n";
        return output;
    }
}
