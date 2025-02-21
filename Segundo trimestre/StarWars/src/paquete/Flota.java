package paquete;
import java.util.ArrayList;

public class Flota {
	
	private String nombre;
	private ArrayList<Nave> naves;

    public Flota(String nombre) {
        this.nombre = nombre;
        this.naves = new ArrayList();
    }
	
    public ArrayList<Nave> getNaves() {
		return naves;
	}
    public String getNombre() {
		return nombre;
	}
    public void aniadirNave(Nave t) {
    	this.naves.add(t);
    }

}
