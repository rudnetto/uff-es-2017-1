package com.es20171.main;

import java.time.format.DateTimeFormatter;

/**
 * Created by rud on 11/06/2017.
 */
public class SugestaoEvento extends Sugestao{
    private String nome;
    private String local;
    private String descricao;

    public SugestaoEvento(int id) {
        super(id);
        setTipo(0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        String output = "";
        output += "Tipo da sugestão: Evento\n";
        output += "Data da sugestão: " + getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "\n";
        output += "Nome do evento: " + getNome() + "\n";
        output += "Local do evento: " + getLocal() + "\n";
        output += "Descrição do evento: " + getDescricao() + "\n";

        return output;
    }
}
