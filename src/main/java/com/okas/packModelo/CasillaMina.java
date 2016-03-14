package com.okas.packModelo;

public class CasillaMina extends Casilla {
    
	public CasillaMina(Coordenada pPos){
		super(pPos);
	}
	
    @Override
    public void descubrirCasilla() {
    	System.out.println("casillaBomba");
    	marcarDescubierta();
    	System.out.println("se ha acabado el juego");

    }
}
