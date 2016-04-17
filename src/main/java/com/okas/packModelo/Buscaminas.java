package com.okas.packModelo;

import com.okas.packVista.Reloj;

public class Buscaminas {

	private int nivel;
    private Tablero tablero;
    private Contador contador;
   // private int puntuacion;
    private Reloj reloj;
    private static Buscaminas miBuscaminas = null;

    private Buscaminas(){}

    public int getAlto(){ return getTablero().getAlto(); }
    public int getAncho(){ return getTablero().getAncho(); }
    public int getNumMinas(){ return getTablero().getNumMinas(); }
    public Contador getContador(){
        return contador;
    }

    public Tablero getTablero(){
        return tablero;
    }
    
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
        getTablero().cancelarMinas();
        crearJuego(getNivel());
    }

    /**
     * Genera un nivel dependiendo del parametro
     * @param nivel Nivel que se quiere generar
     */
    public void crearJuego(int nivel){
        tablero = Director.getDirector().construirTablero(nivel);
        this.nivel = nivel;
    }

}
