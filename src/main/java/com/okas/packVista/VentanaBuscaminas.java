package com.okas.packVista;

import com.okas.packModelo.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class VentanaBuscaminas implements Observer {
	private static JFrame jf;
	private JPanel matrizCampoJuego;
	private JPanel panelBotonesSup;
	private Boton[][] matrizBotones;
	private JLabel lblNumMinas;
	private JButton btnReiniciar;
	private JLabel lblTiempo;

	private static VentanaBuscaminas ventana;
	private final Buscaminas b = Buscaminas.getBuscaminas();//Lo pongo aqui para solo ponerlo 1 vez (variable local)

	static VentanaBuscaminas getVentana() {
		if (ventana == null) ventana = new VentanaBuscaminas();
		return ventana;
	}

	JFrame getJf() {
		return jf;
	}

	private VentanaBuscaminas() {
		initialize();
	}

	private void initialize() {
		jf = new JFrame();
		if (b.getAlto() == 7)
			jf.setBounds(100, 100, 450, 300);
		else if (b.getAlto() == 10)
			jf.setBounds(100, 100, 650, 450);
		else if (b.getAlto() == 12)
			jf.setBounds(100, 100, 1050, 600);

		jf.setResizable(false);

		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		jf.setTitle("Buscaminas");
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		contentPane.setLayout(new BorderLayout(0, 0));

		ContadorTiempo.getGestor().addObserver(this);
		ContadorTiempo.getGestor().reset();
		ContadorTiempo.getGestor().setRunning(true);

		b.inicializarFinJuego();
		b.anadirObservadores(this);

		contentPane.add(getBotonesSup(), BorderLayout.NORTH);
		contentPane.add(getMatrizCampoJuego(), BorderLayout.CENTER);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private JPanel getBotonesSup() {
		if (panelBotonesSup == null) {
			panelBotonesSup = new JPanel();
			panelBotonesSup.setPreferredSize(new Dimension(60, 50));
			GroupLayout gl_botonesSup = new GroupLayout(panelBotonesSup);
			gl_botonesSup.setHorizontalGroup(
					gl_botonesSup.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addGroup(gl_botonesSup.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getLblNumMinas())
							.addGap(6)
							.addComponent(getBtnReiniciar(), GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(getLblTiempo(), GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGap(100)));
			gl_botonesSup.setVerticalGroup(
					gl_botonesSup.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addGroup(gl_botonesSup.createSequentialGroup()
							.addContainerGap(22, Short.MAX_VALUE)
							.addGroup(gl_botonesSup.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addGroup(gl_botonesSup.createSequentialGroup()
											.addGap(4)
											.addComponent(getLblNumMinas()))
									.addComponent(getBtnReiniciar())
									.addGroup(gl_botonesSup.createSequentialGroup()
											.addGap(4)
											.addGroup(gl_botonesSup.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(getLblTiempo())
													)))
							.addGap(20)));
			panelBotonesSup.setBackground(Color.WHITE);
			panelBotonesSup.setLayout(gl_botonesSup);
		}
		return panelBotonesSup;
	}

	private JLabel getLblNumMinas() {
		if (lblNumMinas == null) lblNumMinas = new JLabel("Minas: " + b.getContador());
		return lblNumMinas;
	}

	private JButton getBtnReiniciar() {
		if (btnReiniciar == null) {
			btnReiniciar = new JButton("");
			btnReiniciar.addActionListener( e -> {
				VentanaBuscaminas.getVentana().getJf().setVisible(false);
				Buscaminas.getBuscaminas().reiniciar();
				ventana = new VentanaBuscaminas();
				VentanaBuscaminas.getVentana().getJf().setVisible(true);
			});
			ImageIcon icono = new ImageIcon("src/main/resources/Sergio_Tobal.png");
			btnReiniciar.setIcon(icono);
		}

		return btnReiniciar;
	}
	private JLabel getLblTiempo() {
		if (lblTiempo == null) lblTiempo = new JLabel("Tiempo: ");
		return lblTiempo;
	}

	private JPanel getMatrizCampoJuego() {
		if (matrizCampoJuego == null) {
			matrizCampoJuego = new JPanel();

			switch (b.getAlto()){
                case 7: matrizCampoJuego.setLayout(new GridLayout(7, 10, 0, 0));break;
                case 10: matrizCampoJuego.setLayout(new GridLayout(10, 15, 0, 0));break;
                case 12: matrizCampoJuego.setLayout(new GridLayout(12, 25, 0, 0));break;
            }

			matrizCampoJuego.setBackground(Color.WHITE);
			crearMatrizBotones();
			for (int i = 0; i < b.getAlto(); i++)
				for (int j = 0; j < b.getAncho(); j++)
					matrizCampoJuego.add(devolverCasilla(i,j));		
		}
		return matrizCampoJuego;
	}

	private void crearMatrizBotones() {
		if (matrizBotones == null) {
			matrizBotones = new Boton[b.getAlto()][b.getAncho()];
			for (int i = 0; i < b.getAlto(); i++){
				for (int j = 0; j < b.getAncho(); j++){
					Boton boton = new Boton(i,j);
					boton.anadirFuncion();
					matrizBotones[i][j] = boton;
					boton.setFocusable(false);
				}
			}
		}
	}

	private JButton devolverCasilla(int pFila, int pColum){
		return matrizBotones[pFila][pColum];
	}

	private void bloquearBotones() {
		for (int i = 0; i < b.getAlto(); i++){
			for (int j = 0; j < b.getAncho(); j++){
				if (!(b.getCampoJuego()[i][j] instanceof CasillaMina)) {
					devolverCasilla(i, j).setEnabled(false);
					matrizBotones[i][j] = new Boton(i,j);
				}
			}
		}
	}

	private void mostrarMinas() {
		for (int i = 0; i < b.getAlto(); i++)
			for (int j = 0; j < b.getAncho(); j++)
				if (b.getCampoJuego()[i][j] instanceof CasillaMina) {
					ImageIcon bomba = new ImageIcon("src/main/resources/ImagenBomba.png");
					devolverCasilla(i, j).setIcon(bomba);
					devolverCasilla(i, j).setEnabled(false);
				}
	}

	void controlMouse(MouseEvent e, int pFila, int pCol) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			b.descubrirCasilla(pFila,pCol);
			if(!b.estaFinalizado())	{
				if (b.juegoGanado()){
					jf.setVisible(false);       
					JOptionPane.showMessageDialog(null, "¡HAS GANADO!");

                    Buscaminas.getBuscaminas().cancelarMinas();
                    ventana = null;

					VentanaRanking.getVentana().setVisible(true);
				}
			}
		} else if (SwingUtilities.isRightMouseButton(e)) {
			if (b.isDescubierta(pFila,pCol)){}
			else if (!b.isMarcadaBandera(pFila, pCol)) {
				if (b.getContador() == 0){}
				else{
					b.setContador(-1);
					b.marcarBandera(pFila, pCol);
				}

			} else if (b.isMarcadaBandera(pFila, pCol)){
				b.setContador(1);
				b.desmarcarBandera(pFila,pCol);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ContadorTiempo){
			getLblTiempo().setText("Tiempo: " + ContadorTiempo.getGestor().mostrarEnLabel());
		} else if(o instanceof Casilla){
			String cadena = (String) arg;
			String[] sp = cadena.split(",");
			String accion = sp[0];
			String alto = sp[1];
			String ancho = sp[2];

			int x = Integer.parseInt(alto);
			int y = Integer.parseInt(ancho);

            switch (accion) {
                case "marcarBandera":
                    ImageIcon bandera = new ImageIcon("src/main/resources/ImagenBandera.png");
                    devolverCasilla(x, y).setIcon(bandera);
                    lblNumMinas.setText("Minas: " + b.getContador());
                    break;
                case "desmarcarBandera":
                    devolverCasilla(x, y).setIcon(null);
                    lblNumMinas.setText("Minas: " + b.getContador());
                    break;
                case "descubrirCasilla":
                    if (o instanceof CasillaValor) {
                        devolverCasilla(x, y).setText("" + ((CasillaValor) o).getValor());
                        devolverCasilla(x, y).setEnabled(false);
                        devolverCasilla(x, y).setBackground(Color.WHITE);
                        devolverCasilla(x, y).setForeground(Color.BLACK);
                    } else if (o instanceof CasillaMina) {
                        ImageIcon icono2 = new ImageIcon("src/main/resources/tobal.png");
                        btnReiniciar.setIcon(icono2);
                        mostrarMinas();
                        bloquearBotones();
                        JOptionPane.showMessageDialog(null, "GAME OVER");

                        this.getJf().setVisible(false);
                        Buscaminas.getBuscaminas().cancelarMinas();
                        ventana = null;

                        int puntos = ContadorTiempo.getGestor().getTiempoEnSegundos();
                        Buscaminas.getBuscaminas().getUser().setPtosUsuario(puntos);
                        VentanaRanking.getVentana().setVisible(true);
                    } else if (o instanceof CasillaValorCero) {
                        devolverCasilla(x, y).setEnabled(false);
                        devolverCasilla(x, y).setBackground(Color.WHITE);
                        devolverCasilla(x, y).setForeground(Color.BLACK);
                        devolverCasilla(x, y).setText(" ");
                    }
                    break;
            }
		}

	}
}