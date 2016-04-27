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

	public void setNivel(int pNivel){
		nivel = pNivel;
	}

	public void setUsuario(Usuario pUsuario){
		user = pUsuario;
	}

	public void guardarSesion(){
		String ruta = null;
		if(nivel == 1){
			ruta = "src/main/resources/rankingNivel1.txt";
		}
		else if (nivel == 2){
			ruta = "src/main/resources/rankingNivel2.txt";
		}
		else if (nivel == 3){
			ruta = "src/main/resources/rankingNivel3.txt";
		}
		escribirEnRanking(ruta);
	}
	
	public boolean estaUsuario(String ruta, String pNombre){
		boolean esta = false;
		InputStream in = getClass().getResourceAsStream(ruta);
		BufferedReader fichero = new BufferedReader(new InputStreamReader(in));
		Scanner sc = new Scanner(fichero);
		while(sc.hasNextLine()){
			String linea = sc.nextLine();
			String[] sp = linea.split("+### +");
			String nombre = sp[0];
			if(nombre.equals(pNombre)) esta = true;
		}
		sc.close();
		return esta;
	}
	public void mereceRanking(String ruta){
		int contadorJug = 10;
		InputStream in = getClass().getResourceAsStream(ruta);
		BufferedReader fichero = new BufferedReader(new InputStreamReader(in));
		Scanner sc = new Scanner(fichero);
		while(sc.hasNextLine() && contadorJug > 0){
			String linea = sc.nextLine();
			String[] sp = linea.split("+### +");
			String nombre = sp[0];
			String tiempo = sp[1];
			if (true == true){
				try{
					BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
					bw.write(nombre+" ### "+ContadorTiempo.getGestor().getTiempo());
					bw.newLine();
					bw.close();
				} catch (IOException ioe){
					ioe.printStackTrace();
				}
			}
			contadorJug--;
		}
		sc.close();
	}
	/*public boolean menorTiempo(String tiempo){
		
	}*/
	

	public void escribirEnRanking(String ruta){
		File fichero = new File(ruta);
		if (fichero.exists()){
			System.out.println("Error Ranking");
		}
		else{
			try{
				BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
				if(!(estaUsuario(ruta,user.getNombreUsuario()))){
					mereceRanking(ruta);
				}
				bw.newLine();
				bw.close();
			} catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}

