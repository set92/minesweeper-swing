package com.okas.packModelo;

public abstract class TableroBuilder {
	
	//TODO en todos los taberos de niveles mirar parametros y si hay Override
	
	protected Tablero tablero;
	
	public Tablero getTablero(){return this.tablero;}
	
	public void construirTablero(){
		Tablero tablero = new Tablero();
	}

	
	public void incrementarAlrededores(Coordenada coordenadaAct)
	{
		int alto = coordenadaAct.getAlto();
		int ancho = coordenadaAct.getAncho();
		for(int i=alto-1; i<alto+1;i++){
			for (int j = ancho-1;j<ancho+1;j++){
				if(i!=1 && j!=1){
					Casilla casillaActual = tablero.getCampoJuego()[i][j];
					if (casillaActual !=null){
						if (casillaActual instanceof CasillaValor){
							((CasillaValor) casillaActual).incrementarValor();
						}
						else if (casillaActual instanceof CasillaValorCero){
							CasillaValor nuevaCasilla = new CasillaValor(coordenadaAct);
							tablero.getCampoJuego()[i][j] = nuevaCasilla;
						}
					}
				}
			}
		}
	}
	
	public abstract void rellenarTableroDeCasillasVacias();
	
	public abstract void ponerCasillasBomba(); //Primer paso
	
	public abstract void ponerCasillasValor(); //Segundo paso
	
	public abstract void ponerCasillasRestantes(); //Tercer paso	
}
