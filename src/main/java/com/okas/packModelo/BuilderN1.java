package com.okas.packModelo;

public class BuilderN1 extends TableroBuilder {

	//TODO preguntar a ver si puede tener atributos.
	
	public BuilderN1() {
	}
	
	

	@Override
	public void rellenarTableroDeCasillasVacias() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 7; i++){
			for (int j = 0; i < 10; j++){
				Coordenada coordenadaActual = new Coordenada(i,j);
				CasillaValorCero casillaActual = new CasillaValorCero(coordenadaActual);
				tablero.colocarCasilla(coordenadaActual, casillaActual);
			}
		}
	}



	@Override
	public void ponerCasillasBomba() {
		// TODO Auto-generated method stub
		int contador = 10;
		while (contador!=0){
			int numeroAleatorio = (int) (Math.random()*7+1);
			int numeroAleatorio2 = (int) (Math.random()*10+1);
			Casilla unaCasilla = tablero.getCampoJuego()[numeroAleatorio][numeroAleatorio2];
			if(!(unaCasilla instanceof CasillaMina)){
				Coordenada nuevaPos = new Coordenada(numeroAleatorio,numeroAleatorio2);
				CasillaMina nuevaMina = new CasillaMina(nuevaPos);
				tablero.getCampoJuego()[numeroAleatorio][numeroAleatorio2] = nuevaMina;
				incrementarAlrededores(nuevaMina.pos);
				contador--;
			}
		}
		System.out.println("bombas puestas");

	}

	@Override
	public void ponerCasillasValor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ponerCasillasRestantes() {
		// TODO Auto-generated method stub

	}

}
