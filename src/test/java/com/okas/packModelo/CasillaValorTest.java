package com.okas.packModelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CasillaValorTest {
	
	Coordenada c1;
	Coordenada c2;
	Coordenada c3;
	
	Tablero tb;
	
	Casilla cas1;
	Casilla cas2;
	Casilla cas3;

	@Before
	public void setUp() throws Exception {
		c1 = new Coordenada(1,3);
		c2 = new Coordenada(2,5);
		c3 = new Coordenada(5,8);
		
		cas1 = new CasillaValor(c1);
		cas2 = new CasillaValor(c2);
		cas3 = new CasillaValor(c3);
	}

	@Test
	public void test() {
		//DESCUBIR CASILLA
		//MARCAR DESCUBIERTA
		assertFalse(cas1.isDescubierta());
		cas1.descubrirCasilla();
		assertTrue(cas1.isDescubierta());
		assertFalse(cas3.isDescubierta());
		cas3.marcarDescubierta();
		assertTrue(cas3.isDescubierta());
		
		//MARCAR BANDERA
		assertFalse(cas2.getMarcadaBandera());
		cas2.marcarBandera();
		assertFalse(cas1.getMarcadaBandera());
		assertTrue(cas2.getMarcadaBandera());
		cas2.quitarBandera();
		assertFalse(cas2.getMarcadaBandera());
		
		//COORDENADA
		assertTrue(cas1.getCoordenada()==c1);
		assertFalse(cas1.getCoordenada()==c2);
		assertTrue(cas3.getCoordenada()==c3);
		
		//VALOR
		assertTrue(((CasillaValor) cas1).getValor()==1);
		((CasillaValor) cas1).incrementarValor();
		assertTrue(((CasillaValor) cas1).getValor()==2);
		assertFalse(((CasillaValor) cas2).getValor()==2);
		
		
		
		
	}

}
