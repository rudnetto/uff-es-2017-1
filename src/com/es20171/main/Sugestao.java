package com.es20171.main;

import java.time.LocalDateTime;

/**
 * Created by rud on 11/06/2017.
 */
public class Sugestao {
    private int id;

    /**
     * Descreve o tipo de sugestão.
     * 0 = sugestão de evento
     * 1 = sugestão de livro
     */
    private int tipo;
    private LocalDateTime data;

    public Sugestao(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() { return data; }

    public void setData(LocalDateTime data) { this.data = data; }
}
