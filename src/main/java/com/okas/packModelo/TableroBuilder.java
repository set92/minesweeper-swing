package com.okas.packModelo;

public abstract class TableroBuilder {

	protected Tablero tablero;

    public Tablero getTablero() {
        return tablero;
    }

    public abstract void generarTablero();

	public Tablero construirTablero(){
		generarTablero();
		ponerCasillasBomba();
		ponerCasillasRestantes();
		return tablero;
		//tablero.crearListas();
	}

	public abstract void ponerCasillasBomba();
	
	public void ponerCasillasRestantes() {
		tablero.rellenarCasillasRestantes();

	}

}
