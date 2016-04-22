package com.okas.packModelo;

import com.okas.packVista.Reloj;
import com.okas.packVista.VentanaBuscaminas;

public class Buscaminas {

	private int nivel;
    private Tablero tablero;
    private int contador = 0;
   // private int puntuacion;
    private Reloj reloj;
    private static Buscaminas miBuscaminas = null;

    private Buscaminas(){}

    public int getAlto(){ return tablero.getAlto(); }
    public int getAncho(){ return tablero.getAncho(); }
    public int getNumMinas(){ return tablero.getNumMinas(); }
    public int getContador(){
        return contador;
    }
    public void setContador(int n){
    	contador = contador + n;
    }
    public Casilla[][] getCampoJuego(){ return tablero.getCampoJuego(); }
    
    public int getNivel(){
    	return nivel;
    }

    public static Buscaminas getBuscaminas(){
    	if (miBuscaminas == null){
    		miBuscaminas = new Buscaminas();
    	}
    	return miBuscaminas;
    }

    /**
     * Reiniciar el tablero de juego
     */
    public void reiniciar() {
        tablero.cancelarMinas();
        crearJuego(getNivel());
    }

    /**
     * Genera un nivel dependiendo del parametro
     * @param nivel Nivel que se quiere generar
     */
    public Tablero crearJuego(int nivel){
        tablero = Director.getDirector().construirTablero(nivel);
        this.nivel = nivel;
        contador = tablero.getNumMinas();
        return tablero;
    }
    
    /**
     * Anadir por cada casilla el Observador que trae como parámetro
     * @param ventanaBuscaminas Para anadir la VentanaBuscaminas como Observador
     */

    public void anadirObservadores(VentanaBuscaminas ventanaBuscaminas) {
        for (Casilla[] casilla : tablero.getCampoJuego()) {
            for (Casilla casilla1: casilla ){
                casilla1.addObserver(ventanaBuscaminas);//TODO Hacerlo en momento de creacion de casillas
            }
        }
    }
   
    
    /**
     * Descubre la casilla que le proporciona el parametro
     * @param casilla Casilla qe se quieres descubrir
     */

    public void descubrirCasilla(Casilla casilla) {
        tablero.descubrirCasilla(casilla);
    }

}
