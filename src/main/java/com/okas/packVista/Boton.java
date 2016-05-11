package com.okas.packVista;

import javax.swing.*;
import java.awt.event.*;

/**
 * Clase para tener JButton con Coordenadas y funcionalidad
 */
class Boton extends JButton {
	
	private final int posAlto;
	private final int posAncho;
    private Controlador controlador;

	Boton(int pPosx, int pPosy){
		posAlto = pPosx;
		posAncho = pPosy;
	}

	/**
     * Anade la funcionalidad al botón
     */
	void anadirFuncion(){
		this.addMouseListener(getControlador());
	}

    private Controlador getControlador(){
        if (controlador == null) controlador = new Controlador();
        return controlador;
    }

    private class Controlador implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) { VentanaBuscaminas.getVentana().controlMouse(e ,posAlto,posAncho); }
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
    }
}
