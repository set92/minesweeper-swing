package com.okas.packModelo;

/**
 * Created by toburi on 26/03/2016.
 * Creado por toburi el 26/03/2016.
 */
public class Usuario {
    private String nombreUsuario;
    private int ptosUsuario;

    public Usuario(String nombreUsuario, int ptosUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.ptosUsuario = ptosUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getPtosUsuario() {
        return ptosUsuario;
    }

    public void setPtosUsuario(int ptosUsuario) {
        this.ptosUsuario = ptosUsuario;
    }
}
