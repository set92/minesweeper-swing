package com.okas.packModelo;

public abstract class TableroBuilder {

	protected Tablero tablero;

    public Tablero getTablero() {
        return tablero;
    }
    
    /**
     * Genera el tablero
     */
    public abstract void generarTablero();

    /**
     * Construye el tablero metiendo las casillas pertinentes
     */
	public Tablero construirTablero(){
		generarTablero();
		ponerCasillasBomba();
		ponerCasillasRestantes();
		tablero.crearListas();
		return tablero;
		
	}

	/**
     * Coloca las casillas bomba
     */
	public abstract void ponerCasillasBomba();
	
	
	/**
     * Coloca las casillas que restan del tablero
     */
	public void ponerCasillasRestantes() {
		tablero.rellenarCasillasRestantes();

	}

}
