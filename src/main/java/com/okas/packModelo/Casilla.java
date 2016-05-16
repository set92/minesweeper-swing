package com.okas.packModelo;

import java.util.Observable;

/**
 * Clase encargada de ejecutar las acciones de las casillas
 */
public abstract class Casilla extends Observable {
    final Coordenada pos;
    boolean marcadaBandera;
    boolean descubierta;

    Casilla(Coordenada pCord){
    	this.pos = pCord;
    	this.descubierta = false;
    	this.marcadaBandera = false;
    }
    
    /**
     * Descubre la casilla
     */
    public void descubrirCasilla(){
    	if (!descubierta && !marcadaBandera){
    		marcarDescubierta();
    		this.setChanged();
        	this.notifyObservers("descubrirCasilla,"+pos.getAlto()+","+pos.getAncho());
    	}
    }

    public Coordenada getCoordenada(){return this.pos;}
    
    
    /**
     * Poner una bandera en la casilla
     */
    public void marcarBandera(){
    	if (!descubierta) {
    		if (!marcadaBandera){
    			this.marcadaBandera = true;	
    	    	this.setChanged();
    	    	this.notifyObservers("marcarBandera,"+pos.getAlto()+","+pos.getAncho());
    		}
    	}
    	
    }
    
    /**
     * Quita la bandera de la casilla
     */

    public void desmarcarBandera(){
    	if (!descubierta) {
    		if (marcadaBandera){
    			desmarcarVacia();	
    	    	this.setChanged();
    	    	this.notifyObservers("desmarcarBandera,"+pos.getAlto()+","+pos.getAncho());
    		}
    	}
    }
    
    
    /**
     * Quita la bandera
     */

    private void desmarcarVacia(){this.marcadaBandera = false;}
    
    
    /**
     * Descubre la casilla
     */
    
    public void marcarDescubierta(){this.descubierta = true;}
    
    
    /**
     * Nos dice si la casilla está descubierta o no
     */
    public boolean isDescubierta(){
    	return descubierta;
    }
    

    public boolean getMarcadaBandera(){
    	return marcadaBandera;
    }

}
