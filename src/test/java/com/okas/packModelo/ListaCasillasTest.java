package com.okas.packModelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaCasillasTest {
	
	ListaCasillas lista;
	
	Casilla cas0;
	Casilla cas1;
	Casilla cas2;
	
	@Before
	public void setUp() throws Exception {
		lista = new ListaCasillas();
		
		cas0 = new CasillaValor(new Coordenada(1,1));
		cas1 = new CasillaValor(new Coordenada(2,2));
		cas2 = new CasillaValor(new Coordenada(1,2));
	}

	@Test
	public void test() {
		lista.getListCasilla().add(cas0);
		lista.getListCasilla().add(cas1);
		lista.getListCasilla().add(cas2);
		
		lista.expandirVecinos();
		assertTrue(cas0.isDescubierta());
		assertTrue(cas1.isDescubierta());
		assertTrue(cas2.isDescubierta());
		
	}

}
