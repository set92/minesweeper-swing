package packModelo;


public class Buscaminas {
    private TableroBuilder tableroBuilder;
    private Tablero tablero;
   // private int puntuacion;
   // private int tiempo;
    private static Buscaminas miBuscaminas = null;

    public static Buscaminas getBuscaminas(int pNivel){
    	if (miBuscaminas == null){
    		miBuscaminas = new Buscaminas(pNivel);
    	}
    	return miBuscaminas;
    }
    
    private Buscaminas(int pNivel) {
    	if (pNivel == 1){
    		tableroBuilder = new BuilderN1();
    	}
    	else if (pNivel == 2){
    		tableroBuilder = new BuilderN2();
    	}
    	else if (pNivel == 3){
    		tableroBuilder = new BuilderN3();
    	}
    	construirTablero();
    }
    
    private void construirTablero(){
    	tablero = tableroBuilder.construirTablero();
    }
   
  
    /*
    //ESTO NO ES PARTE DEL CÓDIGO A IMPLEMENTAR, ES SIMPLEMENTE UN EJEMPLO QUE NOS SIRVE A SERGIO Y A MI.
    public static void main(String args[]){
    	/*Coordenada cor = new Coordenada(1,3);
    	Casilla casm = new CasillaValor(cor);
    	Casilla casv = new CasillaValor(cor);
    	ArrayList<Casilla> cas = new ArrayList<Casilla>();
    	cas.add(casm);
    	cas.add(casv);
    	for (Casilla casil : cas ) casil.marcarBandera(); 	
	}*/
    
   
    
   
}
