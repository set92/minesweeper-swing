package com.okas.packVista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Boton extends JButton { //Esta clase sirve para tener un JButton con coordenadas
	
	private int posAlto;
	private int posAncho;
	public Boton(int pPosx, int pPosy){
		posAlto = pPosx;
		posAncho = pPosy;
		
	}

	public int getAlto(){
		return posAlto;
	}
	
	public int getAncho(){
		return posAncho;
	}
	
	/**
     * Anade una funcion al botón
     * @param vB 
     */
	public void anadirFuncion(VentanaBuscaminas vB){
		this.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				vB.controlMouse(e ,posAlto,posAncho);
			}
		});
	}
}
