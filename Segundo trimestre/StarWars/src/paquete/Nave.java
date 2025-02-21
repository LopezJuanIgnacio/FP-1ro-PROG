package paquete;
import java.util.ArrayList;

public class Nave {

	private String nombre;
	private ArrayList<Tripulante> tripulantes;

    public Nave(String nombre) {
        this.nombre = nombre;
        this.tripulantes = new ArrayList();
    }
    
    public String getNombre() {
		return nombre;
	}
    public ArrayList<Tripulante> getTripulantes() {
		return tripulantes;
	}

    public void aniadirTripulante(Tripulante t) {
    	this.tripulantes.add(t);
    }
    

}
