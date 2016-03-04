package com.okas.packModelo;

public interface Casilla {
    Coordenada pos = null;
    boolean marcadaBandera = false;
    boolean descubierta = false;

    public void descubrirCasilla();

    public void marcarBandera();
}
