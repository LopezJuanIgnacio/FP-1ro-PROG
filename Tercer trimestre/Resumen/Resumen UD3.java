
import java.io.IOException;
import java.lang.reflect.Array;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ResumenUD3 {

    public static void main(String[] args) {
        //UD 8 - Excepciones
        // TRY CATCH
        try {
            // Codigo con errores
        } catch (ExceptionA e) {
            // Manejo de la excepción A
        } catch (ExceptionB e) {
            // Manejo de la excepción B
        } catch (Exception e) {
            // Manejo de la excepción genérica
        }
        // Ejemplo real
        String texto[] = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("indice " + i + " = " + texto[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Fallo en el índice " + i);
            }
        }

        try {
            System.out.print("Valor: ");
            int valor = sc.nextInt();
            int auxiliar = 8 / valor;
            System.out.println(auxiliar);
        } catch (ArithmeticException e) {
            System.out.println("Division por cero");
        }

        // TRY CATCH FINALLY
        try {
            System.out.print("Valor: ");
            int valor = lector.nextInt();
            int auxiliar = 8 / valor;
            System.out.println(auxiliar);
        } catch (ArithmeticException e1) {
            System.out.println("Division por cero");
        } catch (InputMismatchException e2) {
            System.out.println("No se ha leído un entero....");
        } catch (Exception e9) {
            System.out.println("Error general");
        } finally {
            lector.nextLine(); // Se ejecuta siempre
        }

        // Metodos
        try {
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage()); // Muestra el mensaje de error
            System.out.println(ioe.toString()); // Muestra la clase y el mensaje de error
            ioe.printStackTrace(); // Muestra la pila de llamadas
        }

        // Crear excepciones
        new ArithmeticException();
        Exception error = new Exception();
        Exception correoErroneo = new Exception("E-MAIL ERRONEO !!!");

        class MisErrores extends Exception {
        } //Aca escribis la clase de tu excepcion

        // Lanzar excepciones
        try {
            throw new Exception("Error de lectura");
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Error de lectura
        }
        //Cuando la excepción es lanzada por un método, se debe indicar en la cabecera del método
    public void miMetodo() throws Exception {
        throw new Exception("Error en miMetodo");
    }

    //UD 9 - POO AVANZADO
    // HERENCIA
    class Producto {

        protected String nombre;
        protected int cod;

        public Producto(String nombre, int cod) {
            this.nombre = nombre;
            this.cod = cod;
        }
    }

    //Herencia: Permite que una clase (subclase) herede atributos y métodos de otra clase (superclase),
    //    promoviendo la reutilización de código y la extensibilidad.
    class Pelicula extends Producto {

        private String director;
        private int duracion;

        public Pelicula(String nombre, int cod, String director, int duracion) {
            super(nombre, cod); // Llamada al constructor de la clase padre
            // Inicialización de los atributos propios de la clase
            this.director = director;
            this.duracion = duracion;
        }

        //Sobreescritura de métodos: Permite que una subclase modifique la implementación de un método heredado.
        @Override
        public String toString() {
            return "Pelicula{"
                    + "nombre='" + nombre + '\''
                    + ", cod=" + cod
                    + ", director='" + director + '\''
                    + ", duracion=" + duracion
                    + '}';
        }

    }

    class Libro extends Producto {

        private String autor;
        private int paginas;

        public Libro(String nombre, int cod, String autor, int paginas) {
            super(nombre, cod); // Llamada al constructor de la clase padre
            // Inicialización de los atributos propios de la clase
            this.autor = autor;
            this.paginas = paginas;
        }

        public void anuncio() {
            System.out.println("Nuevo libro de " + autor);
        }

        public void anuncio(int cantidad) {
            System.out.println("Nuevo libro de " + autor + " en cantidad " + cantidad);
        }

    }

    // POLIMORFISMO
    //Polimorfismo: Permite que un objeto pueda comportarse de diferentes formas, según el contexto en el que se encuentre.
    //    Se basa en la herencia y la sobreescritura de métodos.
    Pelicula p = new Pelicula("El padrino", 1, "Francis Ford Coppola", 175);
    Libro l = new Libro("El Quijote", 2, "Miguel de Cervantes", 200);

    //Se puede almacenar en un array de la clase padre
    Producto[] productos = new Producto[2];
    productos
     [0] = p ;
    productos
     [1] = l ;

    ArrayList<Producto> lista = new ArrayList<>();

    lista.add (p);

    lista.add (l);

    //También tenemos polimorfismo cuando definimos distintos métodos que
    //reciben el mismo nombre pero que difieren
    l.anuncio ();

    l.anuncio (

    10);

    // INTERFACES
    //Interfaces: Permiten definir un contrato que deben cumplir las clases que la implementan.
    //    Se definen con la palabra clave interface.
    interface Interfaz_Producto {

        final int IVA = 21; // Constante

        void mostrarPrecio();

        float precio_con_iva();
    }

    public class Libro2 extends Producto implements Interfaz_Producto {

        private int numPags;
        private String autor;
        private float precio;

        // Constructor 
        public Libro2(String nombre, int cod, int numPags, String autor, float precio) {
            super(nombre, cod);
            this.numPags = numPags;
            this.autor = autor;
            this.precio = precio;
        }

        // Implementación de los métodos de la interfaz
        // Se debe implementar todos los métodos de la interfaz
        // Si no se implementa alguno, la clase debe ser abstracta
        @Override
        public void mostrarPrecio() {
            System.out.println("El precio del libro es " + precio);
        }

        @Override
        public float precio_con_iva() {
            return precio + precio * IVA / 100;
        }

    }

    // CLASES ABSTRACTAS
    //Clases abstractas: Permiten definir métodos sin implementar, que deben ser implementados por las subclases OBLIGATORIAMENTE.
    //    Se definen con la palabra clave abstract.
    abstract class Figura {

        protected String color;

        public Figura(String color) {
            this.color = color;
        }

        // Método abstracto
        public abstract float area();
    }

    class Circulo extends Figura {

        private float radio;

        public Circulo(String color, float radio) {
            super(color);
            this.radio = radio;
        }

        @Override
        public float area() {
            return (float) (Math.PI * Math.pow(radio, 2));
        }
    }

    class Rectangulo extends Figura {

        private float base;
        private float altura;

        public Rectangulo(String color, float base, float altura) {
            super(color);
            this.base = base;
            this.altura = altura;
        }

        @Override
        public float area() {
            return base * altura;
        }
    }

        //UD 10 - Ficheros
        // Ficheros de texto
        File f = new File(String ruta);

        //Metodos
        f.getName(); // Nombre del fichero
        f.getAbsolutePath(); // Ruta absoluta del fichero
        f.getPath(); // Ruta relativa del fichero
        f.getParent(); // Ruta del directorio padre

        f.length(); // Tamaño del fichero en bytes
        f.lastModified(); // Fecha de la última modificación
        
        f.exists(); // Comprobar si existe el fichero
        f.isFile(); // Comprobar si es un fichero
        f.isDirectory(); // Comprobar si es un directorio
        f.mkdir(); // Crear un directorio
        f.mkdirs(); // Crear un directorio y todos sus padres
        f.delete(); // Eliminar un fichero o directorio
        f.renameTo(new File("nuevo_nombre.txt")); // Renombrar un fichero o directorio

        File[] lista = f.listFiles(); // Listar los ficheros de un directorio

        //Lectura y escritura de ficheros
        try {
            // Intentamos abrir el fichero
            File f = new File("Enteros.txt");
            Scanner lector = new Scanner(f);
            // Si llega aquí es que ha abierto el fichero :)
            while (lector.hasNext()) {
            String valor = lector.next();
            System.out.println("El valor leído es: " + valor);
            }
            // ¡Hay que cerrar el fichero!
            lector.close();
        } catch (Exception e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }

        // Escritura de ficheros

        try {
            FileWriter fw = new FileWriter("Enteros.txt", true); // true para añadir al final, false para sobreescribir
            fw.write("Hola mundo\n");
            fw.write(65); // Escribir un caracter de valor 65 en la tabla ascii(A)
            fw.write("" + 33); // Escribir el número 33
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        try {
            File f = new File("Enteros.txt");
            FileWriter fw = new FileWriter(f);
            int valor = 1;
            for (int i = 1; i <= 20; i++) {
            fw.write("" + valor); // escribimos valor
            fw.write(" "); // escribimos espacio en blanco
            valor = valor * 2; // calculamos próximo valor
            }
            fw.write("\n"); // escribimos nueva línea
            fw.close(); // cerramos el FileWriter
            System.out.println("Fichero escrito correctamente");
            } catch (IOException e) {
            System.out.println("Error: " + e);
            }


            //Serialización de objetos
            //Serialización: Proceso de convertir un objeto en una secuencia de bytes para almacenarlo o transmitirlo.
            //Deserialización: Proceso inverso, convertir una secuencia de bytes en un objeto.


            //Clase que implementa Serializable
            class Persona implements Serializable {
                private String nombre;
                private int edad;

                public Persona(String nombre, int edad) {
                    this.nombre = nombre;
                    this.edad = edad;
                }

                @Override
                public String toString() {
                    return "Persona{" +
                            "nombre='" + nombre + '\'' +
                            ", edad=" + edad +
                            '}';
                }
            }

            //Serialización de un objeto
            try {
                FileOutputStream fos = new FileOutputStream("persona.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                Persona p = new Persona("Juan", 30);
                oos.writeObject(p);
                oos.close();
                fos.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }

            //Deserialización de un objeto
            try{
                FileInputStream fis = new FileInputStream("persona.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Persona p = (Persona) ois.readObject();
                Persona p2 = (Persona) ois.readObject();
                System.out.println(p);
                System.out.println(p2);
                ois.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e);
            }

    }

}
