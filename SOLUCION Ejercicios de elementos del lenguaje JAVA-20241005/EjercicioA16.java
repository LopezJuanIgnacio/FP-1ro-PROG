import java.util.Scanner;

public class EjercicioA16 {

    public static void main(String[] args) {
        // Variables
        int segleidos;
        int seg, min, horas, dias;

        // Lectura de teclado
        Scanner lector = new Scanner(System.in);
        System.out.print("Introduce los segundos: ");
        segleidos =  lector.nextInt();
        
        // Convertimos segundos a min/horas/dias
        min = segleidos / 60;
        horas = min / 60;
        dias = horas / 24;

        // Normalizamos los valores
        seg = segleidos % 60;
        min = min % 60;
        horas = horas % 24;
        
        // Mostramos valores
        System.out.println("Dias:\t" + dias);
        System.out.println("Horas:\t" + horas);
        System.out.println("Minutos:\t" + min);
        System.out.println("Segundos:\t" + seg);

    }
}
