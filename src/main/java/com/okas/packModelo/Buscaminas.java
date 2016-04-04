package com.okas.packModelo;


public class Buscaminas {

    private Tablero tablero;
    private Contador contador;
   // private int puntuacion;
   // private int tiempo;
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

    public static Buscaminas getBuscaminas(){
    	if (miBuscaminas == null){
    		miBuscaminas = new Buscaminas();
    	}
    	return miBuscaminas;
    }

    public void crearJuego(int nivel){
        tablero = Director.getDirector().construirTablero(nivel);
    }

}
