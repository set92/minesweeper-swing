package com.okas.packModelo;

public class BuilderN2 extends TableroBuilder {

	public void generarTablero(){
		tablero = new Tablero(10,15);
	}
	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba(20);
	}	


}
