
import java.util.Scanner;


public class Contactos {
    public static class Contacto{
        public String nombre;
        public String num;
        public String correo;
    }

    public static class cNodo{
        public Contacto contacto;
        public cNodo siguiente;
    }
    public static void main(String[] args) {
        cNodo contactos = null;
        int opt;
        Scanner sc = new Scanner(System.in);

        do { 
            System.out.println("1. Ver contactos");
            System.out.println("2. Añadir contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Buscar por número");
            System.out.println("6. Buscar por correo");
            System.out.println("7. Buscaqueda global");
            System.out.println("8. Salir");

            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    Ver(contactos);
                    break;
                case 2:
                    contactos = Añadir(contactos);
                    break;
                case 3:
                    contactos = Eliminar(contactos);
                    break;
                case 4:
                    BuscarNombre(contactos);
                    break;
                case 5:
                    BuscarNumero(contactos);
                    break;
                case 6:
                    BuscarCorreo(contactos);
                    break;
                case 7:
                    BusquedaGlobal(contactos);
                    break;
                default:
                    break;
            }

        } while (opt != 8);
    }

    public static void Ver(cNodo contactos) {
        cNodo aux = contactos;
        int i = 0;

        System.out.println("Contactos:");

        while (aux != null) {
            System.out.print(i + ".-");
            MostrarNodo(aux);
            aux = aux.siguiente;
            i++;
        }
    }

    public static cNodo Añadir(cNodo contactos) {
        Scanner sc = new Scanner(System.in);
        cNodo aux = contactos;
        cNodo nuevo = new cNodo();
        Contacto nuevoContacto = new Contacto();

        System.out.println("Ingrese el nombre");
        nuevoContacto.nombre = sc.nextLine();
        System.out.println("Ingrese el número");
        nuevoContacto.num = sc.nextLine();
        System.out.println("Ingrese el correo");
        nuevoContacto.correo = sc.nextLine();

        nuevo.contacto = nuevoContacto;

        if (contactos == null || contactos.contacto.nombre.compareTo(nuevo.contacto.nombre) > 0) {
            nuevo.siguiente = contactos;
            contactos = nuevo;
        } else {
            while (aux.siguiente != null && aux.siguiente.contacto.nombre.compareTo(nuevo.contacto.nombre) < 0) {
                aux = aux.siguiente;
            }
            nuevo.siguiente = aux.siguiente;
            aux.siguiente = nuevo;
        }
        
        return contactos;
    }

    public static cNodo Eliminar(cNodo contactos) {
        Scanner sc = new Scanner(System.in);
        int  x;

        System.out.println("Ingrese el numero de lista a eliminar");
        x = sc.nextInt();

        if (x == 0) {
            contactos = contactos.siguiente;
        } else {
            cNodo aux = contactos;
            for (int i = 1; i < x - 1; i++) {
                aux = aux.siguiente;
            }
            aux.siguiente = aux.siguiente.siguiente;
        }

        return contactos;
    }

    public static void BuscarNombre(cNodo contactos) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int cont = 0;

        System.out.println("Ingrese el nombre a buscar");
        nombre = sc.nextLine();

        cNodo aux = contactos;

        while (aux != null) {
            if (aux.contacto.nombre.equalsIgnoreCase(nombre)) {
                MostrarNodo(aux);
                cont++;
            }
            aux = aux.siguiente;
        }
        if (cont == 0) {
            System.out.println("No se encontraron coincidencias");
        }
    }
    public static void BuscarNumero(cNodo contactos) {
        Scanner sc = new Scanner(System.in);
        String num;
        int cont = 0;

        System.out.println("Ingrese el nombre a buscar");
        num = sc.nextLine();

        cNodo aux = contactos;

        while (aux != null) {
            if (aux.contacto.num.equals(num)) {
                MostrarNodo(aux);
                cont++;
            }
            aux = aux.siguiente;
        }
        if (cont == 0) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public static void BuscarCorreo(cNodo contactos) {
        Scanner sc = new Scanner(System.in);
        String correo;
        int cont = 0;

        System.out.println("Ingrese el nombre a buscar");
        correo = sc.nextLine();

        cNodo aux = contactos;

        while (aux != null) {
            if (aux.contacto.correo.equalsIgnoreCase(correo)) {
                MostrarNodo(aux);
                cont++;
            }
            aux = aux.siguiente;
        }
        if (cont == 0) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public static void BusquedaGlobal(cNodo contactos) {
        Scanner sc = new Scanner(System.in);
        String busqueda;
        int cont = 0;

        System.out.println("Ingrese el nombre a buscar");
        busqueda = sc.nextLine();

        cNodo aux = contactos;

        while (aux != null) {
            if (aux.contacto.nombre.equalsIgnoreCase(busqueda) || aux.contacto.correo.equalsIgnoreCase(busqueda) || aux.contacto.num.equals(busqueda)) {
                MostrarNodo(aux);
                cont++;
            }
            aux = aux.siguiente;
            if (cont == 0) {
                System.out.println("No se encontraron coincidencias");
            }
        }
    }

    public static void MostrarNodo(cNodo nodo) {
        System.out.print(" Nombre: " + nodo.contacto.nombre);
        System.out.print(" Número: " + nodo.contacto.num);
        System.out.print(" Correo: " + nodo.contacto.correo);
        System.out.println();
        
    }
}
