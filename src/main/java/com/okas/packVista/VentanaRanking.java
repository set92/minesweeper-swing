package com.okas.packVista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.okas.packModelo.Buscaminas;
import com.okas.packModelo.CatalogoUsuarios;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaRanking extends JFrame {

    private JPanel contentPane;
    private JLabel lblRanking;
    private JTextArea textArea;
    private JButton btnVolver;
    private Controlador controlador;
    private static VentanaRanking ventana;

    public static VentanaRanking getVentana(){
        if(ventana == null) ventana = new VentanaRanking();
        return ventana;
    }

    private VentanaRanking() {
        initialize();
        getRootPane().setDefaultButton(getBtnVolver());
    }

    private void initialize() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(getControlador());
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addComponent(getLblRanking(), GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addGap(167))
                        .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(27)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(getTextArea(), GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                .addGap(290)
                                                .addComponent(getBtnVolver())))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(23)
                                .addComponent(getLblRanking())
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getTextArea(), GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addGap(18)
                                .addComponent(getBtnVolver())
                                .addGap(12))
        );
        contentPane.setLayout(gl_contentPane);
        setLocationRelativeTo(null);
        setTitle("Ranking");
    }

    private JLabel getLblRanking() {
        if (lblRanking == null) {
            lblRanking = new JLabel("TOP 10");
            lblRanking.setFont(new Font("Times New Roman", Font.BOLD, 16));
        }
        return lblRanking;
    }

    private JTextArea getTextArea() {
        if (textArea == null) {
            textArea = new JTextArea();
            textArea.setText(CatalogoUsuarios.getCatalogoUsuarios().mostrarLista(VentanaLogin.getVentana().nivel).pasarLtaAString());
            textArea.setEditable(false);
        }
        return textArea;
    }
    private JButton getBtnVolver() {
        if (btnVolver == null) {
            btnVolver = new JButton("Volver");
            btnVolver.addActionListener(getControlador());
            btnVolver.setActionCommand("PressVolver");
        }
        return btnVolver;
    }

    private Controlador getControlador(){
        if (controlador == null) controlador = new Controlador();
        return controlador;
    }

    private class Controlador extends WindowAdapter implements ActionListener {
        @Override
        public void windowClosing(WindowEvent e) {
            volver();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("PressVolver")){
                volver();
            }
        }
    }

    private void volver(){
        VentanaRanking.getVentana().setVisible(false);
        ventana = null;
    }
}