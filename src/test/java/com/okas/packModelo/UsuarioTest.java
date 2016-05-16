package com.okas.packModelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {
	
	final Usuario us = new Usuario("jorge",0);
	final Usuario us2 = new Usuario("sergio", 1000);

	@Test
	public void test() {
		assertEquals(0, us.getPtosUsuario());
		assertEquals("jorge", us.getNombreUsuario());
		assertEquals(1000, us2.getPtosUsuario());
		assertEquals("sergio", us2.getNombreUsuario());
		
		us.setPtosUsuario(50);
		assertEquals(us.getPtosUsuario(),20);
		assertFalse(us.getPtosUsuario()==50);
	}

}
