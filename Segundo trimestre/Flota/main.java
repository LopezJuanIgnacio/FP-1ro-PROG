package paquete;
import java.util.Arrays;
import java.util.Scanner;


public class main {
	public static void main(String[] args) {
		char[][] grilla = new char[10][10];

		int x, y;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < grilla.length; i++) {
            Arrays.fill(grilla[i], '*');
        }
		
		grilla = rellenarGrilla(grilla);
		do {
			System.out.print("\033[H\033[2J");  
    		System.out.flush();
			mostrarGrilla(grilla);
			System.out.println("Escribe la coordenada x: ");
			x = sc.nextInt();
			System.out.println("Escribe la coordenada y: ");
			y = sc.nextInt();
			if ((y <= 9 && y >= 0) && (x <= 9 && x >= 0))
				grilla[y][x] = ((grilla[y][x] == '*' || grilla[y][x] == 'X' ) ? 'X' : '0');
		} while (termino(grilla) == false);
		System.out.print("Victoria");
	}

	public static void mostrarGrilla(char[][] grilla) {
		for (int i = 0; i < grilla.length; i++) {
			for (int j = 0; j < grilla[i].length; j++) {
				System.out.print(((grilla[i][j] != 'X' && grilla[i][j] != '0' ) ? '*' : grilla[i][j]) + " ");
			}
			System.out.println();
		}
	}

	public static char[][] rellenarGrilla(char[][] grilla) {
		int[] barcos = { 5, 4, 3, 3, 2, };
		for (int i = 0; i < barcos.length; i++) {
			grilla = ponerBarco(grilla, barcos[i]);
		}
		return grilla;
	}

	public static char[][] ponerBarco(char[][] grilla, int x) {
        int i, j;
        char orien;

        i = (int) (Math.random() * 10);
        j = (int) (Math.random() * 10);
        orien = ((int) (Math.random() * 2) == 0) ? 'V' : 'H';

        if (esPosible(orien, i, j, x)) {
            if (orien == 'V') {
                for (int k = 0; k < x; k++) {
                    grilla[i][j + k] = (char) (48 + x);
                }
            } else {
                for (int k = 0; k < x; k++) {
                    grilla[i + k][j] = (char) (48 + x);
                }
            }
        } else
            ponerBarco(grilla, x);
        return grilla;
    }

	public static boolean esPosible(char orien, int i, int j, int x) {
		if (orien == 'V') {
			if ((j + x) > 10)
				return false;
			else
				return true;
		} else {
			if ((i + x) > 10)
				return false;
			else
				return true;
		}
	}

	public static boolean termino(char[][] grilla) {
		for (int i = 0; i < grilla.length; i++) {
			for (int j = 0; j < grilla[i].length; j++) {
				if (grilla[i][j] != '*' && grilla[i][j] != 'X' && grilla[i][j] != '0') {
					return false;
				}
			}
		}
		return true;
	}
}
