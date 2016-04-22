package com.okas.packModelo;

public class BuilderN1 extends TableroBuilder {
	
	
	/**
     * Genera el tablero del primer nivel
     */
	
	public void generarTablero(){
		tablero = new Tablero(7,10);
	}
	
	/**
     * Pone el numero de bombas del primer nivel
     */
	
	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba(10);
	}

}
