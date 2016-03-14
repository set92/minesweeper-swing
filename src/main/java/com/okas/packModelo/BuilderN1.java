package com.okas.packModelo;

public class BuilderN1 extends TableroBuilder {
	
	public BuilderN1() {
		tablero = new Tablero(7,10,10);
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
