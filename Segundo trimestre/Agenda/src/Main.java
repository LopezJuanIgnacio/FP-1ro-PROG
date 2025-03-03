import java.util.*;
public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static class Nota{
		private String txt;

		public Nota(String txt) {
			this.txt = txt;
		}

		public String getTxt() {
			return txt;
		}
	}
	public static class Pagina{
		private ArrayList<Nota> notas;

		public Pagina() {
			this.notas = new ArrayList();
		}

		public ArrayList<Nota> getNotas() {
			return notas;
		}

		public void agregarNota(Nota n) {
			this.notas.add(n);
		}
	}
	public static class Agenda{
		private Pagina[] pags;

		public Agenda() {
			this.pags = new Pagina[300];
		}

		public Pagina[] getPags() {
			return pags;
		}

		public void buscar(String txt) {
			for(int i = 0; i < this.pags.length; i++) {
				if(this.pags[i] == null) continue;
				for(Nota n : this.pags[i].getNotas()) {
					if(n.txt.equalsIgnoreCase(txt)) {
						System.out.println("La nota que contiene '" + txt + "' se encuentra en la pagina " + i);
						return;
					}
				}
			}
			System.out.println("No se encontro");
		}
	}
	
	public static Agenda age = new Agenda();
	
	public static void main(String[] args) {
		int opt;

		do {
			opt = menu();

			switch (opt) {
			case 1:
				agregar();
				break;
			case 2:
				buscar();
				break;
			case 3:
				mostrar();
				break;

			default:
				break;
			}

		}while(opt != 4);
	}
	
	public static int menu() {
		int opt;
		
		System.out.print("Menú:\r\n"
				+ "1. Agregar Nota\r\n"
				+ "2. Buscar Nota\r\n"
				+ "3. Mostrar Notas de una Página\r\n"
				+ "4. Salir\r\n"
				+ "Seleccione una opción:");
		
		opt = sc.nextInt();
		sc.nextLine();
		
		return opt;
	}
	public static void agregar() {
		int nro;
		String txt;
		
		System.out.print("Ingrese el número de página (1-300): ");
		nro = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Ingrese el texto de la nota: ");
		txt = sc.nextLine();
		
		if(age.getPags()[nro] == null) age.getPags()[nro] = new Pagina();
		
		age.getPags()[nro].agregarNota(new Nota(txt));
		
		System.out.println("Nota agregada en la pagina " + nro);
	}
	
	public static void buscar() {
		String txt;
		
		System.out.print("Ingrese el texto de la nota: ");
		txt = sc.nextLine();
		
		age.buscar(txt);
	}
	
	public static void mostrar() {
		int nro;
		
		System.out.print("Ingrese el número de página (1-300): ");
		nro = sc.nextInt();
		sc.nextLine();
		
		if(age.getPags()[nro] == null) {
			System.out.println("(Sin notas)");
			return;
		}

		for(Nota n : age.getPags()[nro].getNotas()) {
			System.out.println(n.getTxt());
		}
	}
}
