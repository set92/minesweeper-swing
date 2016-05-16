package com.okas.packModelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase encargada de guardar el registro de todos los usuarios que han jugado
 */
public class CatalogoUsuarios {

	private static CatalogoUsuarios miCatalogoUsuarios = null;
	private ListaUsuarios lista = new ListaUsuarios();

	private CatalogoUsuarios() {
		cargarUsuarios();
	}

	public static CatalogoUsuarios getCatalogoUsuarios(){
		if (miCatalogoUsuarios == null) miCatalogoUsuarios = new CatalogoUsuarios();
		return miCatalogoUsuarios;
	}
	
	/**
	 * Cargar los usuarios desde un fichero
	 */
	public void cargarUsuarios() {
		BufferedReader fichero = null;
		try {
			fichero = new BufferedReader(new FileReader("src/main/resources/CatUsu.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Scanner sc = new Scanner(fichero);

		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			String[] sp = linea.split(" ### ");
			String nombre = sp[0]; // El primer String es siempre el nombre y apellido del actor.
			String puntuacion = sp[1];
			String nivel = sp[2];
			ArrayList<String> nuevoUsuario = new ArrayList<>();
			nuevoUsuario.add(nombre);
			nuevoUsuario.add(puntuacion);
			lista.addUsuario(nuevoUsuario, nivel);
		}		
		sc.close();
	}		

	/**
	 * Añadir un nuevo usuario al ranking
	 * @param user nombre y puntos del usuario
	 * @param level nivel del usuario
	 */
	void addUser(ArrayList<String> user, int level){
		String nivel =  String.valueOf(level);
		this.lista.addUsuario(user, nivel);

		String ruta = "src/main/resources/CatUsu.txt";
		File fichero = new File(ruta);
		if(!fichero.exists()){
			System.out.println("El fichero no existe.");
		}
		else {
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
	
	/**
	 * Mostrar la lista del ranking de un nivel seleccionado
	 * @param pNivel Nivel del que queremos conocer el ranking
	 * @return Lista del rankig seleccionado
	 */
	public String mostrarLista(int pNivel){
		return lista.getRanking(String.valueOf(pNivel));
	}

}
