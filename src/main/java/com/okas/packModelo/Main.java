package com.okas.packModelo;

import com.okas.packVista.VentanaBuscaminas;

public class Main {

	public static void main(String[] args) {
		TableroBuilder tb = new BuilderN1();
		tb.construirTablero();
		Buscaminas.getBuscaminas().setTableroBuilder(tb);
//		Casilla[][] cs = tb.getTablero().getCampoJuego();
//
//		Casilla c1 = cs[1][3];
//		tb.getTablero().descubrirCasilla(c1);
//		tb.getTablero().imprimirCampoDescubierto();
        VentanaBuscaminas.getVentana().setVisible(true);
	}

}
