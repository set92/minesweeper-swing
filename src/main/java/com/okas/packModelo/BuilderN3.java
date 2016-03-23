package com.okas.packModelo;

public class BuilderN3 extends TableroBuilder {
	
	public BuilderN3() {
		tablero = new Tablero(7,7,7); //TODO cambiar parámetros de la constructora.
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
