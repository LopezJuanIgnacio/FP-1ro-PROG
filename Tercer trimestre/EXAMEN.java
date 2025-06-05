package eval3;

import java.io.File;
import java.io.FileWriter;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionAgenda {
	//Debido a que no se instancia un objeto que sea Contacto, sino que solo sirve para que otras clases hereden de ella, se crea como una clase ABSTRACTA
	abstract static class Contacto {
		protected String nombre;
		protected int telefono;

		public Contacto(String nombre,int telefono){
			this.nombre = nombre;
			this.telefono = telefono;
		}

		public String getNombre() {
			return nombre;
		}
		public int getTelefono() {
			return telefono;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}
		
		//Metodos abstractos que seran sobreescritos por sus clases hijas para que cada una le de una funcionalidad unica
		abstract public void mostrarInfo();
		//Ya que para escribir en el fichero en el apartado 8 tanto los contactos personales como personales tienen que pasar
		//un string con sus datos pero estos datos no son los mismos, escribo un metodo abstracto en contacto y en sus clases hijas lo desarrollo
		abstract public String InfoParaFichero();
	}
	
	//extends significa que hereda de otra clase
	public static class ContactoPersonal extends Contacto{
		private String cumple;

		public ContactoPersonal(String nombre,int telefono, String cumple){
			super(nombre,telefono); //super utiliza el constructor de la clase padre para asi heredar sus atributos
			this.cumple = cumple;
		}

		public String getCumple() {
			return cumple;
		}
		public void setCumple(String cumple) {
			this.cumple = cumple;
		}
		
		//Sobreescribimos los metodos abstractos de la clase padre
		@Override
		public void mostrarInfo() {
			System.out.println("***Contacto Personal***");
			System.out.println("Nombre: " + getNombre());
			System.out.println("Telefono: " + getTelefono());
			System.out.println("Cumpleaños: " + getCumple());
		};
		
		@Override
		public String InfoParaFichero() {
			return this.getClass().getTypeName() + " " + getNombre() + " " + getTelefono() + " " + getCumple() + " \n";
		}
	}
	public static class ContactoProfesional extends Contacto{
		private String empresa;
		private String email;

		public ContactoProfesional(String nombre,int telefono,String email, String empresa) {
			super(nombre,telefono);
			this.email = email;
			this.empresa = empresa;
		}

		public String getEmail() {
			return email;
		}
		public String getEmpresa() {
			return empresa;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}
		@Override
		public void mostrarInfo() {
			System.out.println("***Contacto Profesional***");
			System.out.println("Nombre: " + getNombre());
			System.out.println("Telefono: " + getTelefono());
			System.out.println("Email: " + getEmail());
			System.out.println("Empresa: " + getEmpresa());
		};
		@Override
		public String InfoParaFichero() {
			return this.getClass().getTypeName() + " " + getNombre() + " " + getTelefono() + " " + getEmail() + " " + getEmpresa() + " \n";
		}

	}

	public static Scanner sc = new Scanner(System.in); //Scanner
	public static ArrayList<Contacto> contactos = new ArrayList(); //Lista de contactos

	public static void main(String[] args) {
		int opc = 0;

		do {

			try {
				opc = menu();

				switch (opc) {
				case 1:
					Alta("Personal");
					break;
				case 2:
					Alta("Profesional");
					break;
				case 3:
					Listar("ContactoPersonal");
					break;
				case 4:
					Listar("ContactoProfesional");
					break;
				case 5:
					Listar("");
					break;
				case 6:
					buscarXNom();
					break;
				case 7:
					cargarDatos();
					break;
				case 8:
					guardarDatos();
					break;
				case 9:
					System.out.println("Adios");
					break;

				default:
					System.out.println("Opcion invalida");
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage()); 
				//Cada vez que uno de los metodos tire una Excepcion sera recibida aqui para ser manejada correctamente
			}
		}while(opc != 9);

	}
	
	//Menu
	//Nos puede tirar una excepcion si el usuario no escribe un numero cuando se lo pide
	//Aunque no haya un try-catch en la funcion, se especifica que la funcion tira excepciones con la palabra throws
	//Asique esa excepcion sera recibida donde se llame a esta funcion, en nuestro caso seria main el cual si tiene un
	//Try-catch para recibir la excepcion y manejarla
	public static int menu() throws InputMismatchException {
		int opc = 0;

		System.out.println("1. Alta Contacto Personal");
		System.out.println("2. Alta Contacto Profesional");
		System.out.println("3. Listar solo Contactos Personales");
		System.out.println("4. Listar solo Contactos Profesionales");
		System.out.println("5. Listar todos los Contactos");
		System.out.println("6. Buscar por nombre");
		System.out.println("7. Cargar datos de disco duro");
		System.out.println("8. Guardar datos en disco duro");
		System.out.println("9. Salir");
		opc = sc.nextInt();
		sc.nextLine();

		return opc;
	}

	public static void Alta(String tipo) throws Exception {
		String nom = "";
		int tel = 0;
		boolean valid = false;

		do {
			try {
				//Pedimos un nombre y lo validamos, todo dentro de un bucle. Si no es correcto, se tira una excepcion
				//Lo que saltea la linea de valid = true; que nos haria salir del bucle
				//En resumen, se pide el nombre al usuario y si no es correcto se lo pide otra vez
				System.out.println("Nombre: ");
				nom = sc.nextLine();
				if(nom.isEmpty()) throw new Exception("El nombre no puede estar vacio");
				valid = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}while(!valid);
		valid = false;

		do {
			try {
				System.out.println("Telefono (9 digitos): ");
				tel = sc.nextInt();
				if(("" + tel).length() != 9) throw new Exception("El numero de telefono debe tener exactamente 9 digitos");
				valid = true;
			}catch (InputMismatchException e) {
				System.out.println("El telefono solo puedo contener digitos"); 
				//Antes de la excepcion generica validamos que si nos haya pasado un numero
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 

		}while(!valid);
		sc.nextLine();
		valid = false;
		
		//Dependiendo del tipo de contacto se le piden ciertos datos
		if(tipo.equals("Personal")) {
			String cumple = "";
			do {
				try {
					System.out.println("Cumpleanios (formato DD/MM/AAAA): ");
					cumple = sc.nextLine();
					//if(!cumple.matches(regEx)) throw new Exception("El cumpleaños debe tener formato dd/mm/aaaa"); 
					//No recuerdo la expresion regEx para lograr esta condicion pero el codigo se veria asi
					//Voy a usar una solucion a medias que seria solamente pedir que tenga exactamente 10 caracteres
					if(cumple.length() != 10) throw new Exception("La fecha debe contener 10 caracteres en el formato DD/MM/AAAA");
					valid = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}while(!valid);
			valid = false;

			contactos.add(new ContactoPersonal(nom, tel, cumple)); //Creamos el contacto y lo aniadimos
			System.out.println("Contacto Personal aniadido");

		}else {
			String empresa = "";
			String email = "";

			System.out.println("Empresa: ");
			empresa = sc.nextLine();
			do {
				try {
					System.out.println("Email: ");
					email = sc.nextLine();
					//if(!email.matches(regEx)) throw new Exception("El email debe tener formato de correo valido"); 
					//No recuerdo la expresion regEx para lograr esta condicion pero el codigo se veria asi
					valid = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}while(!valid);
			valid = false;

			contactos.add(new ContactoProfesional(nom, tel, email, empresa));
			System.out.println("Contacto Profesional aniadido");
		}
	}

	public static void Listar(String tipo) {
		int i = 0; //Creamos un contador para saber si hay que avisar que no encontramos nada
		if(contactos.size() == 0) {
			System.out.println("No hay contactos registrados");
			return;
		}
		for(Contacto c : contactos)
			//Pedimos al contacto el nombre de su clase, lo comparamos con el nombre de la clase que queremos mostrar y si es asi le pedimos que muestre los datos
			//Si queremos listarlos a todos, se le puede pasar una cadena vacia, que siempre validara correctamente a cualquier nombre
			if(c.getClass().getTypeName().contains(tipo)) {
				c.mostrarInfo();
				i++;
			}
		if(i == 0) System.out.println("No se encontraron contactos de ese tipo");
	}

	public static void buscarXNom() {
		String nom;
		int i = 0;

		System.out.println("Nombre: ");
		nom = sc.nextLine();

		for(Contacto c : contactos)
			if(c.getNombre().equals(nom)) {
				c.mostrarInfo();
				i++;
			}

		if(i == 0) System.out.println("No se encontraron contactos con ese nombre");
	}

	public static void cargarDatos() throws Exception {
		String ruta = "", tipo, nom, cumple, email, empresa;
		int tel;
		File fichero;
		ArrayList<Contacto> aux = new ArrayList();
		Scanner lector;

		System.out.println("Ruta del fichero: ");
		ruta = sc.nextLine();
		fichero = new File(ruta); //Creamos nuestro objeto fichero

		//Validamos
		if(!fichero.exists()) throw new Exception("El fichero no existe");
		if(!fichero.isFile()) throw new Exception("No es un fichero");
		if(!fichero.canRead()) throw new Exception("No tienes permiso de lectura sobre este fichero");
		
		//Creamos un lector para leerlo
		lector = new Scanner(fichero);
		
		//hasNext nos devuelve si todavia hay cosas por leer, si las hay significa que hay que seguir agregando contactos
		while(lector.hasNext()) {
			tipo = lector.next();
			nom = lector.next();
			tel = lector.nextInt();
			//Leemos del propio fichero que tipo de contacto es y en consecuencia sacamos una cierta cantidad de datos del fichero
			//Creamos su respectivo tipo de contacto y lo agregamos a la lista
			if(tipo.contains("ContactoPersonal")) {
				cumple = lector.next();
				aux.add(new ContactoPersonal(nom, tel, cumple));
			}else {
				email = lector.next();
				empresa = lector.next();
				aux.add(new ContactoProfesional(nom, tel, email, empresa));
			}
		}
		
		contactos = aux;
		System.out.println(contactos.size() + " contactos cargados correctamente de " + ruta);
	}
	
	public static void guardarDatos() throws Exception {
		String ruta = "";
		File fichero;
		FileWriter fw;

		System.out.println("Ruta del fichero: ");
		ruta = sc.nextLine();
		
		fichero = new File(ruta);
		if(fichero.exists()) {
			if(!fichero.isFile()) throw new Exception("Ya existe una carpeta con ese nombre");
			if(!fichero.canWrite()) throw new Exception("No tienes permiso de escritura sobre este fichero");
			System.out.println("El fichero ya existe y sera sobreescrito");
		}
		
		//Creamos un escritor para escribir sobre el fichero
		fw = new FileWriter(fichero);
		
		for(Contacto c : contactos)
			fw.write(c.InfoParaFichero()); //Le pedimos al contacto la informacion necesaria para el fichero
		
		fw.close(); 
		System.out.println(contactos.size() + " contactos guardados correctamente en " + ruta);
	}
}


