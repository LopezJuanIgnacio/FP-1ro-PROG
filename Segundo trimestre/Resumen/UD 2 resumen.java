import java.lang.reflect.Array;
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


        // LinkedList: Una implementación de lista doblemente enlazada de las interfaces List y Deque.
        // Permite inserciones o eliminaciones en tiempo constante usando iteradores.
        // LinkedList<String> linkedList = new LinkedList<>();
        // linkedList.add("Elemento 1");
        // linkedList.add("Elemento 2");
        // System.out.println("LinkedList: " + linkedList);
        // linkedList.remove("Elemento 1");
        // System.out.println("LinkedList después de la eliminación: " + linkedList);

        // ArrayList: Una implementación de array redimensionable de la interfaz List.
        // Proporciona acceso aleatorio rápido y es mejor para almacenar y acceder a datos.
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println("ArrayList: " + arrayList);
        arrayList.remove(Integer.valueOf(1));
        arrayList.set(0, 3);
        arrayList.indexOf(3); //0
        arrayList.size(); //1
        System.out.println("ArrayList después de la eliminación: " + arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for(Integer i : arrayList){
            System.out.println(i);
        }

        // HashSet: Una colección que utiliza una tabla hash para el almacenamiento.
        // No permite elementos duplicados y proporciona rendimiento en tiempo constante para operaciones básicas.
        // HashSet<Double> hashSet = new HashSet<>();
        // hashSet.add(1.1);
        // hashSet.add(2.2);
        // System.out.println("HashSet: " + hashSet);
        // hashSet.remove(1.1);
        // System.out.println("HashSet después de la eliminación: " + hashSet);

        // HashMap: Una implementación de tabla hash de la interfaz Map.
        // Permite valores nulos y la clave nula, y proporciona rendimiento en tiempo constante para operaciones básicas.
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Uno");
        hashMap.put(2, "Dos");
        System.out.println("HashMap: " + hashMap);
        hashMap.put(1, "Uno actualizado");
        hashMap.get(1); //Uno actualizado
        hashMap.size(); //2
        hashMap.containsKey(1); //true
        hashMap.containsValue("Uno actualizado"); //true
        hashMap.remove(1);
        System.out.println("HashMap después de la eliminación: " + hashMap);
        for(Integer key : hashMap.keySet()){
            System.out.println("Clave: " + key + ", Valor: " + hashMap.get(key));
        }

        //Queue: Una colección de elementos que admite la inserción y extracción de elementos en el orden en que se agregaron.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println("Queue: " + queue);
        queue.remove();
        System.out.println("Queue después de la eliminación: " + queue); //2
        
        //Stack: Una colección de elementos que admite la inserción y extracción de elementos en el orden en que se agregaron.
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack: " + stack);
        stack.pop();
        System.out.println("Stack después de la eliminación: " + stack); //1
        stack.peek(); //1
        stack.search(1); //1


        //Collections
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(3);
        numeros.add(1);
        numeros.add(2);
        System.out.println("Lista de números: " + numeros);
        Collections.sort(numeros);
        System.out.println("Lista de números ordenada: " + numeros);
        Collections.reverse(numeros);
        System.out.println("Lista de números invertida: " + numeros);
        Collections.shuffle(numeros);
        System.out.println("Lista de números mezclada: " + numeros);
        Collections.swap(numeros, 0, 1);
        System.out.println("Lista de números intercambiada: " + numeros);
        Collections.fill(numeros, 0);
        System.out.println("Lista de números rellenada: " + numeros);
        Collections.replaceAll(numeros, 0, 1);
        System.out.println("Lista de números reemplazada: " + numeros);
        Collections.rotate(numeros, 1);
        System.out.println("Lista de números rotada: " + numeros);
        Collections.min(numeros); //1
        Collections.max(numeros); //3
        Collections.frequency(numeros, 1); //1
        Collections.copy(numeros, numeros);
        System.out.println("Lista de números copiada: " + numeros);
        


    }
}