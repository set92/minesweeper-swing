package com.okas.packModelo;

import java.util.ArrayList;

public class Tablero {
	private Casilla[][] campoJuego=null;
	
	public void setCampoJuego(Casilla[][] pCampo){
		campoJuego = pCampo;
	}
	
	public Casilla[][] getCampoJuego() {
			return campoJuego;
		}


	public void colocarCasilla(Coordenada pCoord, Casilla pCasilla){
		int i= pCoord.posAlto;
		int j = pCoord.posAncho;
		campoJuego[i][j] = pCasilla;	
	}
    
    public void descubrirCasilla(Casilla cas){
    	cas.descubrirCasilla();
    }

    private ListaCasillas cogerVecinos(Casilla casilla){return null;}
}
