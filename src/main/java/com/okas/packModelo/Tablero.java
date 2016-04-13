package com.okas.packModelo;

import java.util.Random;

public class Tablero {

	private int alto;
	private int ancho;
	private int numMinas;
	private Casilla[][] campoJuego;
    private static boolean minasPuestas = false;//Flag para ver si estan puestas las minas

	public void cancelarMinas()
	{
		minasPuestas=false;
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

	public void colocarCasilla(Coordenada pCoord, Casilla pCasilla) {
		if (this.coordenadaValida(pCoord))
		{
			int i = pCoord.getAlto();
			int j = pCoord.getAncho();
			campoJuego[i][j] = pCasilla;
		}
	}
	public boolean coordenadaValida(Coordenada pCoord){
		boolean valid = false;
		if (pCoord.getAlto() >= 0 && pCoord.getAncho() >= 0){
			if (pCoord.getAlto() <= this.alto && pCoord.getAncho() <= this.ancho){
				valid = true;
			}
		}
		return valid;
	}	

	public void descubrirCasilla(Casilla cas) {
		if (this.esValida(cas))
			cas.descubrirCasilla();
	}
	
	public boolean esValida (Casilla cas){
		boolean valida = false;
		if (cas.getCoordenada().getAlto() >= 0 && cas.getCoordenada().getAncho() >= 0){
			if (cas.getCoordenada().getAlto() <= this.alto && cas.getCoordenada().getAncho() <= this.ancho){
				valida = true;
			}
		}
		return valida;
	}
	
	public void marcarBandera(Casilla cas){
		if (this.esValida(cas))
			cas.marcarBandera();
	}
	
	public void desmarcarBandera(Casilla cas){
		if (this.esValida(cas))
			cas.desmarcarBandera();
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
                    CasillaMina nuevaMina = new CasillaMina(nuevaPos);
                    campoJuego[numeroAleatorio][numeroAleatorio2] = nuevaMina;
                    incrementarAlrededores(nuevaMina.pos);
                    contador--;
                }
            }
            minasPuestas = true;
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
}
