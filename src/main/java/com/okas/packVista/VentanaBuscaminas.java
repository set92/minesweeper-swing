package com.okas.packVista;

import com.okas.packModelo.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class VentanaBuscaminas implements Observer {
	public JFrame getJf() {
		return jf;
	}

	public static JFrame jf;
	private JPanel matrizCampoJuego;
	private JPanel panelBotonesSup;
	private Boton[][] matrizBotones;

	private JLabel lblNumMinas;
	private JButton btnReiniciar;
	private JLabel lblTiempo;


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
		jf = new JFrame();
		if (b.getAlto() == 7)
			jf.setBounds(100, 100, 450, 300);
		else if (b.getAlto() == 10)
			jf.setBounds(100, 100, 650, 450);
		else if (b.getAlto() == 12)
			jf.setBounds(100, 100, 1050, 600);

		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		jf.setTitle("Buscaminas");
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(getBotonesSup(), BorderLayout.NORTH);
		contentPane.add(getMatrizCampoJuego(), BorderLayout.CENTER);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		b.anadirObservadores(this);
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
							.addComponent(getLblTiempo(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGap(130)));
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
		if (lblNumMinas == null) lblNumMinas = new JLabel("Minas: "+b.getContador());
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
			ImageIcon icono = new ImageIcon("Sergio_Tobal.png");
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
			if (b.getAlto() == 7)
				matrizCampoJuego.setLayout(new GridLayout(7, 10, 0, 0));
			else if (b.getAlto() == 10)
				matrizCampoJuego.setLayout(new GridLayout(10, 15, 0, 0));
			else if (b.getAlto() == 12)
				matrizCampoJuego.setLayout(new GridLayout(12, 25, 0, 0));

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
					boton.anadirFuncion(this);
					matrizBotones[i][j] =boton ;
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
		for (int i = 0; i < b.getAlto(); i++){
			for (int j = 0; j < b.getAncho(); j++){
				if (b.getCampoJuego()[i][j] instanceof CasillaMina) {
					ImageIcon bomba = new ImageIcon("ImagenBomba.png");
					devolverCasilla(i, j).setIcon(bomba);
					devolverCasilla(i, j).setEnabled(false);
				}
			}
		}
	}



	//    TODO REHACER METODO, TIENE QUE ESTAR EN EL MODELO, NO LA VISTA
	//    private boolean finJuego() {
	//        boolean terminado = false;
	//        int cont = 0;
	//        for (int i = 0; i < b.getAlto(); i++) {
	//            for (int j = 0; j < b.getAncho(); j++) {
	//                cas = b.getTablero().getCampoJuego();
	//                if (!cas[i][j].isDescubierta()) cont++;
	//            }
	//        }
	//        if (cont == Buscaminas.getBuscaminas().getTablero().getNumMinas()) terminado = true;
	//        return terminado;
	//    }
	//    private void salirJuego() {
	//        jf.setVisible(false);
	//        JOptionPane.showMessageDialog(null, "HAS GANADO");
	//        //MANDAR A RANKING
	//    }

	public void controlMouse(MouseEvent e, int pFila, int pCol) {
		;
		if (SwingUtilities.isLeftMouseButton(e)) {
			b.descubrirCasilla(pFila,pCol);
			//if (finJuego()) salirJuego();
		}
		else if (SwingUtilities.isRightMouseButton(e)) {
			if (b.isDescubierta(pFila,pCol)){}
			else if (b.getContador() == 0){}
			else if (!b.isMarcadaBandera(pFila, pCol)) {
				b.setContador(-1);
				b.marcarBandera(pFila, pCol);
			}
			else if (b.isMarcadaBandera(pFila, pCol)){
				b.setContador(1);
				b.desmarcarBandera(pFila,pCol);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {	

		int x = ((Casilla) o).getCoordenada().getAlto();
		int y = ((Casilla) o).getCoordenada().getAncho();

		if (arg.equals("marcarBandera")){
			ImageIcon bandera = new ImageIcon("ImagenBandera.png");
			matrizBotones[x][y].setIcon(bandera);
			lblNumMinas.setText("Minas: "+b.getContador());
		}
		else if (arg.equals("desmarcarBandera")){
			matrizBotones[x][y].setIcon(new ImageIcon());
			lblNumMinas.setText("Minas: "+b.getContador());
		}
		else if (arg.equals("descubrirCasilla")){
			if(o instanceof CasillaValor){
				devolverCasilla(x, y).setText(""+((CasillaValor)o).getValor());
				devolverCasilla(x, y).setEnabled(false);
				devolverCasilla(x, y).setBackground(Color.WHITE);
				devolverCasilla(x, y).setForeground(Color.BLACK);

			}
			else if(o instanceof CasillaMina){
				ImageIcon icono2 = new ImageIcon("tobal.png");
				btnReiniciar.setIcon(icono2);
				mostrarMinas();
				bloquearBotones();
				JOptionPane.showMessageDialog(null, "GAME OVER");
			}
			else if(o instanceof CasillaValorCero){
				devolverCasilla(x, y).setEnabled(false);
				devolverCasilla(x, y).setBackground(Color.WHITE);
				devolverCasilla(x, y).setForeground(Color.BLACK);
				devolverCasilla(x, y).setText(" ");
			}
		}
	}
}


