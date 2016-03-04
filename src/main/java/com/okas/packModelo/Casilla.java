package com.okas.packModelo;

/**
 * Created by toburi on 26/02/2016.
 * Creado por toburi el 26/02/2016.
 */
public interface Casilla {
    Coordenada pos = null;
    boolean marcadaBandera = false;
    boolean descubierta = false;

    public void descubrirCasilla();

    public void marcarBandera();
}
