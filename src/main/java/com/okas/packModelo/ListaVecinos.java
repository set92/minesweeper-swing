package com.okas.packModelo;

import java.util.ArrayList;

public class ListaVecinos {
    private ArrayList<Casilla> listVecinos;

    public ArrayList<Casilla> getListVecinos() {
        return listVecinos;
    }
    public void setListVecinos(ArrayList<Casilla> listVecinos) {
        this.listVecinos = listVecinos;
    }

    public void expandirVecinos(){
        for (Casilla cas : listVecinos) {
            cas.descubrirCasilla();
        }
    }

}
