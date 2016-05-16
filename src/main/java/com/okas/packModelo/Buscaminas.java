package com.okas.packModelo;

import com.okas.packVista.VentanaBuscaminas;

import java.util.ArrayList;

/**
 * Se accede al tablero, sesion y datos del usuario mediante esta clase.
 */
public class Buscaminas {

	private int nivel;
	private boolean finJuego = false;
	private Tablero tablero;
	private int contador = 0;
	private static Buscaminas miBuscaminas = null;
	private TableroBuilder tableroBuilder;
	private Usuario user;

	private Buscaminas(){}

	public int getNivel(){ return nivel; }
	public int getAlto(){ return tablero.getAlto(); }
	public int getAncho(){ return tablero.getAncho(); }
	private int getNumMinas(){ return tablero.getNumMinas(); }
	public int getContador(){return contador;}
    public Casilla[][] getCampoJuego(){ return tablero.getCampoJuego(); }
    public Usuario getUser() { return user; }
    public void setNivel(int pNivel){ nivel = pNivel; }
	public void setContador(int n){ contador = contador + n; }
	public void setUsuario(Usuario pUsuario){ user = pUsuario; }
	private void setTableroBuilder(TableroBuilder tabBuilder){ tableroBuilder = tabBuilder; }
    
	private int setPuntuacion(){
        return ContadorTiempo.getGestor().getTiempoEnSegundos();
    }
   
	public void setTablero(Tablero tb){this.tablero=tb;} //para jUnits

	public static Buscaminas getBuscaminas(){
		if (miBuscaminas == null) miBuscaminas = new Buscaminas();
		return miBuscaminas;
	}

    public boolean estaFinalizado(){ return finJuego; }
    
    /**
     * Marca bandera en la casilla seleccionada 
     * @param pFila Coordenada correspondiente a la fila de la casilla
     * @param pColumna Coordenada correspondiente a la columna de la casilla
     */
    public void marcarBandera(int pFila, int pColumna){
        tablero.marcarBandera(pFila, pColumna);
    }
    
    /**
     * Quita la bandera en la casilla seleccionada
     * @param pFila Coordenada correspondiente a la fila de la casilla
     * @param pColumna Coordenada correspondiente a la columna de la casilla
     */
    public void desmarcarBandera(int pFila, int pColumna){
        tablero.desmarcarBandera(pFila, pColumna);
    }
    
    public boolean isMarcadaBandera(int pFila, int pColumna){
        return tablero.isMarcadaBandera(pFila,pColumna);
    }
    
    public boolean isDescubierta(int pFila, int pColumna){
        return tablero.isDescubierta(pFila,pColumna);
    }

    /**
	 * Reiniciar el tablero de juego
	 */
	public void reiniciar() {
		cancelarMinas();
		crearJuego(getNivel());
	}

	/**
	 * Modifica el chivato que dice si las minas están puestas o no
	 */
    public void cancelarMinas(){
        tablero.cancelarMinas();
    }
    
	/**
	 * Genera un nivel dependiendo del parametro
     * @param nivel Nivel que se quiere generar
     */
	public void crearJuego(int nivel){
		switch (nivel){
            case 1: tableroBuilder = new BuilderN1();break;
            case 2: tableroBuilder = new BuilderN2();break;
            case 3: tableroBuilder = new BuilderN3();break;
            default: tableroBuilder = new BuilderN1();break;
		}
		tablero = tableroBuilder.construirTablero();
		contador = tablero.getNumMinas();
		setTableroBuilder(tableroBuilder);
	}

	/**
	 * Anadir por cada casilla el Observador que trae como parámetro
	 * @param ventanaBuscaminas Para anadir la VentanaBuscaminas como Observador
	 */
	public void anadirObservadores(VentanaBuscaminas ventanaBuscaminas) {
        for (Casilla[] casilla : tablero.getCampoJuego())
			for (Casilla casilla1: casilla)
                casilla1.addObserver(ventanaBuscaminas);
	}

	/**
	 * Descubre la casilla que le proporciona el parametro
	 * @param pFila Fila en la que está la casilla
	 * @param pColumna Columna en la que está la casilla
	 */
	public void descubrirCasilla(int pFila, int pColumna) {
		tablero.descubrirCasilla(pFila,pColumna);
		if(tablero.getCampoJuego()[pFila][pColumna] instanceof CasillaMina) finJuego = true;
	}

	/**
	 * Muestra si se ha ganado o no el juego
	 * @return True si el juego ha sido ganado, False si no
	 */
	public boolean juegoGanado(){
		int cont = 0;
		for (int i = 0; i < tablero.getAlto(); i++)
			for (int j = 0; j < tablero.getAncho(); j++)
				if (!(tablero.getCampoJuego()[i][j] instanceof CasillaMina)
                        && (tablero.getCampoJuego()[i][j].isDescubierta())) cont++;

		int numCasillasNoMina = (this.getAlto() * this.getAncho()) - this.getNumMinas();
		boolean juegoGanado = false;
		if (cont == numCasillasNoMina){
			juegoGanado = true;
			user.setPtosUsuario(setPuntuacion());
			Buscaminas.getBuscaminas().getUser().setPtosUsuario(setPuntuacion());
			
			ArrayList<String> userS = new ArrayList<>();
			userS.add(user.getNombreUsuario());
			userS.add(String.valueOf(user.getPtosUsuario()));
			CatalogoUsuarios.getCatalogoUsuarios().addUser(userS, nivel);
            CatalogoUsuarios.getCatalogoUsuarios().cargarUsuarios();
		}
		
		return juegoGanado;
	}
}
