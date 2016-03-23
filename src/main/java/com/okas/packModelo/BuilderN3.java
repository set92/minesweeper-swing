package packModelo;

public class BuilderN3 extends TableroBuilder {
	
	public void generarTablero(){
		tablero = new Tablero(7,15); //TODO cambiar parámetros de la constructora.
	}

	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba(45);
	}	


}
