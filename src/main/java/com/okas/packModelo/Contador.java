package com.okas.packModelo;

public class Contador {
	private int numero = Buscaminas.getBuscaminas().getNumMinas();
	
	public void update(int n){ //Depende del numero que entre (1 ó -1) suma o resta
		numero = numero + n;
	}

}
