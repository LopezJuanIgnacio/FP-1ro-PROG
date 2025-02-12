package paquete;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Declaramos variables
        String nombres;
        Queue<String> cola = new LinkedList<>();
        int desencolados;

        while (true) {

            // Pedimos los nombres
            nombres = pedirNombres();

            // Verificamos si quiere salir
            if (nombres.equalsIgnoreCase("Salir"))
                return;
            //Verificamos si no quiere encolar a nadie
            else if (!nombres.equalsIgnoreCase("Nadie")) {
                // El string tiene muchos nombres separados por @ y los separamos
                String[] nombresSeparados = nombres.split("@");
                for (int i = 0; i < nombresSeparados.length; i++) {
                    cola.add(nombresSeparados[i]);
                }
            }

            // Mostramos los nombres
            System.out.println("Estado de la cola despues de ENTRAR: ");
            for (String nombre : cola) {
                System.out.println(nombre);
            }

            do {
                // Pedimos la cantidad de nombres a desencolar
                desencolados = pedirDesencolados();
                
                // Verificamos si la cantidad de nombres a desencolar es correcta
                if (desencolados >= 0 && desencolados <= cola.size()) break;
                
                // Si no es correcta mostramos un mensaje
                System.out.println("La cantidad de nombres a desencolar no es correcta");
            } while (true);

            // Desencolamos
            for (int i = 0; i < desencolados; i++) {
                System.out.println("Se sale de la cola: " + cola.remove());
            }

            // Mostramos los nombres
            System.out.println("Estado de la cola despues de SALIR: ");
            for (String nombre : cola) {
                System.out.println(nombre);
            }

        }

    }

    public static String pedirNombres() {
        Scanner sc = new Scanner(System.in);
        String nombres;
        System.out.println("Introduce los nombres de los clientes separados por @");
        System.out.println("Si no hay nadie introduce 'Nadie'");
        System.out.println("Si quieres salir introduce 'Salir'");
        nombres = sc.nextLine();
        return nombres;
    }

    public static int pedirDesencolados() {
        Scanner sc = new Scanner(System.in);
        int desencolados;
        System.out.println("Introduce la cantidad de nombres que quieres desencolar");
        desencolados = sc.nextInt();
        return desencolados;
    }

}
