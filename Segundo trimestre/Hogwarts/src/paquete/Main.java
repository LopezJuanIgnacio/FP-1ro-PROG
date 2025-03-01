package paquete;
import java.util.*;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static class Estudiante{
		private String DNI;
		private String Nombre;
		private int edad;

		public Estudiante(String DNI, String Nombre, int edad) {
			this.DNI = DNI;
			this.Nombre = Nombre;
			this.edad = edad;
		}
		
		public String getDNI() {
			return DNI;
		}
		
		public void presentarse() {
			System.out.println("-Alumno de NIF: " + this.DNI + " y nombre: " + this.Nombre + " tiene "+ this.edad + " años.");
		}
	}

	public static class Libro{
		private String Titulo;
		private String Autor;
		private int numPaginas;
		private String estado;

		public Libro(String Titulo, String Autor, int numPaginas) {
			this.Titulo = Titulo;
			this.Autor = Autor;
			this.numPaginas = numPaginas;
			this.estado = "DISP";
		}	
		
		public String getTitulo() {
			return Titulo;
		}
		
		public String getEstado() {
			return estado;
		}
		
		public void setEstado() {
			this.estado = (this.estado.equals("DISP") ? "PREST" : "DISP");
		}
		
		public void presentarse() {
			System.out.println("-" +  this.Titulo + " escrito por: " +  this.Autor + " tiene "+  this.numPaginas + " pags. | " + this.estado);
		}
	}

	private  static class Prestamo{
		private Libro lib;
		private Estudiante est;

		public Prestamo(Libro lib, Estudiante est) {
			this.lib = lib;
			this.est = est;
		}
		
		public void presentarse() {
			this.est.presentarse();
			this.lib.presentarse();
		}

	}

	public static ArrayList<Estudiante> estudiantes = new ArrayList();
	public static ArrayList<Libro> libros = new ArrayList();
	public static ArrayList<Prestamo> prestamos = new ArrayList();

	public static void main(String[] args) {
		int opt;

		do {
			opt = menu();

			switch (opt) {
			case 1:
				altaLibro();
				break;
			case 2:
				altaAlumno();
				break;
			case 3:
				prestarLibro();
				break;
			case 4:
				devolverLibro();
				break;
			case 5:
				resumen();
				break;

			default:
				break;
			}
		}while(opt != 9);
	}

	public static int menu() {
		int opt;
		System.out.println("Bienvenido a la biblioteca de Hogwarts\r\n"
				+ "1-Dar de alta un libro\r\n"
				+ "2-Dar de alta un alumno\r\n"
				+ "3-Prestar un libro\r\n"
				+ "4-Devolver un libro\r\n"
				+ "5-Resumen de la biblioteca\r\n"
				+ "9-Salir");
		opt = sc.nextInt();
		sc.nextLine();
		return opt;
	}

	public static void altaLibro() {
		String titulo, autor;
		int numPaginas;
		
		System.out.println("Introduzca titulo del libro numero " + (libros.size() +1) + ":");
		titulo = sc.nextLine();
		
		System.out.println("Introduzca su autor:");
		autor = sc.nextLine();
		
		System.out.println("Introduzca numero de paginas:");
		numPaginas = sc.nextInt();
		sc.nextLine();
		
		libros.add(new Libro(titulo, autor, numPaginas));
		System.out.println("Se ha dado de alta el siguiente ejemplar:");
		libros.getLast().presentarse();
	}
	public static void altaAlumno() {
		String DNI, Nombre;
		int edad;
		
		System.out.println("Introduzca DNI del alumno numero " + (estudiantes.size() +1) + ":");
		DNI = sc.nextLine();
		
		System.out.println("Introduzca su nombre:");
		Nombre = sc.nextLine();
		
		System.out.println("Introduzca su edad:");
		edad = sc.nextInt();
		sc.nextLine();
		
		estudiantes.add(new Estudiante(DNI, Nombre, edad));
		System.out.println("Se ha dado de alta al siguiente alumno:");
		estudiantes.getLast().presentarse();
	}
	public static void prestarLibro() {
		int indLibro = -1, indEst = -1;
		String nomLibro, dniEst;
		
		System.out.println("Introduzca DNI del alumno:");
		dniEst = sc.nextLine();
		
		for(int i = 0; i < estudiantes.size(); i++) {
			if(dniEst.equalsIgnoreCase(estudiantes.get(i).getDNI())) {
				indEst = i;
				break;
			}
		}
		if(indEst == -1) {
			System.out.println("No existe");
			return;
		}
		
		System.out.println("Introduzca titulo del libro:");
		nomLibro = sc.nextLine();
		
		for(int i = 0; i < libros.size(); i++) {
			if(nomLibro.equalsIgnoreCase(libros.get(i).getTitulo())) {
				if(libros.get(i).getEstado().equals("PREST")) {
					System.out.println("Ya esta ocupado");
					return;
				}
				indLibro = i;
				libros.get(i).setEstado();
				break;
			}
		}
		if(indLibro == -1) {
			System.out.println("No existe");
			return;
		}
		
		prestamos.add(new Prestamo(libros.get(indLibro),estudiantes.get(indEst)));
	}
	public static void devolverLibro() {
		int indPrestamo = -1;
		String nom;
		
		System.out.println("Introduzca titulo del libro a devolver:");
		nom = sc.nextLine();
		
		for(int i = 0; i < prestamos.size(); i++) {
			if(nom.equalsIgnoreCase(prestamos.get(i).lib.getTitulo())) {
				indPrestamo = i;
				prestamos.get(i).lib.setEstado();
				break;
			}
		}
		if(indPrestamo == -1) {
			System.out.println("No existe");
			return;
		}
		prestamos.remove(indPrestamo);
	}
	public static void resumen() {
		System.out.println("+Clientes dados de alta:");
		for(Estudiante e : estudiantes) {
			e.presentarse();	
		}
		System.out.println("+Libros dados de alta::");
		for(Libro e : libros) {
			e.presentarse();	
		}
		System.out.println("+Prestamos efectuados:");
		for(Prestamo e : prestamos) {
			e.presentarse();	
		}

	}

}
