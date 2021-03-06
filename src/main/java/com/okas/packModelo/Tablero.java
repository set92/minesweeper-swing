package com.okas.packModelo;

import java.util.Random;

/**
 * Clase encargada de gestionar todas las acciones del tablero del buscaminas
 */
public class Tablero {

	private final int alto;
	private final int ancho;
	private int numMinas;
	private final Casilla[][] campoJuego;
	private static boolean minasPuestas = false;//Flag para ver si estan puestas las minas

	/**
	 * Para reiniciar el tablero, ponemos a false el chivato de las minas
	 */
	public void cancelarMinas() {
		minasPuestas = false;
	}

	public Tablero(int pAlto, int pAncho) {
		alto = pAlto;
		ancho = pAncho;
		campoJuego = new Casilla[pAlto][pAncho];
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public int getNumMinas() {
		return numMinas;
	}

	public Casilla[][] getCampoJuego() {
		return campoJuego;
	}

	/**
	 * Colocamos la casilla que nos trae como parámetro en la coordenada que nos trae como parámetro
	 * @param pCoord Coordenada donde queremos meter la casilla
	 * @param pCasilla Casilla que queremos colocar
	 */
	public void colocarCasilla(Coordenada pCoord, Casilla pCasilla) {
		if (this.esValida(pCoord.getAlto(), pCoord.getAncho())) {
			int i = pCoord.getAlto();
			int j = pCoord.getAncho();
			campoJuego[i][j] = pCasilla;
		}
	}

	/**
	 * Descubrir la casilla
	 * @param pFila posicion en Y de la casilla que queremos descubrir
     * @param pColumna posicion en X de la casilla que queremos descubrir
	 */
	public void descubrirCasilla(int pFila, int pColumna) {
		if (this.esValida(pFila, pColumna))
			campoJuego[pFila][pColumna].descubrirCasilla();
	}

	/**
	 * Saber si la casilla que nos trae como parámetro es válida o no
     * @param pFila posicion en Y de la casilla que se modifica
     * @param pColumna posicion en X de la casilla que se modifica
	 */
    private boolean esValida(int pFila, int pColumna){
		return (pColumna >= 0 && pColumna < ancho && pFila >= 0 &&  pFila < alto);

	}

	/**
	 * Poner bandera en la casilla que nos trae como parámetros
     * @param pFila posicion en Y de la casilla que se modifica
     * @param pColumna posicion en X de la casilla que se modifica
	 */
	public void marcarBandera(int pFila, int pColumna){
		if (this.esValida(pFila,pColumna))
			campoJuego[pFila][pColumna].marcarBandera();
	}

	/**
	 * Quitar bandera en la casilla que nos trae como parámetros
     * @param pFila posicion en Y de la casilla que se modifica
     * @param pColumna posicion en X de la casilla que se modifica
	 */
	public void desmarcarBandera(int pFila, int pColumna){
		if (this.esValida(pFila,pColumna))
			campoJuego[pFila][pColumna].desmarcarBandera();
	}

	/**
	 * Crea la lista de las Casillas de alrededor de las casillas de valor cero
	 */
	public void crearListas() {
		Casilla cas;
		ListaCasillas lista;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				cas = campoJuego[i][j];
				if (cas instanceof CasillaValorCero) {
					lista = cogerVecinos(cas);
					((CasillaValorCero) cas).setLista(lista);
				}
			}
		}
	}

	/**
	 * Coge los vecinos de la casilla que nos dan como parámetro
	 * @param casilla Casilla a la que queremos añadir la listaCasillas
	 */
	private ListaCasillas cogerVecinos(Casilla casilla) {
		ListaCasillas lista = new ListaCasillas();
		int aalto = casilla.getCoordenada().getAlto();
		int aancho = casilla.getCoordenada().getAncho();
		for (int i = aalto - 1; i <= aalto + 1; i++) {
			for (int j = aancho - 1; j <= aancho + 1; j++) {
				if (esValida(i,j)) {
					if (!campoJuego[aalto][aancho].equals(campoJuego[i][j]))
						lista.getListCasilla().add(campoJuego[i][j]);
				}
			}
		}
		return lista;
	}

	/**
	 * Rellena con CasillaValorCero las casillas que no se han rellenado aún
	 */
	public void rellenarCasillasRestantes() {
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				if (esValida(i,j)) {
					if (campoJuego[i][j] == null) {
						Coordenada coordenadaActual = new Coordenada(i, j);
						Casilla casillaActual = CasillaFactory.getCasillaFactory().createCasilla("Cero",
								coordenadaActual);
						colocarCasilla(coordenadaActual, casillaActual);
					}
				}
			}
		}
		this.imprimirCampo();
	}

	/**
	 * Rellenamos el tablero con el numero de minas que nos dan como parámetro
	 * @param pMinas Numero de minas
	 */
	public void ponerCasillasBomba(int pMinas) {
		numMinas=pMinas; 
		int contador = numMinas;
		Random rn = new Random();
		int x;
		int numeroAleatorio, numeroAleatorio2;
		if (!minasPuestas){
			while (contador != 0) {
				x = rn.ints(0, alto).findFirst().getAsInt();
				numeroAleatorio = x;
				x = rn.ints(0, ancho).findFirst().getAsInt();
				numeroAleatorio2 = x;
				Casilla unaCasilla = campoJuego[numeroAleatorio][numeroAleatorio2];
				if (!(unaCasilla instanceof CasillaMina)) {
					Coordenada nuevaPos = new Coordenada(numeroAleatorio, numeroAleatorio2);
					Casilla nuevaMina = CasillaFactory.getCasillaFactory().createCasilla("Mina",
							nuevaPos);
					campoJuego[numeroAleatorio][numeroAleatorio2] = nuevaMina;
					incrementarAlrededores(nuevaMina.pos);
					contador--;
				}
			}
			minasPuestas = true;
		}
	}

	/**
	 * Incrementa en 1 las casillas de alrededor de la casilla con la coordenada que nos dan como parámetro
	 * @param coordenadaAct Para saber que hay que incrementar las casillas de las coordenadas de alrededor
	 */
	private void incrementarAlrededores(Coordenada coordenadaAct) {
		int altoMina = coordenadaAct.getAlto();
		int anchoMina = coordenadaAct.getAncho();
		for (int i = altoMina - 1; i <= altoMina + 1; i++) {
			for (int j = anchoMina - 1; j <= anchoMina + 1; j++) {
				if (esValida(i,j)) {
					Casilla casillaActual = campoJuego[i][j];
					if (casillaActual != null) {
						if (casillaActual instanceof CasillaValor) {
							((CasillaValor) casillaActual).incrementarValor();
						} else if (casillaActual instanceof CasillaValorCero) {
							campoJuego[i][j] = CasillaFactory.getCasillaFactory().createCasilla("Valor", casillaActual.getCoordenada());
						}
					} else if (casillaActual == null) {
						Coordenada coor = new Coordenada(i,j);
						campoJuego[i][j] = CasillaFactory.getCasillaFactory().createCasilla("Valor", coor);
					}
				}
			}
		}
	}

	/**
	 * Imprime por pantalla el tablero
	 */
	public void imprimirCampo() {
		String res = "";
		for (int s = 0; s < alto; s++) {
			for (int c = 0; c < ancho; c++) {
				if (campoJuego[s][c] instanceof CasillaMina)
					res += "\t" + "B";
				else if (campoJuego[s][c] instanceof CasillaValor)
					res += "\t" + ((CasillaValor) campoJuego[s][c]).getValor();
				else if (campoJuego[s][c] instanceof CasillaValorCero)
					res += "\t" + "0";
				else if (campoJuego[s][c] == null)
					res += "\t" + "n";
			}
			res += "\n";
		}
		System.out.println(res);
	}

	public boolean isMarcadaBandera(int pFila, int pColumna) {
		return campoJuego[pFila][pColumna].getMarcadaBandera();
	}

	public boolean isDescubierta(int pFila, int pColumna) {
		return campoJuego[pFila][pColumna].isDescubierta();
	}
}
