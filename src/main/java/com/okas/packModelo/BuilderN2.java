package com.okas.packModelo;

public class BuilderN2 extends TableroBuilder {

	public BuilderN2() {
		tablero = new Tablero(5,5,5); //TODO cambiar parámetros de la constructora
	}

	@Override
	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba();
		
	}
	
	@Override
	public void ponerCasillasRestantes() {
		tablero.rellenarCasillasRestantes();
		
	}

	

}
