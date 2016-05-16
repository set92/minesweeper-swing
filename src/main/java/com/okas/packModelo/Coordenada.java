package com.okas.packModelo;

/**
 * Clase que se encarga de registrar las coordenadas de las casillas
 */
public class Coordenada {
	
    private final int posAlto;
    private final int posAncho;
    
    public Coordenada(int pAlto, int pAncho){
    	this.posAlto = pAlto;
    	this.posAncho = pAncho;
    }

    public int getAlto() {
        return posAlto;
    }

    public int getAncho() {
        return posAncho;
    }

}
