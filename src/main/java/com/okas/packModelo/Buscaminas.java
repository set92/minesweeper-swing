package com.okas.packModelo;

import com.okas.packVista.VentanaBuscaminas;

public class Buscaminas {

	private int nivel;
    private Tablero tablero;
    private int contador = 0;
   // private int puntuacion;
    private static Buscaminas miBuscaminas = null;
    private TableroBuilder tableroBuilder;

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

    public void setTableroBuilder(TableroBuilder tabBuilder){
        tableroBuilder = tabBuilder;
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
        tablero.cancelarMinas();
        crearJuego(getNivel());
    }

    /**
     * Genera un nivel dependiendo del parametro
     * @param nivel Nivel que se quiere generar
     */
    public Tablero crearJuego(int nivel){
        switch (nivel){
            case 1: tableroBuilder = new BuilderN1();break;
            case 2: tableroBuilder = new BuilderN2();break;
            case 3: tableroBuilder = new BuilderN3();break;
            default: tableroBuilder = new BuilderN1();break;
        }

        tablero = tableroBuilder.construirTablero();
        contador = tablero.getNumMinas();
        setTableroBuilder(tableroBuilder);
        
        return tableroBuilder.getTablero();
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
     * @param pFila Fila en la que está la casilla
     * @param pColumna Columna en la que está la casilla
     */
    public void descubrirCasilla(int pFila, int pColumna) {
        tablero.descubrirCasilla(pFila,pColumna);
    }
    
    /**
     * Marca bandera en las coordenadas que te dan por parámetro
     * @param pFila Fila en la que está la casilla
     * @param pColumna Columna en la que está la casilla
     */
    public void marcarBandera(int pFila, int pColumna){
    	tablero.marcarBandera(pFila, pColumna);
    }
    
    public void desmarcarBandera(int pFila, int pColumna){
    	tablero.desmarcarBandera(pFila, pColumna);
    }

    public boolean isMarcadaBandera(int pFila, int pColumna){
    	return tablero.isMarcadaBandera(pFila,pColumna);
    }
    
    public boolean isDescubierta(int pFila, int pColumna){
    	return tablero.isDescubierta(pFila,pColumna);
    }
}
