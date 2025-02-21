package paquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Objeto Scanner para leer la entrada del usuario
    public static Scanner sc = new Scanner(System.in);

    // Listas para almacenar Naves y Flotas
    public static ArrayList<Nave> naves = new ArrayList<>();
    public static ArrayList<Flota> flotas = new ArrayList<>();

    public static void main(String[] args) {
        int opt;
        do {
            opt = menu(); // Mostrar menú y obtener opción del usuario
            switch (opt) {
                case 1: {
                    altaNave(); // Añadir una nueva Nave
                    break;
                }
                case 2: {
                    altaTripulante(); // Añadir un nuevo Tripulante a una Nave
                    break;
                }
                case 3: {
                    altaFlota(); // Añadir una nueva Flota
                    break;
                }
                case 4: {
                    consultarNave(); // Consultar detalles de una Nave
                    break;
                }
                case 5: {
                    consultarFlota(); // Consultar detalles de una Flota
                    break;
                }
            }

        } while (opt != 0); // Repetir hasta que el usuario elija salir

        System.out.println("Que la fuerza te acompañe"); // Mensaje de despedida

    }

    // Mostrar menú y obtener opción del usuario
    public static int menu() {
        int opt;

        System.out.println("----------- Menú de la galaxia -----------");
        System.out.println("1-Alta de nave \t 4-Consultar nave");
        System.out.println("2-Alta de tripulante \t 5-Consultar flota");
        System.out.println("3-Alta de flota \t 0-Salir");
        System.out.println("------------------------------------------");
        System.out.println("Introduzca opción:");

        opt = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        return opt;
    }

    // Método para dar de alta una nueva nave
    public static void altaNave() {
        String n;
        System.out.println("Introduzca nombre de la nave:");
        n = sc.nextLine();
        naves.add(new Nave(n));

    }

    // Método para dar de alta un nuevo tripulante en una nave existente
    public static void altaTripulante() {
        String nomNave, nom, rango;
        int edad, ind;

        System.out.println("Introduzca nombre de la nave donde desea dar de alta al tripulante:");
        nomNave = sc.nextLine();
        ind = buscarNave(nomNave);

        if (ind == -1) {
            System.out.println("No existe la nave");
            return;
        }

        System.out.println("Introduzca el nombre del tripulante para la nave:");
        nom = sc.nextLine();

        System.out.println("Introduzca la edad del nuevo tripulante:");
        edad = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.println("Introduzca su rango (Soldado, Capitan, Comandante):");
            rango = sc.nextLine();

            if (rango.equals("Soldado") || rango.equals("Capitan") || rango.equals("Comandante")) {
                naves.get(ind).aniadirTripulante(new Tripulante(nom, edad, rango));
                return;
            }
            System.out.println("Rango incorrecto");
        }

    }

    // Método para dar de alta una nueva flota
    public static void altaFlota() {
        String aux, nom;
        int ind;

        System.out.println("Introduzca nombre para su flota:");
        nom = sc.nextLine();

        flotas.add(new Flota(nom));

        while (true) {
            System.out.println("Introduzca nombre de nave para añadir a la flota " + flotas.get(flotas.size() - 1).getNombre() + " (hasta teclear 'salir'):");
            aux = sc.nextLine();

            //Si el usuario teclea "salir" salimos del bucle
            if (aux.equalsIgnoreCase("salir")) break;

            ind = buscarNave(aux); //Buscamos la nave en la lista de naves

            //Si no existe la nave mostramos un mensaje
            if (ind == -1) System.out.println("No existe la nave");
            else {
                //Si existe la nave la añadimos a la flota
                //La última flota añadida es flotas.get(flotas.size()-1)
                flotas.get(flotas.size() - 1).aniadirNave(naves.get(ind));
                System.out.println("La nave " + naves.get(ind).getNombre() + " se añade a la flota " + flotas.get(flotas.size() - 1).getNombre());
            }
        }

    }

    // Método para consultar los detalles de una nave
    public static void consultarNave() {
        String nom;
        int ind;

        System.out.println("Introduzca el nombre de la nave:");
        nom = sc.nextLine();

        ind = buscarNave(nom);

        if (ind == -1) {
            System.out.println("No existe la nave");
            return;
        }

        System.out.println("Encontrada la nave " + naves.get(ind).getNombre() + " con " + naves.get(ind).getTripulantes().size() + " tripulantes:");

        for (Tripulante t : naves.get(ind).getTripulantes()) {
            t.presentarse();
        }

    }

    // Método para consultar los detalles de una flota
    public static void consultarFlota() {
        String nom;
        int ind;

        System.out.println("Introduzca el nombre de la Flota:");
        nom = sc.nextLine();

        ind = buscarFlota(nom);

        if (ind == -1) {
            System.out.println("No existe la flota");
            return;
        }

        System.out.println("Encontrada la flota " + flotas.get(ind).getNombre() + " con " + flotas.get(ind).getNaves().size() + " naves:");

        for (Nave t : flotas.get(ind).getNaves()) {
            System.out.println("\t - " + t.getNombre());
        }

    }

    // Método para buscar una nave por su nombre
    public static int buscarNave(String nom) {
        int ind = -1;

        for (int i = 0; i < naves.size(); i++) {
            //Recorremos la lista de naves y comparamos el nombre
            if (naves.get(i).getNombre().equals(nom)) {
                ind = i;
                break;
            }
        }

        return ind;
    }

    // Método para buscar una flota por su nombre
    public static int buscarFlota(String nom) {
        int ind = -1;

        for (int i = 0; i < flotas.size(); i++) {
            if (flotas.get(i).getNombre().equals(nom)) {
                ind = i;
                break;
            }
        }

        return ind;
    }
}
