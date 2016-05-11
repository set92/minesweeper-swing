package com.okas.packModelo;

public class CasillaValorCero extends Casilla {

	private ListaCasillas lista;

	public CasillaValorCero(Coordenada pCord) {
		super(pCord);
	}
	
	/**
     * Descubre la casilla de valor cero
     */
	@Override
	public void descubrirCasilla(){
		if (!marcadaBandera) {
			if (!descubierta) {
				marcarDescubierta();
				descubrirVecinos();
				this.setChanged();
	        	this.notifyObservers("descubrirCasilla,"+pos.getAlto()+","+pos.getAncho());
			}
		}
	}
	
	
	public ListaCasillas getLista(){return this.lista;}
	
	public void setLista(ListaCasillas pLista){
		lista = pLista;
	}

	/**
     * Descubre las casillas de alrededor de la casilla de valor cero
     */
	private void descubrirVecinos() {
		lista.expandirVecinos();
		
	}
}
