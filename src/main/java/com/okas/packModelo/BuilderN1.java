package com.okas.packModelo;

/**
 * Clase que se encarga de crear los tableros del nivel 1
 */
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
