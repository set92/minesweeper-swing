package com.okas.packModelo;

import java.util.ArrayList;

public class ListaVecinos {
    private ArrayList<Casilla> listaVecinos;
    
    public ListaVecinos(){
    	this.listaVecinos = new ArrayList<Casilla>();
    }

    public ArrayList<Casilla> getListVecinos() {
        return listaVecinos;
    }

    public void expandirVecinos(){
        for (Casilla cas : listaVecinos) {
            cas.descubrirCasilla();
        }
    }

}
