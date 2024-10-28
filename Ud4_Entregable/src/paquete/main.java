package paquete;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		int opcion = 1;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("1. Longitud de la cadena");
			System.out.println("2. Comparacion de dos cadenas");
			System.out.println("3. Concatenacion de dos cadenas");
			System.out.println("4. Obtener subcadenas");
			System.out.println("5. Invertir cadenas");
			System.out.println("6. Es palindromo");
			System.out.println("9. Salir");

			System.out.println("Introduce una opcion: ");
			opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion){
			case 1:
				LongCadena();
				break;
			case 2:
				CompararCadenas();
				break;
			case 3:
				ConcatenarCadenas();
				break;
			case 4:
				SubCadenas();
				break;
			case 5:
				InvertirCadenas();
				break;
			case 6:
				EsPalindromo();
				break;
			case 9:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}while(opcion != 9);
	}

	public static void LongCadena(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena = sc.nextLine();
		System.out.println("La longitud de la cadena es: " + cadena.length());
		sc.nextLine();
	}

	public static void CompararCadenas(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena1 = sc.nextLine();
		System.out.println("Introduce otra cadena: ");
		String cadena2 = sc.nextLine();
        int res = cadena1.compareTo(cadena2);
		if(res == 0){
			System.out.println("Las cadenas son iguales");
		}else if(res < 0){
			System.out.println("La primera cadena es menor que la segunda");
		}else{
            System.out.println("La primera cadena es mayor que la segunda");
        }
		sc.nextLine();
	}

	public static void ConcatenarCadenas(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena1 = sc.nextLine();
		System.out.println("Introduce otra cadena: ");
		String cadena2 = sc.nextLine();
		System.out.println("La concatenacion de las cadenas es: " + cadena1 + cadena2);
		sc.nextLine();
	}

	public static void SubCadenas(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena = sc.nextLine();
		System.out.println("Introduce el inicio de la subcadena: ");
		int inicio = sc.nextInt();
		System.out.println("Introduce el fin de la subcadena: ");
		int fin = sc.nextInt();
		System.out.println("La subcadena es: " + cadena.substring(inicio, fin));
		sc.nextLine();
	}

	public static void InvertirCadenas(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena = sc.nextLine();
		String invertida = "";
		for(int i = cadena.length() - 1; i >= 0; i--){
			invertida += cadena.charAt(i);
		}
		System.out.println("La cadena invertida es: " + invertida);
		sc.nextLine();
	}

	public static void EsPalindromo(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena: ");
		String cadena = sc.nextLine();
		String invertida = "";
		for(int i = cadena.length() - 1; i >= 0; i--){
			invertida += cadena.charAt(i);
		}
		if(cadena.equals(invertida)){
			System.out.println("La cadena es palindromo");
		}else{
			System.out.println("La cadena no es palindromo");
		}
		sc.nextLine();
	}

}
