package br.com.senac.projetopi.lojadecarros;

import Forms.TelaLoginPI;


public class ProjetoPILojaDeCarros {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new TelaLoginPI().setVisible(true);
            }
        });
    }
}
