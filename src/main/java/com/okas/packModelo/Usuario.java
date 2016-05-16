package com.okas.packModelo;

/**
 * Clase encargada de gestionar el estado del usuario
 */
public class Usuario {
	
    private final String nombreUsuario;
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
        this.ptosUsuario = (1000/ptosUsuario);
    }
}
