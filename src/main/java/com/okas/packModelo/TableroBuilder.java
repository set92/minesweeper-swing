package com.okas.packModelo;

public abstract class TableroBuilder {
	
	//TODO en todos los taberos de niveles mirar parametros y si hay Override
	
	protected Tablero tablero;
	
	public Tablero getTablero(){return this.tablero;}
	
	public void construirTablero(){this.tablero = new Tablero();}
	
	public abstract void ponerCasillasBomba(); //Primer paso
	
	public abstract void ponerCasillasValor(); //Segundo paso
	
	public abstract void ponerCasillasRestantes(); //Tercer paso	
}
