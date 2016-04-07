package com.okas.packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Observable {

	private ArrayList<IObserver> lista;
	
	public void anadirObservador(IObserver pOb){
		lista.add(pOb);
	}
	public void eleminarObservador(IObserver pOb){
		lista.remove(pOb);
	}
	

	
	public void notificar(int n){
		IObserver observador;
		Iterator it = lista.iterator();
		while (it.hasNext()){
			observador = (IObserver)it.next();
			observador.update(n);
		}
	}
}
