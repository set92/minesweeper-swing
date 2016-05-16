package com.okas.packModelo;

/**
 * Clase encargada de ejecutar las acciones de una casilla tipo CasillaMina
 */
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
            ContadorTiempo.getGestor().setRunning(false);
    		this.setChanged();
        	this.notifyObservers("descubrirCasilla,"+pos.getAlto()+","+pos.getAncho());
    	}    
    }
}
