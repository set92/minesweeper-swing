package com.okas.packModelo;

public abstract class TableroBuilder {
	
	protected Tablero tablero;
	
	public Tablero getTablero(){return this.tablero;}
	
	public void construirTablero(){
		tablero.ponerCasillasBomba();
		tablero.rellenarCasillasRestantes();
		tablero.crearListas();
	}
	
	public abstract void ponerCasillasBomba(); //Primer paso
	
	public abstract void ponerCasillasRestantes(); //Tercer paso
	
}
