package packModelo;

public class CasillaFactory {
	
	private static CasillaFactory miCasillaFactory;
	
	private CasillaFactory(){}
	
	public static CasillaFactory getCasillaFactory(){
		if (miCasillaFactory == null) miCasillaFactory = new CasillaFactory();
		return miCasillaFactory;
	}

	public Casilla createCasilla (String pTipoCasilla, Coordenada pCoord){
		Casilla miCasilla = null;
		if (pTipoCasilla.equals("Cero")){miCasilla = new CasillaValorCero(pCoord);}
		else if (pTipoCasilla.equals("Valor")){miCasilla = new CasillaValor(pCoord);}
		else if (pTipoCasilla.equals("Mina")){miCasilla = new CasillaMina(pCoord);}
		return miCasilla;
	}

	
}
