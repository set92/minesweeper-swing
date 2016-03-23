package packModelo;

public abstract class Casilla {
    protected Coordenada pos;
    protected boolean marcadaBandera;
    protected boolean descubierta;

<<<<<<< HEAD
    public Casilla(Coordenada pCord){
    	this.pos = pCord;
    	this.descubierta = false;
    	this.marcadaBandera = false;
    }
    
    public void descubrirCasilla(){
    	if (!descubierta) marcarDescubierta();
    }

    public Coordenada getCoordenada(){return this.pos;}
    
    public void marcarBandera(){this.marcadaBandera = true;}
    
    public void desmarcarVacia(){this.marcadaBandera = false;}
    
    public void marcarDescubierta(){this.descubierta = true;}
=======
    public Casilla(Coordenada pCord) {
        this.pos = pCord;
        this.descubierta = false;
        this.marcadaBandera = false;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void descubrirCasilla() {
        if (!descubierta) marcarDescubierta();
    }

    public void desmarcarVacia() {
        this.marcadaBandera = false;
    }

    public Coordenada getCoordenada() {
        return this.pos;
    }

    public void marcarBandera() {
        this.marcadaBandera = true;
    }

    public void quitarBandera() {
        this.marcadaBandera = false;
    }

    public void marcarDescubierta() {
        this.descubierta = true;
    }

    public boolean getMarcadaBandera() {
        return marcadaBandera;
    }
>>>>>>> 626fef66833eecdfd5483d52af031eaa71bd1fc1
}
