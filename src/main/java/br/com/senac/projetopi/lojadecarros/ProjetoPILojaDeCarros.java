package br.com.senac.projetopi.lojadecarros;

import Forms.TelaPrincipal;


public class ProjetoPILojaDeCarros {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}
