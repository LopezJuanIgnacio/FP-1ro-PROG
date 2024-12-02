package paquete;
import java.util.*;

public class main {
	public static void main(String[] args) {
		Ej16();
	}
	public static void Ej11(){
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		int[] inverso = new int[array.length];
		for(int i = 0; i < array.length; i++){
			inverso[i] = array[array.length - 1 - i];
		}
		for(int i = 0; i < inverso.length; i++){
			System.out.print(inverso[i] + " ");
		}
	} 
	public static void Ej13(){
		int n, v, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el tamaño del array: ");
		n = sc.nextInt();
		int[] array = new int[n];
		System.out.println("Introduce el valor inicial: ");
		v = sc.nextInt();
		System.out.println("Introduce el incremento: ");
		i = sc.nextInt();
		for(int j = 0; j < array.length; j++){
			array[j] = v + i *j;
			System.out.print(array[j] + " ");
		}
	}
	public static void Ej16(){
		int num = 0;
		for(int i = 1; i <=10; i++){
			num += i;
		}
		int index = 0;
		int[] arr = new int[num];
		for(int i = 1; i <=10; i++){
			Arrays.fill(arr, index, index + i, i);
			index += i;
		}
		for(int i = 0; i < arr.length; i++)System.out.print(arr[i] + " ");
	}
	public static void Ej20() {
    int[] arr = new int[1000];
    Arrays.setAll(arr, i -> (int)(Math.random() * 100));
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce un valor: ");
    int n = sc.nextInt();
    
    long count = Arrays.stream(arr).filter(value -> value == n).count();
    
    System.out.println("El valor " + n + " se repite " + count + " veces");
}

}
