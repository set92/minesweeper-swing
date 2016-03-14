package com.okas.packModelo;

public class CasillaValorCero extends Casilla {

	private ListaCasillas lista;

	public CasillaValorCero(Coordenada pCord) {
		super(pCord);
	}
	
	@Override
	public void descubrirCasilla(){
		if (!descubierta){
			marcarDescubierta();
			descubrirVecinos();
		}
	}
	
	
	public ListaCasillas getLista(){return this.lista;}
	
	public void setLista(ListaCasillas pLista){
		lista = pLista;
	}

	private void descubrirVecinos() {
		lista.expandirVecinos();
		
	}

}
