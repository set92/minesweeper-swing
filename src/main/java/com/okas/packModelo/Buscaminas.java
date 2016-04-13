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
    
    public Buscaminas reiniciarBuscaminas()
    {
    	miBuscaminas = new Buscaminas();
    	return miBuscaminas;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    public int getNivel(){
    	return nivel;
    }
    
    public void reiniciar(){
    	getTablero().cancelarMinas();
		crearJuego(getNivel());
    }

    public static Buscaminas getBuscaminas(){
    	if (miBuscaminas == null){
    		miBuscaminas = new Buscaminas();
    	}
    	return miBuscaminas;
    }

    public void crearJuego(int nivel){
        tablero = Director.getDirector().construirTablero(nivel);
        this.nivel = nivel;
    }

}
