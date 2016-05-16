package com.okas.packModelo;

/**
 * Clase que se encarga de crear los tableros de nivel 3
 *
 */
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
