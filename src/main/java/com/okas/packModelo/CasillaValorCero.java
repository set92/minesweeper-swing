package com.okas.packModelo;

public class CasillaValorCero extends Casilla {

	private ListaVecinos lista;

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

	private void descubrirVecinos() {
		lista.expandirVecinos();
		
	}

}
