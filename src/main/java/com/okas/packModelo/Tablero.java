package com.okas.packModelo;

import java.util.Random;

public class Tablero {
	public int alto;
	public int ancho;
	public int numMinas;
	private Casilla[][] campoJuego;

	public Tablero() {
		alto = 10;
		ancho = 10;
		numMinas = 7;
	}

	public Tablero(int pAlto, int pAncho, int pNumMinas) {
		alto = pAlto;
		ancho = pAncho;
		numMinas = pNumMinas;
		campoJuego = new Casilla[pAlto][pAncho];
	}

	public void setCampoJuego(Casilla[][] pCampo) {
		campoJuego = pCampo;
	}

	public Casilla[][] getCampoJuego() {
		return campoJuego;
	}

	public void colocarCasilla(Coordenada pCoord, Casilla pCasilla) {
		int i = pCoord.posAlto;
		int j = pCoord.posAncho;
		campoJuego[i][j] = pCasilla;
	}

	public void descubrirCasilla(Casilla cas) {
		cas.descubrirCasilla();
	}

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

	private ListaCasillas cogerVecinos(Casilla casilla) {
		ListaCasillas lista = new ListaCasillas();
		int aalto = casilla.getCoordenada().getAlto();
		int aancho = casilla.getCoordenada().getAncho();
		for (int i = aalto - 1; i <= aalto + 1; i++) {
			for (int j = aancho - 1; j <= aancho + 1; j++) {
				if (j >= 0 && j < ancho && i >= 0 && i < alto) {
					if (!campoJuego[aalto][aancho].equals(campoJuego[i][j]))
						lista.getListCasilla().add(campoJuego[i][j]);
				}
			}
		}
		return lista;
	}

	public void rellenarCasillasRestantes() {

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				if (j >= 0 && j < ancho && i >= 0 && i < alto) {
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

	public void ponerCasillasBomba() {
		int contador = numMinas;
		Random rn = new Random();
		int x;
		int numeroAleatorio, numeroAleatorio2;
		while (contador != 0) {
			x = rn.ints(0, alto).findFirst().getAsInt();
			numeroAleatorio = x;
			x = rn.ints(0, ancho).findFirst().getAsInt();
			numeroAleatorio2 = x;
			Casilla unaCasilla = campoJuego[numeroAleatorio][numeroAleatorio2];
			if (!(unaCasilla instanceof CasillaMina)) {
				Coordenada nuevaPos = new Coordenada(numeroAleatorio, numeroAleatorio2);
				CasillaMina nuevaMina = new CasillaMina(nuevaPos);
				campoJuego[numeroAleatorio][numeroAleatorio2] = nuevaMina;
				incrementarAlrededores(nuevaMina.pos);
				contador--;
			}
		}
	}

	private void incrementarAlrededores(Coordenada coordenadaAct) {
		int aalto = coordenadaAct.getAlto();
		int aancho = coordenadaAct.getAncho();
		for (int i = aalto - 1; i <= aalto + 1; i++) {
			for (int j = aancho - 1; j <= aancho + 1; j++) {
				if ((j >= 0) && (j < ancho) && (i >= 0) && (i < alto)) {
					Casilla casillaActual = campoJuego[i][j];
					if (casillaActual != null) {
						if (casillaActual instanceof CasillaValor) {
							((CasillaValor) casillaActual).incrementarValor();
						} else if (casillaActual instanceof CasillaValorCero) {
							campoJuego[i][j] = new CasillaValor(coordenadaAct);
						}
					} else if (casillaActual == null) {
						campoJuego[i][j] = new CasillaValor(coordenadaAct);
					}
				}
			}
		}
	}

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

	public void imprimirCampoDescubierto() {
		String res = "";
		for (int s = 0; s < alto; s++) {
			for (int c = 0; c < ancho; c++) {
				if (campoJuego[s][c].descubierta)
					res += "\t" + "D";
				else
					res += "\t" + "N";
			}
			res += "\n";
		}
		System.out.println(res);
	}

}
