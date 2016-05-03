package com.okas.packModelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaUsuarios {

	private ArrayList<Usuario> lista;
	
	public ListaUsuarios(){
		lista = new ArrayList<Usuario>();
	}
	
	public void cargarDatos(String pFile){
			BufferedReader f = null;
			try {
				f = new BufferedReader(new FileReader(pFile));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()){
				String linea = sc.nextLine();
				String[] sp = linea.split("\\s+");
				String nombre = sp[0];
				String puntuacion = sp[1];
				Usuario us = new Usuario(nombre, Integer.parseInt(puntuacion));
				lista.add(us);
			}
			sc.close();	
	}
	
	public String pasarListaAString(){
		String lta = new String();
		for (Usuario usuario : lista) {
			lta += usuario.getNombreUsuario()+"\t"+usuario.getPtosUsuario()+"\n";
		}
			
		return lta;
	}
	
}
