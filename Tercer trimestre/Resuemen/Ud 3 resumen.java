import java.util.*;

public class main {
    public static void main(String[] args) {
        // LinkedList: Una implementación de lista doblemente enlazada de las interfaces List y Deque.
        // Permite inserciones o eliminaciones en tiempo constante usando iteradores.
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Elemento 1");
        linkedList.add("Elemento 2");
        System.out.println("LinkedList: " + linkedList);
        linkedList.remove("Elemento 1");
        System.out.println("LinkedList después de la eliminación: " + linkedList);

        // ArrayList: Una implementación de array redimensionable de la interfaz List.
        // Proporciona acceso aleatorio rápido y es mejor para almacenar y acceder a datos.
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println("ArrayList: " + arrayList);
        arrayList.remove(Integer.valueOf(1));
        System.out.println("ArrayList después de la eliminación: " + arrayList);

        // HashSet: Una colección que utiliza una tabla hash para el almacenamiento.
        // No permite elementos duplicados y proporciona rendimiento en tiempo constante para operaciones básicas.
        HashSet<Double> hashSet = new HashSet<>();
        hashSet.add(1.1);
        hashSet.add(2.2);
        System.out.println("HashSet: " + hashSet);
        hashSet.remove(1.1);
        System.out.println("HashSet después de la eliminación: " + hashSet);

        // HashMap: Una implementación de tabla hash de la interfaz Map.
        // Permite valores nulos y la clave nula, y proporciona rendimiento en tiempo constante para operaciones básicas.
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Uno");
        hashMap.put(2, "Dos");
        System.out.println("HashMap: " + hashMap);
        hashMap.remove(1);
        System.out.println("HashMap después de la eliminación: " + hashMap);
    }
}
