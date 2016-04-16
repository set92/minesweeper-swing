package com.okas.packModelo;

import java.util.Observer;

public abstract class Casilla extends PonerBanderasObservable {
    protected Coordenada pos;
    protected boolean marcadaBandera;
    protected boolean descubierta;

    public Casilla(Coordenada pCord){
    	this.pos = pCord;
    	this.descubierta = false;
    	this.marcadaBandera = false;
    }

    public void descubrirCasilla(){
    	if (!descubierta && !marcadaBandera) marcarDescubierta();
    }

    public Coordenada getCoordenada(){return this.pos;}
    
    public void marcarBandera(){
    	if (!descubierta){
    		if (!marcadaBandera){
    			this.marcadaBandera = true;	
    			this.notificar(-1);
    		}
 
    	}
    }
    public void desmarcarBandera(){
    	if (!descubierta){
    		if (marcadaBandera){
    			this.marcadaBandera = false;	
    			this.notificar(1);
    		}
 
    	}
    }
    
    public void desmarcarVacia(){this.marcadaBandera = false;}
    
    public void marcarDescubierta(){this.descubierta = true;}

    public boolean isDescubierta() {
        return descubierta;
    }

    public void quitarBandera() {
        this.marcadaBandera = false;
    }

    public boolean getMarcadaBandera() {
        return marcadaBandera;
    }
}
