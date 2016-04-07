package com.okas.packModelo;

public class Contador implements IObserver{
	private int numero;
	
	public Contador(){
		numero = Buscaminas.getBuscaminas().getNumMinas();
	}
	public void update(int n){ //Depende del numero que entre (1 ó -1) suma o resta
		numero = numero + n;
	}
	
	public int getNumero() {
		return numero;
	}

}