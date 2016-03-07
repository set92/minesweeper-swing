package com.okas.packModelo;

public class CasillaValor extends Casilla {
    private int valor;


    public CasillaValor(Coordenada pPos) {
    	super(pPos);
    	this.valor = 0;
    }

    private void incrementarValor(){ this.valor++;}


}
