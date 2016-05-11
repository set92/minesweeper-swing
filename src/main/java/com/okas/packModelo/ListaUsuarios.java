package com.okas.packModelo;

import java.util.*;

class ListaUsuarios {

	private final HashMap<ArrayList<String>, String> lista;

	ListaUsuarios(){
		lista = new HashMap<>();
	}
	void addUsuario(ArrayList<String> user, String nivel){
		lista.put(user, nivel);
	}

	String getRanking(String nivel){
		String ranking = "Jugadores: \n";
		HashMap<String, Integer> aux = new HashMap<>();
		for (Object o : lista.entrySet()) {
			Map.Entry e = (Map.Entry) o;
			if (e.getValue().equals(nivel)) {
				ArrayList<String> user = (ArrayList<String>) e.getKey();
				aux.put(user.get(0), Integer.parseInt(user.get(1)));
			}
		}
		aux = ordenarPorValor(aux); 
		int cont = 10;
		Iterator ite = aux.entrySet().iterator();
		while (ite.hasNext() && cont != 0) {
			Map.Entry e = (Map.Entry)ite.next();
			ranking = ranking+ e.getKey() + " " + e.getValue()+"\n";
			cont--;
		}
		return ranking;
	}

    /**
     * Ordena Hashmap mirando los valores, generando un hashmap ordenado para preservar el orden de inserción
     * @param map Hashmap desordenado
     * @return Hashmap ordenado
     */
	private HashMap ordenarPorValor(HashMap map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, (o2, o1) -> ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue()));

		HashMap sortedHashMap = new LinkedHashMap();
		for (Object aList : list) {
			Map.Entry entry = (Map.Entry) aList;
			sortedHashMap.put(entry.getKey(), entry.getValue());
		} 
		return sortedHashMap;
	}

}