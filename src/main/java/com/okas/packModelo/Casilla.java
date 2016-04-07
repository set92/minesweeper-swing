package com.okas.packModelo;

public abstract class Casilla extends Observable {
    protected Coordenada pos;
    protected boolean marcadaBandera;
    protected boolean descubierta;

    public Casilla(Coordenada pCord){
    	this.pos = pCord;
    	this.descubierta = false;
    	this.marcadaBandera = false;
    }
    
    public void descubrirCasilla(){
    	if (!descubierta) marcarDescubierta();
    }

    public Coordenada getCoordenada(){return this.pos;}
    
    public void marcarBandera(){
    	this.marcadaBandera = true;
    	this.notificar(1);
    	}
    
    public void desmarcarVacia(){this.marcadaBandera = false;}
    
    public void marcarDescubierta(){this.descubierta = true;}

    public boolean isDescubierta() {
        return descubierta;
    }

    public void quitarBandera() {
        this.marcadaBandera = false;
        this.notificar(-1);
    }

    public boolean getMarcadaBandera() {
        return marcadaBandera;
    }
}