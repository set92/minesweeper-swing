package com.okas.packModelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CasillaValorCeroTest {

	Coordenada c1;
	Coordenada c2;
	Coordenada c3;
	
	ListaCasillas lista;
	
	Casilla cas1;
	Casilla cas2;
	Casilla cas3;

	@Before
	public void setUp() throws Exception {
		c1 = new Coordenada(1,3);
		c2 = new Coordenada(2,5);
		c3 = new Coordenada(5,8);
		
		lista = new ListaCasillas();
		
		cas1 = new CasillaValorCero(c1);
		cas2 = new CasillaValorCero(c2);
		cas3 = new CasillaValorCero(c3);
	}

	@Test
	public void test() {
		lista.getListCasilla().add(cas2);
		lista.getListCasilla().add(cas3);
		((CasillaValorCero) cas1).setLista(lista);
		
		//LISTA DE VECINOS
		//((CasillaValorCero) cas1).descubrirVecinos();
		assertTrue(((CasillaValorCero) cas1).getLista()==lista);
		assertTrue(((CasillaValorCero) cas2).isDescubierta());
	}

}
