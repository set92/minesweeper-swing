package packModelo;

import java.util.ArrayList;

public class ListaCasillas {
    private ArrayList<Casilla> listaCasilla;
    
    public ListaCasillas(){
    	this.listaCasilla = new ArrayList<Casilla>();
    }
    
    public int size(){return listaCasilla.size();}

    public ArrayList<Casilla> getListCasilla() {
        return listaCasilla;
    }

    public void expandirVecinos(){
        for (Casilla cas : listaCasilla) {
            cas.descubrirCasilla();
        }
    }

}
