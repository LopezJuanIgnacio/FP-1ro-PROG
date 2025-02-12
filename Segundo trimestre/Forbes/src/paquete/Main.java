package paquete;
import  java.util.*;

public class Main {
    //Declaramos un scanner publico
    public static Scanner sc = new Scanner(System.in);

    public static class Magnate{
        //Declaramos atributos
        String nombre;
        int pasta;

        public Magnate(String nom, int pasta){
            this.nombre = nom;
            this.pasta = pasta;
        }
        
        public String getNombre() {
			return nombre;
		}
        
        public int getPasta() {
			return pasta;
		}
        
    }
	
	public static void main(String[] args) {
		//Declaramos varibles iniciales
        int nroRevista = pedirNro();
        ArrayList<Magnate> magnates = new ArrayList<>();
        String auxNombre;
        int auxPasta;

        do { 
            //Pedimos los datos
        	sc.nextLine();
            System.out.println("Introduzca nombre de rico para la revista " + nroRevista +":");
            auxNombre = sc.nextLine();

            if(auxNombre.equalsIgnoreCase("salir")) break;

            System.out.println("Introduzca dinero que dice tener " + auxNombre+":");
            auxPasta = sc.nextInt();

            //Checkeamos con las funciones si cumple para entrar
            //Si cumple, entra al array sino no
            //Todo esto se anuncia por consola
            if(decidir_nombre_rico( auxNombre) && decidir_pasta_rico(auxPasta)){
                magnates.add(new Magnate(auxNombre, auxPasta));
                System.out.println(auxNombre+" insertado en el Arraylist de forbes en la posicion " + magnates.size());
            }else System.out.println(auxNombre+" es muy pobre y no puede aparecer en forbes!");
            
        } while (true);

        System.out.println("Los ricos introducidos son los siguientes:");
        
        for (Magnate m : magnates) {
            System.out.print(m.getNombre() + " ");
        }

	}

    //Devolvemos si contiene una e y una o
    public static boolean decidir_nombre_rico(String nombre_rico){
        boolean cond = nombre_rico.contains("e") && nombre_rico.contains("o");
       //El enunciado dice que hay que mostrar “¡Ese no es nombre de rico!” en caso de que no lo sea
        //En el ejemplo del enunciado, hay un magnate que se llama pepe
        //Pero en ningun momento se muestra este mensaje
        //Voy a asumir que poner la instruccion en esta funcion y que no afecte al resto de la ejecucion es lo correcto
        if(!cond) System.out.println("¡Ese no es nombre de rico!");
        return cond;
    }

    //Devolvemos si la pasta es mayor a 6000
    public static boolean decidir_pasta_rico(int pasta_rico){
        return pasta_rico > 6000;
    }

    public static int pedirNro(){
        int nro;

        //Pedimos y recibimos el nro en un bucle hasta que nos pase uno correcto
        while (true) { 
            System.out.println("Introduzca el numero de la revista:");
            nro = sc.nextInt();
            if(nro >=2000) break;
        }

        return nro;
    }

}
