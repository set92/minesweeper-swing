package com.okas.packModelo;

public class BuilderN2 extends TableroBuilder {

	
	/**
     * Genera el tablero del segundo nivel
     */
	public void generarTablero(){
		tablero = new Tablero(10,15);
	}
	
	/**
     * Pone el numero de bombas del segundo nivel
     */
	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba(20);
	}	


}
