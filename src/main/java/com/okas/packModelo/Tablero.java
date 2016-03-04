package com.okas.packModelo;

import java.util.ArrayList;

/**
 * Created by toburi on 26/02/2016.
 * Creado por toburi el 26/02/2016.
 */
public class Tablero {
    private ArrayList<Casilla> campoJuego;
    private int alto;
    private int ancho;
    private int numMinas;
    
    public Tablero(ArrayList<Casilla> campoJuego, int alto, int ancho) {
        this.campoJuego = campoJuego;
        this.alto = alto;
        this.ancho = ancho;
    }

    private void crearTablero(){

    }

    public void descubrirCasilla(Casilla cas){
//        if (!cas.descubierta){
//            if (!cas.marcadaBandera){
//                if (cas.tieneMina){
//                    //GAMEOVER
//                }else{
//                    cas.descubrirCasilla();
//                }
//            }
//        }

    }

    private void ponerMinas(){
      
    }
    
    private void incrementarAlrededores(Coordenada coordenadaAct){
      
    }

    private ListaVecinos cogerVecinos(Casilla casilla){
      return null;
    }
    
    private void descubrirVecinos(ListaVecinos lista){
        
    }
}
