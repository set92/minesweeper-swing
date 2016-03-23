package packModelo;

public class BuilderN1 extends TableroBuilder {
	
	public void generarTablero(){
		tablero = new Tablero(7,10);
	}

	
	public void ponerCasillasBomba() {
		tablero.ponerCasillasBomba(10);
	}	


}
