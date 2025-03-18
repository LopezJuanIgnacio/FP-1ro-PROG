package examen2trim;

import java.util.*;

public class GestionGranja {

	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Establo> establos = new ArrayList();

	public static class Establo {
		private String nombre;
		private ArrayList<Vaca> vacas;

		public Establo(String nombre) {
			this.nombre = nombre;
			this.vacas = new ArrayList();
		}

		public String getNombre() {
			return nombre;
		}

		public void marcarCurar(boolean enfermas) {
			for (Vaca v : this.vacas)
				v.setMarcaEnferma(enfermas);
		}

		public void agregarVaca() {
			String nom;
			int meses;
			System.out.println("Nombre de la vaca: ");
			nom = sc.nextLine();

			System.out.println("Meses de vida de la vaca: ");
			meses = sc.nextInt();
			sc.nextLine();

			this.vacas.add(new Vaca(nom, meses));
			System.out.println("Vaca agregada correctamente.");
		}

		public void infVacas() {
			double avgEdad = 0, cant = (double) this.vacas.size();
			if (cant == 0) {
				System.out.println("No hay vacas");
				return;
			}
			for (Vaca v : this.vacas)
				avgEdad += (double) v.getMesesVida();

			System.out.println(
					"Establo " + this.nombre + ": " + cant + " vacas, edad promedio: " + (avgEdad / cant) + " meses");

		}

		public boolean buscarVaca(String nom) {
			for (Vaca v : this.vacas)
				if (v.getNombre().equalsIgnoreCase(nom)) {
					v.presentarse(this.nombre);
					return true;
				}
			return false;
		}

	}

	public static class Vaca {
		private String nombre;
		private int mesesVida;
		private boolean marcaEnferma;

		public Vaca(String nombre, int mesesVida) {
			this.nombre = nombre;
			this.mesesVida = mesesVida;
			this.marcaEnferma = false;
		}

		public void presentarse(String est) {
			System.out.println("Encontrada en '" + est + "' Vaca " + this.nombre + " con " + this.mesesVida + " meses y"
					+ (this.marcaEnferma ? "" : " no") + " está enferma");
		}

		public void setMarcaEnferma(boolean marcaEnferma) {
			this.marcaEnferma = marcaEnferma;
		}

		public int getMesesVida() {
			return mesesVida;
		}

		public String getNombre() {
			return nombre;
		}
	}

	public static void main(String[] args) {
		int opt, ind;

		do {
			opt = menu();

			switch (opt) {
				case 1:
					crearEstablo();
					break;
				case 2, 3, 4, 6:
					ind = buscarEstablo();
					if (ind == -1)
						break;

					switch (opt) {
						case 2:
							establos.get(ind).agregarVaca();
							break;
						case 3:
							establos.get(ind).marcarCurar(true);
							break;

						case 4:
							establos.get(ind).marcarCurar(false);
							break;

						case 6:
							establos.get(ind).infVacas();
							break;
						default:
							break;
					}
					break;
				case 5:
					buscarVaca();
					break;

				default:
					break;
			}
		} while (opt != 7);
	}

	public static int menu() {
		int opt;
		System.out.println("Menú de Gestión de la Granja\r\n"
				+ "1. Crear un nuevo establo\r\n"
				+ "2. Agregar una vaca\r\n"
				+ "3. Marcar todas las vacas de un establo como enfermas\r\n"
				+ "4. Curar todas las vacas de un establo\r\n"
				+ "5. Buscar vaca\r\n"
				+ "6. Mostrar número de vacas y edad media de un establo\r\n"
				+ "7. Salir\r\n"
				+ "Seleccione una opción:");
		opt = sc.nextInt();
		sc.nextLine();
		return opt;
	}

	public static int buscarEstablo() {
		int ind = -1;
		String nom;
		System.out.println("Nombre del establo: ");
		nom = sc.nextLine();

		for (int i = 0; i < establos.size(); i++)
			if (establos.get(i).getNombre().equalsIgnoreCase(nom))
				return i;

		System.out.println("El establo no existe.");
		return ind;
	}

	public static void crearEstablo() {
		String nom;
		System.out.println("Nombre del establo: ");
		nom = sc.nextLine();
		establos.add(new Establo(nom));
		System.out.println("Establo agregado correctamente.");
	}

	public static void buscarVaca() {
		String nom;
		System.out.println("Nombre de la vaca: ");
		nom = sc.nextLine();

		for (Establo e : establos)
			if (e.buscarVaca(nom))
				return;
		System.out.println("No se encontró una vaca con ese nombre.");
	}
}
