package packModelo;

public abstract class TableroBuilder {

	protected Tablero tablero;

<<<<<<< HEAD
	//public Tablero getTablero(){return this.tablero;}
	
	public abstract void generarTablero();
=======
	public Tablero getTablero(){return this.tablero;}
>>>>>>> 626fef66833eecdfd5483d52af031eaa71bd1fc1
	
	public Tablero construirTablero(){
		generarTablero();
		ponerCasillasBomba();
		ponerCasillasRestantes();
		return tablero;
		//tablero.crearListas();
	}

	public abstract void ponerCasillasBomba();
	
	public void ponerCasillasRestantes() {
		tablero.rellenarCasillasRestantes();

	}

}
