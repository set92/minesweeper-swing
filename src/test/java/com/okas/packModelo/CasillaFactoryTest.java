package com.okas.packModelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasillaFactoryTest {

	Casilla cas;
	@Test
	public void testCreateCasilla() {
		cas = CasillaFactory.getCasillaFactory().createCasilla("Mina", new Coordenada(1,0));
		assertTrue(cas instanceof CasillaMina);
		
		cas = CasillaFactory.getCasillaFactory().createCasilla("Valor", new Coordenada(1,0));
		assertTrue(cas instanceof CasillaValor);
		
		cas = CasillaFactory.getCasillaFactory().createCasilla("Cero", new Coordenada(1,0));
		assertTrue(cas instanceof CasillaValorCero);	
	}

}
