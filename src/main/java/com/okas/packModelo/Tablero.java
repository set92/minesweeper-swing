package com.okas.packModelo;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> campoJuego;
    private int alto;
    private int ancho;
    private int numMinas;
    
    public Tablero(int pAlto, int pAncho, int pNumMinas) {
        this.campoJuego = new ArrayList<Casilla>();
        this.alto = pAlto;
        this.ancho = pAncho;
        this.numMinas = pNumMinas;
    }

    private void crearTablero(){}
    
    public void descubrirCasilla(Casilla cas){
    	cas.descubrirCasilla();
    }

    private void ponerMinas(){}
    
    private void incrementarAlrededores(Coordenada coordenadaAct){}

    private ListaVecinos cogerVecinos(Casilla casilla){return null;}
}
