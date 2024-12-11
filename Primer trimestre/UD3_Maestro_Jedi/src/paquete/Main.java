package paquete;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		potter();
	}

	public static void potter() {
        Combatiente potter = new Combatiente("Potter", 15, 5);
        Combatiente morti = new Combatiente("Mortifago", 10, 10);
		System.out.println("COMIENZA LA PELEA ENTRE JAVA POTTER Y EL MORTÍFAGO!");
		while(morti.getVida() > 0 && potter.getVida() > 0) {
			morti.RecibirAtaque(potter.Atacar());
            potter.RecibirAtaque(morti.Atacar());
		} ;
        if(morti.getVida() <= 0) {
            System.out.println("PERDIO EL MORTÍFAGO!");
        }
        if(potter.getVida() <= 0) {
            System.out.println("PERDIO POTTER!");
        }
		System.out.println("TERMINO LA PELEA!");
	}
	public static void Ej12() {
		boolean aux = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número entero: ");
		int num = sc.nextInt();
		if(num <= 0) return;
		for (int i = 1; i <= num; i++) {
			for (int j = 2; j < i; j++) {
				//System.out.println(i + " % " + j + " = " + i % j);
				if(i % j == 0) {
					aux = true;
					break;
				}
			}
			if(!aux)System.out.println(i);
			aux = false;
		}
	}
	public static void Ej11() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número entero: ");
		int num = sc.nextInt();
		if(num < 3) return;
		for (int i = 1; i <= num; i++) {
			if(i == 1 || i == num) {
				for (int j = 1; j <= num; j++) {
					System.out.print("*");
				}
			}
			else {
				System.out.print("*");
				for (int j = 1; j <= num - 2; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void Ej10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número entero: ");
		int num = sc.nextInt();
		if(num <= 0) return;
		int espacios = num - 1;
		int asteriscos = 1;
		for (int f = 1; f <= num; f++) {
			for (int i = 1; i <= espacios; i++) {
				System.out.print(" ");
			}
			for (int i = 1; i <= asteriscos; i++) {
				System.out.print("*");
			}
			System.out.println("");
			espacios--; 
			asteriscos += 2; 
		}
	}
	public static void Ej7(){
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++) {
				for (int k = 0; k < 60; k++) {
					System.out.println(i + ":" + j + ":" + k);
				}
			}
		}
	}

}
