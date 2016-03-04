package com.okas.packModelo;

import java.util.ArrayList;

/**
 * Created by toburi on 26/02/2016.
 * Creado por toburi el 26/02/2016.
 */
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
