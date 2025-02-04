import java.util.*;

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 25);
        persona1.mostrarInfo();

        persona1.setNombre("Carlos");
        persona1.setEdad(30);
        persona1.mostrarInfo();
        Persona[] personas = {
            new Persona("Ana", 22),
            new Persona("Luis", 28),
            new Persona("Marta", 35)
        };
        //Tambien se puede usar.
        //ArrayList<Persona> listaPersonas = new ArrayList<>();

        for (Persona persona : personas) {
            persona.mostrarInfo();
        }
    }
}