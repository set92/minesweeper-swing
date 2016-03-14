package com.okas.packModelo;


public class Buscaminas {
    private TableroBuilder tablero;
   // private int puntuacion;
   // private int tiempo;
    private static Buscaminas miBuscaminas;


    private Buscaminas() {
    	
    }
    
    
    public void setTableroBuilder(TableroBuilder tb){
    	tablero = tb;
    }
    
    public Tablero getTablero(){
    	construirTablero();
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
