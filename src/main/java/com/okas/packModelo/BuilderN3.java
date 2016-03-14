package com.okas.packModelo;

public class BuilderN3 extends TableroBuilder {
	
	public BuilderN3() {
		tablero = new Tablero(12,25,75);
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
