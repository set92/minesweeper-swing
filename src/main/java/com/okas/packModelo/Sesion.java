package com.okas.packModelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sesion {

	private Usuario user;
	private int nivel;
	private static Sesion miSesion = null;


	private Sesion(){}

	public static Sesion getSesion() {
		if (miSesion == null)
			miSesion = new Sesion();
		return miSesion;
	}

	public Usuario getUsuario(){ return user;}

	public int getNivel(){ return nivel;}

	public void setNivel(int pNivel){
		nivel = pNivel;
	}

	public void setUsuario(Usuario pUsuario){
		user = pUsuario;
	}
	public void setPuntuos(int puntos){
		user.setPtosUsuario(puntos);
	}

}