package com.okas.packVista;

import com.okas.packModelo.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class VentanaBuscaminas extends JFrame {
    private JPanel matrizCampoJuego;
    private JButton[][] matrizBotones;
    private Casilla[][] cas;
    private static VentanaBuscaminas ventana;
    private Buscaminas b = Buscaminas.getBuscaminas();//Lo pongo aqui para solo ponerlo 1 vez (variable local)
    
    public static VentanaBuscaminas getVentana() {
        if (ventana == null) ventana = new VentanaBuscaminas();
        return ventana;
    }

    private VentanaBuscaminas() {
        initialize();
    }

    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (b.getTablero().getAlto() == 7)
            setBounds(100, 100, 450, 300);
        else if (b.getTablero().getAlto() == 10)
            setBounds(100, 100, 650, 450);
        else if (b.getTablero().getAlto() == 12)
            setBounds(100, 100, 1050, 600);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        contentPane.add(getMatrizCampoJuego(), BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JPanel getMatrizCampoJuego() {
        if (matrizCampoJuego == null) {
            matrizCampoJuego = new JPanel();
            if (b.getAlto() == 7)
                matrizCampoJuego.setLayout(new GridLayout(7, 10, 0, 0));
            else if (b.getAlto() == 10)
                matrizCampoJuego.setLayout(new GridLayout(10, 15, 0, 0));
            else if (b.getAlto() == 12)
                matrizCampoJuego.setLayout(new GridLayout(12, 25, 0, 0));

            matrizCampoJuego.setBackground(Color.WHITE);
            getMatrizBotones();
            for (int i = 0; i < b.getAlto(); i++)
                for (int j = 0; j < b.getAncho(); j++)
                    matrizCampoJuego.add(getCasilla(i, j));
        }
        return matrizCampoJuego;
    }

    private JButton[][] getMatrizBotones() {
        if (matrizBotones == null) {
            matrizBotones = new JButton[b.getAlto()][b.getAncho()];
            for (int i = 0; i < b.getAlto(); i++)
                for (int j = 0; j < b.getAncho(); j++)
                    getCasilla(i, j);
        }
        return matrizBotones;
    }

    private JButton getCasilla(int pFila, int pColum) {
        if (getMatrizBotones()[pFila][pColum] == null) {
            getMatrizBotones()[pFila][pColum] = new JButton();
            getMatrizBotones()[pFila][pColum].setFocusable(false);
            getMatrizBotones()[pFila][pColum].addMouseListener(new MouseListener() {
                public void mouseReleased(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseClicked(MouseEvent e) {
                    controlMouse(e, pFila, pColum);
                }
            });
        }
        return getMatrizBotones()[pFila][pColum];
    }

    private void bloquearBotones() {
        for (int i = 0; i < b.getAlto(); i++)
            for (int j = 0; j < b.getAncho(); j++)
                getCasilla(i, j).setEnabled(false);
    }

    private void mostrarMinas() {
        for (int i = 0; i < b.getAlto(); i++)
            for (int j = 0; j < b.getAncho(); j++)
                if (cas[i][j] instanceof CasillaMina) {
                    getCasilla(i, j).setFont(new Font("Arial", Font.BOLD, 12));
                    getCasilla(i, j).setBackground(Color.WHITE);
                    getCasilla(i, j).setText("B");
                }
    }

//    private void mostrarCasillasVacias(int pFila, int pCol) {
//        cas = b.getTablero().getCampoJuego();
//        ListaCasillas devol = ((CasillaValorCero) cas[pFila][pCol]).getLista();
//        for (Casilla csl : devol.getListCasilla()) {
//            if (csl instanceof CasillaValorCero) {
//                csl.descubrirCasilla();
//
//            }
//            //else casilla valor
//        }
//    }
    private void mostrarCasillasVacias(int pFila, int pCol) {
        ArrayList<Casilla> arrayList = Buscaminas.getBuscaminas().getTablero().mostrarCasillaValorCero(pFila,pCol);
        for (Casilla cas1 : arrayList) {
            if (cas1 instanceof CasillaValorCero) {
                mostrarCasVacia(cas1.getCoordenada().getAlto(), cas1.getCoordenada().getAncho());
            }
//            else {
//                mostrarCasillaValor(cas1.getCoordenada().getAlto(),cas1.getCoordenada().getAncho());
//            }
        }
    }

    private void mostrarCasVacia(int pFila, int pCol) {
        getCasilla(pFila, pCol).setEnabled(false);
        getCasilla(pFila, pCol).setBackground(Color.WHITE);
        getCasilla(pFila, pCol).setText("");
    }

    private void mostrarCasillaValor(int pFila, int pCol) {
        cas = b.getTablero().getCampoJuego();
        cas[pFila][pCol].descubrirCasilla();
        getCasilla(pFila, pCol).setText(""+((CasillaValor)cas[pFila][pCol]).getValor());
        getCasilla(pFila, pCol).setEnabled(false);
        getCasilla(pFila, pCol).setBackground(Color.WHITE);
        getCasilla(pFila, pCol).setForeground(Color.BLACK);
    }

    private boolean finJuego() {
        boolean terminado = false;
        int cont = 0;
        for (int i = 0; i < b.getAlto(); i++) {
            for (int j = 0; j < b.getAncho(); j++) {
                cas = b.getTablero().getCampoJuego();
                if (!cas[i][j].isDescubierta()) cont++;
            }
        }
        if (cont == Buscaminas.getBuscaminas().getTablero().getNumMinas()) terminado = true;
        return terminado;
    }

    private void salirJuego() {
        VentanaBuscaminas.getVentana().setVisible(false);
        JOptionPane.showMessageDialog(null, "HAS GANADO");
        //MANDAR A RANKING
    }

    private void controlMouse(MouseEvent e, int pFila, int pCol) {
        cas = b.getTablero().getCampoJuego();
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (cas[pFila][pCol] instanceof CasillaMina) {
                mostrarMinas();
                bloquearBotones();
                JOptionPane.showMessageDialog(null, "GAME OVER");
            } else if (cas[pFila][pCol] instanceof CasillaValor) {
                mostrarCasillaValor(pFila, pCol);
            } else if (cas[pFila][pCol] instanceof CasillaValorCero) {
                mostrarCasillasVacias(pFila, pCol);
            }
            if (finJuego()) salirJuego();
        }
    }
}

	
