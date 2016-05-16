package com.okas.packModelo;

/**
 * Clase encargada de ejecutar las acciones de una casilla tipo CasillaValor
 */
public class CasillaValor extends Casilla {
	
    private int valor;

    public CasillaValor(Coordenada pPos) {
    	super(pPos);
    	this.valor = 1;
    }

    /**
     * Incrementa en 1 el valor de la Casilla
     */
    public void incrementarValor(){ this.valor++;}

	public int getValor() {
		return this.valor;
	}
	


}
