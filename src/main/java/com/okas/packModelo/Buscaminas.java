package com.okas.packModelo;


public class Buscaminas {
    private TableroBuilder tablero;
    // private int puntuacion;
    // private int tiempo;
    private static Buscaminas miBuscaminas;
    private static boolean primeraVez = true;

    private Buscaminas() {}

    public int getAlto(){ return getTablero().getAlto(); }
    public int getAncho(){ return getTablero().getAncho(); }
    public int getNumMinas(){ return getTablero().getNumMinas(); }

    public void setTableroBuilder(TableroBuilder tb){
    	tablero = tb;
    }
    
    public Tablero getTablero(){
        if (primeraVez) {
            construirTablero();
            primeraVez = false;
        }
    	return tablero.getTablero();
    }
    
    private void construirTablero(){
    	tablero.construirTablero();
    }
   
    public static Buscaminas getBuscaminas(){
    	if (miBuscaminas == null) miBuscaminas = new Buscaminas();
    	return miBuscaminas;
    }

}
