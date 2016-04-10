package com.okas.packModelo;

public class PonerBanderasObservable {

	private IObserver observer;
	
	public void cambiarObserver (IObserver pOb)
	{
		observer = pOb;
	}
	
    public void modificarContador(int n){
        //setChanged()
        observer.update(n);
    }

}
