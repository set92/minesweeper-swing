package com.okas.packModelo;

public class CasillaValor extends Casilla {
    private int valor;


    public CasillaValor(Coordenada pPos) {
    	super(pPos);
    	this.valor = 1;
    }

    public void incrementarValor(){ this.valor++;}

	public int getValor() {
		return this.valor;
	}
	


}
