package com.okas.packModelo;

import java.util.ArrayList;

public class Buscaminas {
    private TableroBuilder tablero;
    private int puntuacion;
    private int tiempo;
    private static Buscaminas miBuscaminas;


    private Buscaminas() {
    	//TODO completar constructora
    	
    }
   
    /*
    //ESTO NO ES PARTE DEL CÓDIGO A IMPLEMENTAR, ES SIMPLEMENTE UN EJEMPLO QUE NOS SIRVE A SERGIO Y A MI.
    public static void main(String args[]){
    	Coordenada cor = new Coordenada(1,3);
    	Casilla casm = new CasillaValor(cor);
    	Casilla casv = new CasillaValor(cor);
    	ArrayList<Casilla> cas = new ArrayList<Casilla>();
    	cas.add(casm);
    	cas.add(casv);
    	for (Casilla casil : cas ) casil.marcarBandera();    	
	}
    */
   
    
    public static Buscaminas getBuscaminas(){
    	if (miBuscaminas == null) miBuscaminas = new Buscaminas();
    	return miBuscaminas;
    }

    private void generarTablero(){
    	
    }
}
