package packModelo;

public class BuilderN2 extends TableroBuilder {

	public void generarTablero(){
		tablero = new Tablero(5,10); //TODO cambiar parámetros de la constructora
	}
	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba(20);
	}	


}
