package com.okas.packModelo;

/**
 * Clase que se encarga de crear los tableros de nivel 2
 *
 */
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
