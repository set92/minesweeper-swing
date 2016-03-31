package com.okas.packModelo;


public class Buscaminas {

    private TableroBuilder tableroBuilder;
    private Tablero tablero;
   // private int puntuacion;
   // private int tiempo;
    private static Buscaminas miBuscaminas = null;

    private Buscaminas(){}

    public int getAlto(){ return getTablero().getAlto(); }
    public int getAncho(){ return getTablero().getAncho(); }
    public int getNumMinas(){ return getTablero().getNumMinas(); }
    public void setTableroBuilder(TableroBuilder tabBuilder){
        tableroBuilder = tabBuilder;
    }

    public static Buscaminas getBuscaminas(){
    	if (miBuscaminas == null){
    		miBuscaminas = new Buscaminas();
    	}
    	return miBuscaminas;
    }
    
    public Tablero getTablero(){
    	return tablero;
    }

    public void crearJuego(int nivel){
        switch (nivel){
            case 1: tableroBuilder = new BuilderN1();break;
            case 2: tableroBuilder = new BuilderN2();break;
            case 3: tableroBuilder = new BuilderN3();break;
            default: tableroBuilder = new BuilderN1();break;
        }

        tableroBuilder.construirTablero();
        this.setTableroBuilder(tableroBuilder);
        tablero = tableroBuilder.getTablero();
    }

}
