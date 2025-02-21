package paquete;

public class Tripulante {
	
	private String nombre;
	private int edad;
	private String rango;
	
	public Tripulante(String nombre, int edad, String rango) {
		this.nombre = nombre;
		this.edad = edad;
		this.rango = rango;
	}
	
	public int getEdad() {
		return edad;
	}
	public String getNombre() {
		return nombre;
	}
	public String getRango() {
		return rango;
	}
	public void presentarse() {
		System.out.println("\t - " + this.rango + " " + this.nombre + "(" +  this.edad + ")");
	}

}
