package com.okas.packModelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListaUsuarios {

	private HashMap<ArrayList<String>, String> lista;

	public ListaUsuarios(){
		lista = new HashMap<ArrayList<String>,String>();
	}
	public void addUsuario(ArrayList<String> user, String nivel){
		lista.put(user, nivel);
	}

	public String getRanking(String nivel){
		ArrayList<String> ranking = new ArrayList<String>();
		HashMap<String, String> aux = new HashMap<String, String>();
		Iterator it = lista.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println(e.getKey()+" "+e.getValue());
			if(e.getValue().equals(nivel)){
				ArrayList<String> user = (ArrayList<String>) e.getKey();
				aux.put(user.get(0), user.get(1));
			}
		}
		System.out.println("paso 2");
		aux = ordenarPorValor(aux); 

		System.out.println("paso 3");
		for(int i = 0; i< 10 ; i++){
			Iterator ite = aux.entrySet().iterator();
			while (ite.hasNext()) {
				Map.Entry e = (Map.Entry)ite.next();
				String top = e.getKey() + " " + e.getValue();
				ranking.add(top);
			}
		}
		String lta = new String();
		for (String str : ranking) {
			lta +=str+"\n";
		}
		return lta;
	}


	private HashMap ordenarPorValor(HashMap map) { 
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		} 
		return sortedHashMap;
	}


	public String pasarListaAString(ArrayList<String> lista){
		String lta = new String();
		for (String str : lista) {
			lta +=str+"\n";
		}
		return lta;
	}

}

/*public void guardarUsuario(String ruta){
		File fichero = new File(ruta);
		if (!fichero.exists()){
			System.out.println("Error Ranking");
		}
		else{
			try{
				BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
				bw.write(Sesion.getSesion().getUsuario().getNombreUsuario()+" ### "+Sesion.getSesion().getUsuario().getPtosUsuario());
				bw.newLine();
				bw.close();
			} catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}*/


/*public String pasarListaAString(){
		String lta = new String();
		for (Usuario usuario : lista) {
			lta += usuario.getNombreUsuario()+"\t"+usuario.getPtosUsuario()+"\n";
		}

		return lta;
	}*/

