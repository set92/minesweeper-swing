package com.okas.packModelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BanderaTest {
	
	Coordenada c1, c2, c3,c4,c5,c6,c7,c8,c9,c10;
	Tablero tb;
	Casilla cas1, cas2,cas3,cas4,cas5,cas6,cas7,cas8,cas9,cas10;


	@Before
	public void setUp() throws Exception {
		c1 = new Coordenada(1,3);
		c2 = new Coordenada(2,5);
		c3 = new Coordenada(5,8);
		cas1 = new CasillaValor(c1);
		cas2 = new CasillaValor(c2);
		cas3 = new CasillaValor(c3);
		
		c4 = new Coordenada(0,0);
		c5 = new Coordenada(2,1);
		c6 = new Coordenada(5,3);
		cas4 = new CasillaValor(c4);
		cas5 = new CasillaValor(c5);
		cas6 = new CasillaValor(c6);
		
		c7 = new Coordenada(1,0);
		c8 = new Coordenada(0,5);
		c9 = new Coordenada(2,4);
		cas7 = new CasillaValor(c7);
		cas8 = new CasillaValor(c8);
		cas9 = new CasillaValor(c9);
		
		c10 = new Coordenada(100,100);
		cas10 = new CasillaValor(c10);
	}

	@Test
	public void testMarcarBandera() {
		Tablero tb = new Tablero(7,10);
		tb.colocarCasilla(c1, cas1);
		tb.colocarCasilla(c2, cas2);
		tb.colocarCasilla(c3, cas3);
		tb.colocarCasilla(c4, cas4);
		tb.colocarCasilla(c5, cas5);
		tb.colocarCasilla(c6, cas6);
		tb.colocarCasilla(c7, cas7);
		tb.colocarCasilla(c8, cas8);
		tb.colocarCasilla(c9, cas9);
		tb.colocarCasilla(c10, cas10);
		
		tb.imprimirCampo();
		
	//CASILLA CON VALOR	
		//Marcar bandera
		assertFalse(cas1.getMarcadaBandera());
		tb.marcarBandera(cas1);
		assertTrue(cas1.getMarcadaBandera());
		
		//Desmarcar bandera
		assertFalse(cas3.getMarcadaBandera());
		tb.marcarBandera(cas3);
		assertTrue(cas3.getMarcadaBandera());
		tb.desmarcarBandera(cas3);
		assertFalse(cas3.getMarcadaBandera());
		
		//descubrir casilla con bandera
		cas1.descubrirCasilla();
		assertTrue(cas1.getMarcadaBandera());
		assertFalse(cas1.isDescubierta());
		
		//Marcar bandera en casilla descubierta
		
		cas2.marcarDescubierta();
		assertTrue(cas2.isDescubierta());
		tb.marcarBandera(cas2);
		assertTrue(cas2.isDescubierta());
		assertFalse(cas2.getMarcadaBandera());
		
//CASILLA SIN VALOR	
		//Marcar bandera
		assertFalse(cas4.getMarcadaBandera());
		tb.marcarBandera(cas4);
		assertTrue(cas4.getMarcadaBandera());
				
		//Desmarcar bandera
		assertFalse(cas6.getMarcadaBandera());
		tb.marcarBandera(cas6);
		assertTrue(cas6.getMarcadaBandera());
		tb.desmarcarBandera(cas6);
		assertFalse(cas6.getMarcadaBandera());
				
		//descubrir casilla con bandera
		cas4.descubrirCasilla();
		assertTrue(cas4.getMarcadaBandera());
		assertFalse(cas4.isDescubierta());
				
		//Marcar bandera en casilla descubierta
				
		cas5.marcarDescubierta();
		assertTrue(cas5.isDescubierta());
		tb.marcarBandera(cas5);
		assertTrue(cas5.isDescubierta());
		assertFalse(cas5.getMarcadaBandera());
				
				
//CASILLA MINA	
		//Marcar bandera
		assertFalse(cas7.getMarcadaBandera());
		tb.marcarBandera(cas7);
		assertTrue(cas7.getMarcadaBandera());
				
		//Desmarcar bandera
		assertFalse(cas9.getMarcadaBandera());
		tb.marcarBandera(cas9);
		assertTrue(cas9.getMarcadaBandera());
		tb.desmarcarBandera(cas9);
		assertFalse(cas9.getMarcadaBandera());
				
		//descubrir casilla con bandera
		cas7.descubrirCasilla();
		assertTrue(cas7.getMarcadaBandera());
		assertFalse(cas7.isDescubierta());
				
		//Marcar bandera en casilla descubierta
				
		cas8.marcarDescubierta();
		assertTrue(cas8.isDescubierta());
		tb.marcarBandera(cas8);
		assertTrue(cas8.isDescubierta());
		assertFalse(cas8.getMarcadaBandera());
		
		
//CASOS ESPECIALES		
		//Marcar bandera en coordenada inexistente
		tb.marcarBandera(cas10);
		assertFalse(cas10.getMarcadaBandera());
		
	}

}
