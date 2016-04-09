package com.okas.packModelo;

public class DescubrirCasillaObservable extends java.util.Observable {

    public DescubrirCasillaObservable() {
        super();
    }

    public void changeData(Casilla data){
        setChanged();
        notifyObservers(data);
    }

}
