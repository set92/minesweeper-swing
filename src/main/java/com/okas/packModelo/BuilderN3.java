package com.okas.packModelo;

public class BuilderN3 extends TableroBuilder {
	
	/**
     * Genera el tablero del tercer nivel
     */
	
	public void generarTablero(){
		tablero = new Tablero(12,25);
	}

	
	/**
     * Pone el numero de bombas del tercer nivel
     */
	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba(45);
	}	


}
