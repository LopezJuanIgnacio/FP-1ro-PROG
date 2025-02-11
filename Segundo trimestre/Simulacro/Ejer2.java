package simulacro;
import java.util.*;

public class Ejer2 {
	
	public static void main(String[] args) {
		//Declaramos variables iniciales
		int n = pedirNumero("Tamaño de la matriz:");
		int[][] matriz = new int[n][n];
		int x = pedirNumero("Incremento de la matriz:");
		//En esta variable vamos a guardar el numero a poner en cada casilla de la matriz, obviamente, empieza en 1
		int acumulador = 1;
		
		//El primer
		//Rellenamos la matriz
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				//Le damos el valor del acumulador
				matriz[j][i] = acumulador;
				//Aumentamos el acumulador
				acumulador += x;
			}
		}
		
		
		//Mostramos la matriz
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	//Hacemos que le llegue el texto para pedir
	public static int pedirNumero(String txt) {
		int i;
		//Declaramos el scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.println(txt);
		i = sc.nextInt();
		return i;
	}

}
