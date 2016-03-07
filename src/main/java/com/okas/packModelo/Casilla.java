package com.okas.packModelo;

public abstract class Casilla {
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

    public void marcarBandera(){this.marcadaBandera = true;}
    
    public void marcarDescubierta(){this.descubierta = true;}
}
