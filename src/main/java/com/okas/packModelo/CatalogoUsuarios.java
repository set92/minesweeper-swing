package com.okas.packModelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class CatalogoUsuarios {

	private static CatalogoUsuarios miCatalogoUsuarios = new CatalogoUsuarios();
	private ListaUsuarios lista = new ListaUsuarios();

	private CatalogoUsuarios()
	{
		this.cargarUsuarios("CatUsu.txt");
	}

	public static CatalogoUsuarios getCatalogoUsuarios(){
		return miCatalogoUsuarios;
	}
	
	private void cargarUsuarios(String pFileName)
	{
		InputStream in = getClass().getResourceAsStream(pFileName);
		BufferedReader fichero = new BufferedReader(new InputStreamReader(in));;
		Scanner sc = new Scanner(fichero);
		//HashMap<String, Pelicula> HashPelis = new HashMap<String,Pelicula>();
		while (sc.hasNextLine())
		{	
			String linea = sc.nextLine();
			String[] sp = linea.split(" ### ");
			String nombre = sp[0]; // El primer String es siempre el nombre y apellido del actor.
			String puntuacion = sp[1];
			int puntos = Integer.parseInt(puntuacion);
			String nivel = sp[2];
			ArrayList<String> nuevoUsuario = new ArrayList<String>();
			nuevoUsuario.add(nombre);
			nuevoUsuario.add(puntuacion);
			this.lista.addUsuario(nuevoUsuario, nivel);
		}		
		sc.close();
	}		

	public void addUser(ArrayList<String> user, int level){
		String nivel =  String.valueOf(level);
		this.lista.addUsuario(user, nivel);

		String ruta = "C://Users//Olatz//workspace//BuscaminasSegundoSprint//src//com//okas//packModelo//CatUsu.txt";
		File fichero = new File(ruta);
		if(!fichero.exists()){
			System.out.println("El fichero no existe.");
		}
		else
		{
			try{ 
				BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
				bw.write(user.get(0)+ " ### " + user.get(1) + " ### " + level); //Separamos los títulos por "###"
				bw.newLine();
				bw.close();
			} catch (IOException ioe){
				ioe.printStackTrace();
			}	
		}
	}
	public String mostrarLista(int pNivel){
		String nivel = String.valueOf(pNivel);
		return lista.getRanking(nivel);
	}




	/*private static CatalogoUsuarios miCatalogoUsuarios = null;
	private ListaUsuarios lN1;
	private ListaUsuarios lN2;
	private ListaUsuarios lN3;

	private CatalogoUsuarios(){
		lN1= new ListaUsuarios();
		lN2= new ListaUsuarios();
		lN3= new ListaUsuarios();

		lN1.cargarDatos("src/main/resources/rankingNivel1.txt");
		lN2.cargarDatos("src/main/resources/rankingNivel2.txt");
		lN3.cargarDatos("src/main/resources/rankingNivel3.txt");
	}

	public static CatalogoUsuarios getCatalogoUsuarios(){
		if (miCatalogoUsuarios == null) miCatalogoUsuarios = new CatalogoUsuarios();
		return miCatalogoUsuarios;
	}

	public void guardarUsuario(String ruta){
		switch(Buscaminas.getBuscaminas().getNivel()){
		case 1:lN1.guardarUsuario(ruta); break;
		case 2:lN2.guardarUsuario(ruta); break;
		case 3:lN3.guardarUsuario(ruta); break;
	}
	}

	public ListaUsuarios mostrarLista(int pNivel){
		ListaUsuarios lta;
		switch(pNivel){
			case 1: lta = lN1; break;
			case 2: lta = lN2; break;
			case 3: lta = lN3; break;
			default: lta = lN1; break;
		}
		return lta;
	}

	public void anadirALista(Usuario user){
		switch(Buscaminas.getBuscaminas().getNivel()){
			case 1:lN1.addUsuario(user); break;
			case 2:lN2.addUsuario(user); break;
			case 3:lN3.addUsuario(user); break;
		}
	}*/

}
