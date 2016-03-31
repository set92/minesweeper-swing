package com.okas.packModelo;

public class BuilderN3 extends TableroBuilder {
	
	public void generarTablero(){
		tablero = new Tablero(12,25);
	}

	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba(45);
	}	


}
