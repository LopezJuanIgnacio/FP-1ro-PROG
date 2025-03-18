import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        a8();
    }

    // A
    // 8
    public static void a8() {
        try {
            int a;
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce un número: ");
            a = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: No has introducido un número entero");
        }
    }

    // 9
    public static void a9() {
        try {
            int a, b;
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce un número: ");
            a = sc.nextInt();

            System.out.println("Introduce otro número: ");
            b = sc.nextInt();

            System.out.println("La división de " + a + " entre " + b + " es " + a / b);
        } catch (InputMismatchException e) {
            System.out.println("Error: No has introducido un número entero");
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir entre 0");
        }

    }

    // 10
    public static void a10() {
        double[] vector = new double[5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < vector.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Introduce un número para la posición " + i + ": ");
                    vector[i] = sc.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: No has introducido un número válido. Inténtalo de nuevo.");
                    sc.next(); // Limpiar el buffer del scanner
                }
            }
        }

        System.out.println("Vector rellenado correctamente:");
        for (double num : vector) {
            System.out.println(num);
        }
    }

    // 11
    public static void a11() {
        int[] vector;
        int n = (int) (Math.random() * 100) + 1; // Tamaño aleatorio entre 1 y 100
        vector = new int[n];

        // Rellenar el vector con valores aleatorios entre 1 y 10
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 10) + 1;
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Introduce una posición del vector para mostrar (valor negativo para salir): ");
                int pos = sc.nextInt();

                if (pos < 0) {
                    System.out.println("Saliendo del programa.");
                    break;
                }

                System.out.println("El valor en la posición " + pos + " es: " + vector[pos]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: La posición introducida está fuera de los límites del vector.");
            } catch (InputMismatchException e) {
                System.out.println("Error: No has introducido un número válido.");
                sc.next(); // Limpiar el buffer del scanner
            }
        }
    }

    // C
    // 1
    public static void c1() {
        Scanner in = new Scanner(System.in);
        int num;

        for (int i = 0; i < 5; i++) {
            try {
                System.out.print("Introduce un entero positivo: ");
                num = in.nextInt();
                imprimePositivo(num);

                System.out.print("Introduce un entero negativo: ");
                num = in.nextInt();
                imprimeNegativo(num);
            } catch (InputMismatchException e) {
                System.out.println("Valor introducido incorrecto");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("Error: número negativo");
        }

        System.out.println("El número positivo es el: " + p);
    }

    static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("Error: número positivo");
        }

        System.out.println("El número negativo es el: " + n);
    }

    // 2
    public static void c2() {
        try {
            enviarMensaje("asdasd");
            enviarMensaje("asdasd@gmail.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void enviarMensaje(String correo) throws Exception {
        if (correo.contains("@") &&
                correo.contains(".com")) {
            System.out.println("Mensaje enviado a " + correo);
        } else {
            throw new Exception("Correo no válido");
        }

    }

    // 3

    public static class C3Gato {

        // Atributos
        private String nombre;
        private int edad;

        // Constructor
        public C3Gato(String nombre, int edad) throws Exception {
            this.setNombre(nombre);
            this.setEdad(edad);
        }

        // Getters y setters
        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) throws Exception {
            if (nombre.length() < 3) {
                throw new Exception("ERROR: El nombre debe tener al menos 3 carácteres");
            }

            this.nombre = nombre;
        }

        public int getEdad() {
            return this.edad;
        }

        public void setEdad(int edad) throws Exception {
            if (edad < 0) {
                throw new Exception("ERROR: La edad no puede ser negativa");
            }

            this.edad = edad;
        }

        // Método imprimir
        public void imprimir() {
            System.out.println("El gato se llama " + this.getNombre() + " y tiene " + this.getEdad() + " años de edad");
        }

    }

    // 4
    public static void c4() {
        try {
            ArrayList<C3Gato> gatos = new ArrayList<C3Gato>();
            Scanner sc = new Scanner(System.in);
            String nombre;
            int edad;

            do {
                try {
                    // Pedimos por teclado el nombre y la edad del gato
                    System.out.println("Introduce los datos del gato " + gatos.size());
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    edad = sc.nextInt();
                    sc.nextLine();

                    // Creamos el objeto Gato
                    C3Gato g = new C3Gato(nombre, edad);

                    // Añadimos el objeto Gato al ArrayList
                    gatos.add(g);

                } catch (Exception e) {
                    System.err.println(e);
                    sc.nextLine();
                }

            } while (gatos.size() < 5);

            for (C3Gato gato : gatos) {
                gato.imprimir();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 5
    public static class C5AgotadoException extends Exception {

        public C5AgotadoException(String msj) {
            super(msj);
        }
    }
    
    public static class Corredor {
        private int energia;

        public Corredor(int energia){
            this.energia = energia;
        }

        public int getEnergia() {
            return this.energia;
        }

        public void recargarEnergia(int energia){
            this.energia += energia;
        }

        public void correr() throws Exception {
            if (0 > this.getEnergia() - 10) {
                throw new C5AgotadoException("No tienes suficiente energía para correr");
            }
            this.energia -= 10;
        }

    }

    public static void c5() {
        int c = 0;
        Corredor corredor = new Corredor(50);
        while(c <3){
            try {
                while(true) corredor.correr();
            }
            catch(C5AgotadoException e){
               c++;
                if (c == 1) {
                    corredor.recargarEnergia(30);
                    System.out.println("Energía recargada con 30 unidades.");
                } else if (c == 2) {
                    corredor.recargarEnergia(10);
                    System.out.println("Energía recargada con 10 unidades.");
                } else if (c == 3) {
                    System.out.println("Entrenamiento concluido.");
                    break;
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
