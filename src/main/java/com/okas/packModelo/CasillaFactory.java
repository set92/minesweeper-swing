package com.okas.packModelo;

public class CasillaFactory {
	
	private static CasillaFactory miCasillaFactory;
	
	private CasillaFactory(){}
	
	public static CasillaFactory getCasillaFactory(){
		if (miCasillaFactory == null) miCasillaFactory = new CasillaFactory();
		return miCasillaFactory;
	}

	public Casilla createCasilla (String pTipoCasilla, Coordenada pCoord){
		Casilla miCasilla = null;
        switch (pTipoCasilla) {
            case "Cero":
                miCasilla = new CasillaValorCero(pCoord);
                break;
            case "Valor":
                miCasilla = new CasillaValor(pCoord);
                break;
            case "Mina":
                miCasilla = new CasillaMina(pCoord);
                break;
        }
		return miCasilla;
	}

	
}
