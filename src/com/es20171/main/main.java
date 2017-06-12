package com.es20171.main;

import java.util.HashMap;

/**
 * Created by rud on 11/06/2017.
 */
public class main {

    public static void main(String[] args){
        //MainMenu mainMenu = new MainMenu();
        //mainMenu.deploy();

        GerenciadorSugestao.getInstance().criaSugestaoLivro("Vingança da Maré", "Elizabeth Haynes", "0000000001");
        GerenciadorSugestao.getInstance().criaSugestaoLivro("No Escuro", "Elizabeth Haynes", "0000000002");
        GerenciadorSugestao.getInstance().criaSugestaoEvento("Leitura de Jesus", "Auditório", "Muita Bíblia");

        System.out.println(GerenciadorSugestao.getInstance().sugestoesToString());
        System.exit(0);
    }
}
