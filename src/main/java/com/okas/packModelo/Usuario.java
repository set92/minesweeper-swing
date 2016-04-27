package com.okas.packModelo;


public class Usuario {
    private String nombreUsuario;
    private int ptosUsuario;
    private int timeSeconds, timeMinutes;

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
