package com.okas.packModelo;

import java.util.ArrayList;

/**
 * Clase que guarda la referencia a las casillas que están alrededor de una casilla determinada
 */
public class ListaCasillas extends ArrayList<Casilla>{
    private final ArrayList<Casilla> listaCasilla;
    
    public ListaCasillas(){
    	this.listaCasilla = new ArrayList<>();
    }
    
    /**
     * Devuelve el tamaño de la Lista de Casillas
     */
    public int size(){return listaCasilla.size();}

    public ArrayList<Casilla> getListCasilla() {
        return listaCasilla;
    }

    /**
     * Descubre las casillas de toda la lista de Casillas
     */
    public void expandirVecinos(){
        listaCasilla.forEach(Casilla::descubrirCasilla);
    }

}
