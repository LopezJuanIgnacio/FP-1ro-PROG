import java.util.Scanner;

public class EjercicioA18 {

    public static void main(String[] args) {
        // Variables
        int cantidad;
        float interes;
        int retHac = 18;
        float beneficio, retencion, cantidadFinal;
        float tiempo; // años

        // Cración de Scanner
        Scanner lector = new Scanner(System.in);
        
        // Pedimos valores
        System.out.print("Introduce la cantidad: ");
        cantidad = lector.nextInt();
        System.out.print("Introduce el tipo de interes: ");
        interes = lector.nextFloat();
        System.out.print("Introduce la duracion del plazo (en años) : ");
        tiempo = lector.nextInt();

        // Cálculos
        beneficio = ((cantidad * interes) / 100) * tiempo;
        retencion = (beneficio * retHac) / 100;
        cantidadFinal = cantidad + beneficio - retencion;

        // Mostrar cálculos
        System.out.println();
        System.out.println("\tCantidad inicial: " + cantidad + " €");
        System.out.println("\tIntereses anuales: " + beneficio + " €");
        System.out.println("\tRetencion Hacienda: " + retencion + " €");
        System.out.println("\tCantidad final: " + cantidadFinal + " €");
        System.out.println();
    }
}