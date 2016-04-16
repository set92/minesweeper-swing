package com.okas.packVista;

import com.okas.packModelo.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class VentanaBuscaminas {
    public JFrame getJf() {
        return jf;
    }

    public static JFrame jf;
    private JPanel matrizCampoJuego;
    private JPanel panelBotonesSup;
    private JButton[][] matrizBotones;

    private JLabel lblNumMinas;
    private JButton btnReiniciar;
    private JLabel lblTiempo;

    private Casilla[][] cas;
    private Contador cont = new Contador();
    private static VentanaBuscaminas ventana;
    private Buscaminas b = Buscaminas.getBuscaminas();//Lo pongo aqui para solo ponerlo 1 vez (variable local)
    public final DescubrirCasillaObservable observable = new DescubrirCasillaObservable();

    public static VentanaBuscaminas getVentana() {
        if (ventana == null) ventana = new VentanaBuscaminas();
        return ventana;
    }

    private VentanaBuscaminas() {
        initialize();
    }

    private void initialize() {
        jf = new JFrame();
        if (b.getTablero().getAlto() == 7)
            jf.setBounds(100, 100, 450, 300);
        else if (b.getTablero().getAlto() == 10)
            jf.setBounds(100, 100, 650, 450);
        else if (b.getTablero().getAlto() == 12)
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
                                    .addComponent(getBtnReiniciar(), GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                    .addGap(10)
                                    .addComponent(getLblTiempo(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(110)));
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
        if (lblNumMinas == null) lblNumMinas = new JLabel("Minas: "+cont.getNumero());

        return lblNumMinas;
    }
    private JButton getBtnReiniciar() {
        if (btnReiniciar == null) {
            btnReiniciar = new JButton("Reiniciar");
            btnReiniciar.addActionListener( e -> Buscaminas.getBuscaminas().reiniciar());
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
            for (int i = 0; i < b.getAlto(); i++){
                for (int j = 0; j < b.getAncho(); j++){
                    getCasilla(i, j);
            		cas[i][j].cambiarObserver(cont);
        		}
    		}
        }
        return matrizBotones;
    }

    private JButton getCasilla(int pFila, int pColum) {
        cas = b.getTablero().getCampoJuego();

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
                    getCasilla(i, j).setText("M");
                }
    }
    
    private void mostrarCasillasVacias(int pFila, int pCol) {
        Buscaminas.getBuscaminas().getTablero().descubrirCasilla(cas[pFila][pCol]);
        for (int i=0; i<Buscaminas.getBuscaminas().getAlto(); i++){
        	for (int j=0; j<Buscaminas.getBuscaminas().getAncho(); j++){
        		if (cas[i][j].isDescubierta())
        			mostrarCasilla(i,j);
        	}
        }
    }
    
    private void mostrarCasilla(int pFila, int pCol){
    	if (cas[pFila][pCol] instanceof CasillaValorCero) mostrarCasVacia(pFila,pCol);
    	else if (cas[pFila][pCol] instanceof CasillaValor)  mostrarCasillaValor(pFila, pCol);
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
        //jf.setVisible(false); COMENTO PORQUE SI NO SE CIERRA TODO
        JOptionPane.showMessageDialog(null, "HAS GANADO");
        //MANDAR A RANKING
    }
    private void controlMouse(MouseEvent e, int pFila, int pCol) {
        cas = b.getTablero().getCampoJuego();
        if (SwingUtilities.isLeftMouseButton(e)) {
        	if (cas[pFila][pCol].getMarcadaBandera()){}
        	else if (cas[pFila][pCol] instanceof CasillaMina) {
                mostrarMinas();
                bloquearBotones();
                JOptionPane.showMessageDialog(null, "GAME OVER");
            } else if (cas[pFila][pCol] instanceof CasillaValor) {
                mostrarCasillaValor(pFila, pCol);
                observable.changeData(cas[pFila][pCol]);
            } else if (cas[pFila][pCol] instanceof CasillaValorCero) {
                mostrarCasillasVacias(pFila, pCol);
            }
            if (finJuego()) salirJuego();
        }
        if (SwingUtilities.isRightMouseButton(e)) {
        	if (cas[pFila][pCol].isDescubierta()){}
        	else if (cont.getNumero() == 0){}
        	else if (!cas[pFila][pCol].getMarcadaBandera()) {
                ponerBandera(pFila,pCol);
                cas[pFila][pCol].marcarBandera();
                String numeroString = String.valueOf(cont.getNumero());
                lblNumMinas.setText("Minas: "+ numeroString);
            }
            else if (cas[pFila][pCol].getMarcadaBandera()){
            	quitarBandera(pFila,pCol);
                cas[pFila][pCol].quitarBandera();
                String numeroString = String.valueOf(cont.getNumero());
                lblNumMinas.setText("Minas: "+ numeroString);
            }
        	
        	
        }
    }
    
    private void ponerBandera(int pFila, int pCol){
    	getCasilla(pFila, pCol).setText("B");

    }
    
    private void quitarBandera(int pFila, int pCol){
    	getCasilla(pFila, pCol).setText("");

    }
}

	
