package com.okas.packModelo;

public class BuilderN2 extends TableroBuilder {

	public BuilderN2() {
		tablero = new Tablero(10,15,30);
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
