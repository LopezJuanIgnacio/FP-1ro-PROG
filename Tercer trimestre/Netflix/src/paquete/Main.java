package paquete;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Contenido> contenidos = new ArrayList<>();

    public static void main(String[] args) {
        int opt;
        do {
            opt = menu();
            switch (opt) {
                case 1:
                    altaPelicula();
                    break;
                case 2:
                    altaSerie();
                    break;
                case 3:
                    verContenido();
                    break;
                case 4:
                    listarContenido();
                    break;
                case 5:
                    listarPendientes();
                    break;
                case 6:
                    System.out.println("Gracias por utilizar Netflix");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opt != 6);
    }

    public static void altaPelicula() {
        try {
            System.out.println("Introduzca titulo de la pelicula:");
            String titulo = sc.nextLine();
            System.out.println("Introduzca productora de la pelicula:");
            String productora = sc.nextLine();
            System.out.println("Introduzca año de publicacion:");
            int año = sc.nextInt();
            System.out.println("Numero de nominaciones a los oscars:");
            int nominaciones = sc.nextInt();
            while (nominaciones < 0) {
                System.out.println("Error: El número de nominaciones debe ser mayor o igual a 0.");
                System.out.println("Numero de nominaciones a los oscars:");
                nominaciones = sc.nextInt();
            }
            System.out.println("Numero de oscars ganados:");
            int premios = sc.nextInt();
            while (premios > nominaciones) {
                System.out.println("ERROR!, mas oscars ganados que nominaciones!");
                System.out.println("Numero de oscars ganados:");
                premios = sc.nextInt();
            }
            sc.nextLine(); // Limpiar el buffer

            contenidos.add(new Pelicula(titulo, productora, año, nominaciones, premios));
            System.out.println("La pelicula " + titulo + " ha sido dada de alta correctamente!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, introduzca los datos correctamente.");
            sc.nextLine(); // Limpiar el buffer
        }
    }

    public static void altaSerie() {
        try {
            System.out.println("Ingrese el título de la serie:");
            String titulo = sc.nextLine();
            System.out.println("Ingrese la productora:");
            String productora = sc.nextLine();
            System.out.println("Ingrese el año:");
            int año = sc.nextInt();
            while (año < 0) {
                System.out.println("Error: El año debe ser mayor o igual a 0.");
                System.out.println("Ingrese el año:");
                año = sc.nextInt();
            }
            System.out.println("Ingrese el número de temporadas:");
            int temporadas = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            while (temporadas <= 0) {
                System.out.println("Error: El número de temporadas debe ser mayor o igual a 0.");
                System.out.println("Ingrese el número de temporadas:");
                temporadas = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
            }
            System.out.println("¿Está finalizada? (S/N):");
            char letra = (sc.nextLine().toUpperCase()).charAt(0);
            while (letra != 'S' && letra != 'N') {
                System.out.println("¿Está finalizada? (S/N):");
                letra = (sc.nextLine().toUpperCase()).charAt(0);
            }
            boolean finalizada = letra == 'S';
            contenidos.add(new Serie(titulo, productora, año, temporadas, finalizada));
            System.out.println("La serie " + titulo + " ha sido dada de alta correctamente!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, introduzca los datos correctamente.");
            sc.nextLine(); // Limpiar el buffer
        }
    }

    public static void verContenido() {
        System.out.println("Ingrese el título del contenido que desea marcar como visto:");
        String titulo = sc.nextLine();
        boolean encontrado = false;

        for (Contenido contenido : contenidos) {
            if (contenido.getTitulo().equalsIgnoreCase(titulo)) {
                contenido.marcarVisto();
                encontrado = true;
                System.out.println("El contenido ha sido marcado como visto.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El contenido " + titulo + " no existe en Netflix.");
        }
    }

    public static void listarContenido() {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenido registrado.");
        } else {
            for (Contenido contenido : contenidos) {
                System.out.println(contenido.toString());
            }
        }
    }

    public static void listarPendientes() {
        boolean hayPendientes = false;

        for (Contenido contenido : contenidos) {
            if (!contenido.getVisto()) {
                System.out.println(contenido.toString());
                hayPendientes = true;
            }
        }

        if (!hayPendientes) {
            System.out.println("No hay contenido pendiente por ver.");
        }
    }

    public static int menu() {
        int opt = 0;
        try {
            System.out.println("1-Dar de alta una película\r\n"
                    + "2-Dar de alta una serie\r\n"
                    + "3-Ver un contenido\r\n"
                    + "4-Listar contenido\r\n"
                    + "5-Listar contenido pendiente por ver\r\n"
                    + "6-Salir");

            opt = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, introduzca un número.");
            sc.nextLine(); // Limpiar el buffer
        }
        return opt;
    }

    public static class Contenido {
        protected String titulo;
        protected String productora;
        protected int año;
        protected boolean visto;

        public Contenido(String titulo, String productora, int año) {
            this.titulo = titulo;
            this.productora = productora;
            this.año = año;
            this.visto = false;
        }

        public void marcarVisto() {
            this.visto = true;
        }

        public boolean getVisto() {
            return this.visto;
        }

        public String getTitulo() {
            return this.titulo;
        }
    }

    public static class Serie extends Contenido {
        private int temporadas;
        private boolean finalizada;

        public Serie(String titulo, String productora, int año, int temporadas, boolean finalizada) {
            super(titulo, productora, año);
            this.temporadas = temporadas;
            this.finalizada = finalizada;
        }

        @Override
        public String toString() {
            return this.titulo + " | " + this.productora + " | " + this.año + " | " + this.temporadas + " | " + (this.finalizada ? "Finalizada" : "En emisión") + " | " + (this.visto ? "Visto" : "Pendiente"); 
        }
    }

    public static class Pelicula extends Contenido {
        private int nominaciones;
        private int premios;

        public Pelicula(String titulo, String productora, int año, int nominaciones, int premios) {
            super(titulo, productora, año);
            this.nominaciones = nominaciones;
            this.premios = premios;
        }

        @Override
        public String toString() {
            return this.titulo + " | " + this.productora + " | " + this.año + " | " + this.nominaciones + " | " + this.premios + " | " + (this.visto ? "Visto" : "Pendiente");
        }
    }
}
