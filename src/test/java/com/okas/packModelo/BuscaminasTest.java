package com.okas.packModelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuscaminasTest {

	Coordenada c1, c2, c3,c4,c5,c6,c7,c8,c9,c10;
	Tablero tb;
	Casilla cas1, cas2,cas3,cas4,cas5,cas6,cas7,cas8,cas9,cas10;
	Buscaminas bsc;


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
		cas4 = new CasillaValorCero(c4);
		cas5 = new CasillaValorCero(c5);
		cas6 = new CasillaValorCero(c6);
		((CasillaValorCero) cas4).setLista(new ListaCasillas());
		((CasillaValorCero) cas5).setLista(new ListaCasillas());
		((CasillaValorCero) cas6).setLista(new ListaCasillas());
		
		c7 = new Coordenada(1,0);
		c8 = new Coordenada(0,5);
		c9 = new Coordenada(2,4);
		cas7 = new CasillaMina(c7);
		cas8 = new CasillaMina(c8);
		cas9 = new CasillaMina(c9);
		
		
		c10 = new Coordenada(100,100);
		cas10 = new CasillaValor(c10);
		
		tb = new Tablero(7,10);
		bsc = Buscaminas.getBuscaminas();
	}

	@Test
	public void testMarcarBandera() {
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
		bsc.setTablero(tb);
		
	//CASILLA CON VALOR	
		//Marcar bandera
		assertFalse(bsc.isMarcadaBandera(1,3));
		bsc.marcarBandera(1,3);
		assertTrue(bsc.isMarcadaBandera(1,3));
		
		//Desmarcar bandera
		assertFalse(bsc.isMarcadaBandera(5,8));
		bsc.marcarBandera(5,8);
		assertTrue(bsc.isMarcadaBandera(5,8));
		bsc.desmarcarBandera(5,8);
		assertFalse(bsc.isMarcadaBandera(5,8));
		
		//descubrir casilla con bandera
		bsc.descubrirCasilla(1,3);
		assertTrue(bsc.isMarcadaBandera(1,3));
		assertFalse(bsc.isDescubierta(1,3));
		
		//Marcar bandera en casilla descubierta
		
		bsc.descubrirCasilla(2,5);
		assertTrue(bsc.isDescubierta(2,5));
		bsc.marcarBandera(2,5);
		assertTrue(bsc.isDescubierta(2,5));
		assertFalse(bsc.isMarcadaBandera(2,5));
		
//CASILLA SIN VALOR	
		//Marcar bandera
		assertFalse(bsc.isMarcadaBandera(0,0));
		bsc.marcarBandera(0,0);
		assertTrue(bsc.isMarcadaBandera(0,0));
				
		//Desmarcar bandera
		assertFalse(bsc.isMarcadaBandera(5,3));
		bsc.marcarBandera(5,3);
		assertTrue(bsc.isMarcadaBandera(5,3));
		bsc.desmarcarBandera(5,3);
		assertFalse(bsc.isMarcadaBandera(5,3));
				
		//descubrir casilla con bandera
		bsc.marcarBandera(0, 0);
		assertTrue(bsc.isMarcadaBandera(0,0));
		assertFalse(bsc.isDescubierta(0, 0));
				
		//Marcar bandera en casilla descubierta
			
		bsc.descubrirCasilla(2, 1);
		assertTrue(bsc.isDescubierta(2,1));
		bsc.marcarBandera(2,1);
		assertTrue(bsc.isDescubierta(2,1));
		assertFalse(bsc.isMarcadaBandera(2, 1));
				
				
//CASILLA MINA	
		//Marcar bandera
		assertFalse(bsc.isMarcadaBandera(1, 0));
		bsc.marcarBandera(1,0);
		assertTrue(bsc.isMarcadaBandera(1, 0));
				
		//Desmarcar bandera
		assertFalse(bsc.isMarcadaBandera(2, 4));
		bsc.marcarBandera(2, 4);
		assertTrue(bsc.isMarcadaBandera(2, 4));
		bsc.desmarcarBandera(2,4);
		assertFalse(bsc.isMarcadaBandera(2, 4));
				
		//descubrir casilla con bandera
		bsc.descubrirCasilla(1,0);
		assertTrue(bsc.isMarcadaBandera(1, 0));
		assertFalse(bsc.isDescubierta(1,0));
				
		//Marcar bandera en casilla descubierta
				
		bsc.descubrirCasilla(0,5);
		assertTrue(bsc.isDescubierta(0,5));
		bsc.marcarBandera(0,5);
		assertTrue(bsc.isDescubierta(0,5));
		assertFalse(bsc.isMarcadaBandera(0, 5));
	}

}
