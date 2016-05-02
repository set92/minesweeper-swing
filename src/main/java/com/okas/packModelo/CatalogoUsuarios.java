package com.okas.packModelo;

public class CatalogoUsuarios {

	private static CatalogoUsuarios miCatalogoUsuarios = null;
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
	

}
