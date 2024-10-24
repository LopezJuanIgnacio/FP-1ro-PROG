package main;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		String s1 = "Cazar armadillos";
		System.out.println(s1.replaceAll("ar","er")); // Da Cazer ermedillos
		System.out.println(s1); // Sigue valiendo Cazar armadilos
	}

	public static void Ej12(){
		String cadena, cadenaInvertida = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena de texto: ");
		cadena = sc.nextLine();
		cadena = cadena.toLowerCase();
		cadena = cadena.replaceAll(" ", "");
		//cadenaInvertida = new StringBuilder(cadena).reverse().toString();
		for(int i = cadena.length() - 1; i >= 0; i--) {
			cadenaInvertida += cadena.charAt(i);
		}
		System.out.println("Cadena invertida: " + cadenaInvertida);
		if(cadena.equals(cadenaInvertida)) {
			System.out.println("La cadena es palíndroma.");
		} else {
			System.out.println("La cadena no es palíndroma.");
		}
	}

	public static void Ej11(){
		String cadena;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena de texto: ");
		cadena = sc.nextLine();
		cadena = cadena.replaceAll(" ", "\n");
		System.out.println(cadena);
	}

	public static void Ej9(){
		String F, P;
		int num = 0, res = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		F = sc.nextLine();
		System.out.println("Introduce una palabra: ");
		P = sc.nextLine();
		do {
			res = F.indexOf(P, res);
			if(res != -1) {
				num++;
				res++;
			}
		} while(res != -1);
		System.out.println("La palabra " + P + " aparece " + num + " veces en la frase.");
	}

	public static void Ej5(){
		String cadena;
		int[] vocales = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena de texto: ");
		cadena = sc.nextLine();
		cadena = cadena.toLowerCase();
		for(int i = 0; i < cadena.length(); i++) {
			switch(cadena.charAt(i)) {
			case 'a':
				vocales[0]++;
				break;
			case 'e':
				vocales[1]++;
				break;
			case 'i':
				vocales[2]++;
				break;
			case 'o':
				vocales[3]++;
				break;
			case 'u':
				vocales[4]++;
				break;
			}
		}

		for (int i = 0; i < vocales.length; i++) {
			System.out.println("Vocal "  + vocales[i]);
		}
	}
}
