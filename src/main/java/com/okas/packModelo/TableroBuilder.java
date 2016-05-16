package com.okas.packModelo;

/**
 * Clase encargada de construir el tablero
 */
abstract class TableroBuilder {

	Tablero tablero;

    public Tablero getTablero() {
        return tablero;
    }
    
    /**
     * Genera el tablero
     */
    protected abstract void generarTablero();

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
	protected abstract void ponerCasillasBomba();
	
	
	/**
     * Coloca las casillas que restan del tablero
     */
    private void ponerCasillasRestantes() {
		tablero.rellenarCasillasRestantes();

	}

}
