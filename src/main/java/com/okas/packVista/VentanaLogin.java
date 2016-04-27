package com.okas.packVista;

import com.okas.packModelo.Buscaminas;
import com.okas.packModelo.Sesion;
import com.okas.packModelo.Usuario;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class VentanaLogin extends JFrame {

	private JComboBox<String> comboBox;
	private JLabel lblNivel;
    private JLabel lblUser;
    private JLabel lblTitulo;
	private JTextField textField;
	private JButton btnRanking;
	private JButton btnStartGame;
	private Controlador controlador;
	private static VentanaLogin ventana;
	
	public static VentanaLogin getVentana(){
		if(ventana == null){
            try {
              //  UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            ventana=new VentanaLogin();
		}
		return ventana;
	}
	
	private VentanaLogin() {
		initialize();
        getRootPane().setDefaultButton(getBtnStartGame());
	}
	private void initialize() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(getControlador());
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getLblUser(), GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addComponent(getLblNivel()))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(39)
										.addComponent(getBtnStartGame(), GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
										.addComponent(getBtnRanking(), GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
									.addComponent(getComboBox(), GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(getLblTitulo(), GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(getLblTitulo())
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(getLblUser(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(getLblNivel())
						.addComponent(getComboBox(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getBtnRanking())
						.addComponent(getBtnStartGame()))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
		setTitle("Ventana Login");
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			Vector<String> vec = new Vector<String>();
			for(int i = 1; i < 4; i++ ) vec.addElement(Integer.toString(i));
			comboBox = new JComboBox<>(vec);
		}
		return comboBox;
	}
	private JLabel getLblNivel() {
		if (lblNivel == null) {
			lblNivel = new JLabel("Nivel: ");
		}
		return lblNivel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Usuario: ");
		}
		return lblUser;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("- Buscaminas -");
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		}
		return lblTitulo;
	}
	private JButton getBtnRanking() {
		if (btnRanking == null) {
			btnRanking = new JButton("Ranking");
			btnRanking.addActionListener(getControlador());
			btnRanking.setActionCommand("displayRanking");
		}
		return btnRanking;
	}
	
	private JButton getBtnStartGame() {
		if (btnStartGame == null) {
			btnStartGame = new JButton("Jugar");
			btnStartGame.addActionListener(getControlador());
			btnStartGame.setActionCommand("startGame");
		}
		return btnStartGame;
	}
	
	private Controlador getControlador(){
		if (controlador == null){
			controlador = new Controlador();
		}
		return controlador;
	}
	
	private class Controlador extends WindowAdapter implements ActionListener{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("startGame")){
				jugar();
            } else if (e.getActionCommand().equals("displayRanking")){
                VentanaRanking.getVentana().setVisible(true);
			}
		}
	}
	
	private void jugar() {
        getVentana().setVisible(false);
        Usuario user;
        if (getTextField().getText().equals("")) user = new Usuario("Anon", 0);
        else user = new Usuario(getTextField().getText(), 0);
        Sesion.getSesion().setUsuario(user);

        Buscaminas.getBuscaminas().crearJuego(Integer.parseInt(getComboBox().getSelectedItem().toString()));
        VentanaBuscaminas.getVentana().getJf().setVisible(true);
        Sesion.getSesion().setNivel(Integer.parseInt(getComboBox().getSelectedItem().toString()));
    }
}
