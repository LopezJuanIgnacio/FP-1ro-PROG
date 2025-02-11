package simulacro;
import java.util.*;

public class Ejer3 {

	public static void main(String[] args) {
		//Declaramos variables iniciales
		LineaTicket[] productos = new LineaTicket[100];
		int contadorProd = 0;
		int opt;
		double total = 0;
		double totalSinIva = 0;
		Scanner sc = new Scanner(System.in);

		//Mensajes iniciales del sistema
		System.out.println("TICKET ULTRAMARINOS FERRAN");
		System.out.println("1. AÃ±adir producto IVA normal (21%)");
		System.out.println("2. AÃ±adir producto IVA especial");
		System.out.println("3. Imprimir ticket y finalizar");

		do {
			System.out.print("Elige una opciÃ³n: ");
			opt = sc.nextInt();

			//Dependiendo de la opcion, mandamos true o false como aprametro
			//Esto es para que dentro de la funcion sepa si pedir o no el iva y no repetir codigo

			switch (opt) {
			case 1: {
				productos[contadorProd] = AniadirProd(false);
				break;
			}
			case 2: {
				productos[contadorProd] = AniadirProd(true);
				break;
			}
			}
			//No se puede meter dentro del switch ya que la instruccion break actuaria sobre el switch, no el bucle
			if(opt == 3) break;

			//La funcion nos devuelve el producto, que guardamos en una variable auxiliar
			//Y despues lo guardamos en el array y aumentamos el contador
			contadorProd++;
		}while(true);
		System.out.println();
		System.out.println("--- TICKET ULTRAMARINOS FERRAN ---");

		//Recorremos y mostramos los productos
		for(int i = 0; i < contadorProd; i++) {
			System.out.print(productos[i].getNombre() + "\t");
			System.out.printf("Precio sin IVA: %6.2f â¬", productos[i].getPrecio()); 
			System.out.printf(" - Precio con IVA: %6.2f â¬ \n",
					//Calculamos el precio con IVA
					(productos[i].getPrecio() + 
							( ( ( (double) productos[i].getPrecio() ) * productos[i].getIva()) / 100 ) ));
			totalSinIva += productos[i].getPrecio();
			total += productos[i].getPrecio() + 
					( ( ( (double) productos[i].getPrecio() ) * productos[i].getIva()) / 100 );
		}

		//Totales
		System.out.println();
		System.out.printf("TOTAL SIN IVA: %6.2f â¬ \n", totalSinIva );
		System.out.printf("TOTAL CON IVA: %6.2f â¬ \n", total);
		
		System.out.println();
		System.out.println("--- GRACIAS POR SU COMPRA ---");

	}

	public static LineaTicket AniadirProd(boolean ivaEsp) {
		//Declaramos el scanner y las variables donde vamos a
		Scanner sc = new Scanner(System.in);
		String nom;
		double precio;
		int iva;
		LineaTicket prod;

		//Pedimos y recibimos los atributos
		System.out.print("Introduce el nombre del producto: ");
		nom = sc.nextLine();

		System.out.print("Introduce el precio sin IVA: ");
		precio = sc.nextDouble();

		//Si va a tener iva especial, lo pedimos y se lo pasamos, sino lo creamos sin pasarselo
		if(ivaEsp) {
			System.out.print("Introduce el porcentaje de IVA especial: ");
			iva = sc.nextInt();
			prod = new LineaTicket(nom, precio, iva);
		}else prod = new LineaTicket(nom, precio);

		return prod;

	}

	public static class LineaTicket {
		//Declaramos atributos
		private String nombre;
		private double precio;
		private int iva;

		//Constructor
		public LineaTicket(String nom, double pre) {
			this.nombre = nom;
			this.precio = pre;
			this.iva = 21;
		}

		//Constructor sobreescrito para permitir iva especial
		public LineaTicket(String nom, double pre, int ivaEspecial) {
			this.nombre = nom;
			this.precio = pre;
			this.iva = ivaEspecial;
		}
		
		//getters
		public String getNombre() {
			return this.nombre;
		}
		
		public int getIva() {
			return iva;
		}
		
		public double getPrecio() {
			return precio;
		}

	}
}
