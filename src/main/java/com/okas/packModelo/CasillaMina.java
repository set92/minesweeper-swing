package com.okas.packModelo;

public class CasillaMina extends Casilla {
    
	public CasillaMina(Coordenada pPos){
		super(pPos);
	}
	
	/**
     * Descubre la casilla Mina
     */
    @Override
    public void descubrirCasilla() {
    	if(!marcadaBandera) {
    		marcarDescubierta();
    		this.setChanged();
        	this.notifyObservers("descubrirCasilla,"+pos.getAlto()+","+pos.getAncho());
    	}    
    }
}
