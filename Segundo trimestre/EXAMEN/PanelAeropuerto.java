package eval2;
import java.util.*;

public class PanelAeropuerto {
	//Definimos nuestras variables globales que se utilizaran en toda la clase
	public static Scanner sc = new Scanner(System.in); //Nuestro scanner
	public static PanelVuelo panel = new PanelVuelo();//El panel

	//Definimos la clase PanelVuelo 
	static class PanelVuelo{
		//Definimos la lista de vuelos
		private ArrayList<Vuelo> vuelos;

		//Constructor
		public PanelVuelo() {
			this.vuelos = new ArrayList<Vuelo>();
		}
		
		//Definimos los metodos

		//Definimos un metodo para recorrer el panel en busqueda de un vuelo especifico y que nos devuelva el indice
		public int buscarXID(String id) {
			for(int i = 0; i < this.vuelos.size(); i++) {
				if(id.equalsIgnoreCase(this.vuelos.get(i).id)) return i; //Si lo encuentra devuelve i como su indice
			}
			return -1; 
		}

		//1
		public void agregarVuelo() {
			String ciuOrg, ciuDes, hora;

			//Pedimos todos los valores para nuestro vuelo
			System.out.print("Ciudad de origen: ");
			ciuOrg = sc.nextLine();

			System.out.print("Ciudad de destino: ");
			ciuDes = sc.nextLine();

			System.out.print("Hora  (HH:MM): ");
			hora = sc.nextLine();

			//Creamos el nuevo vuelo y lo agregamos
			this.vuelos.add(new Vuelo(ciuOrg, ciuDes, hora));

			//Usamos el metodo presentarse del vuelo
			//Podemos asumir que el ultimo de la lista es el ultimo creado

			System.out.print("\t Vuelo agregado: ");
			System.out.println(this.vuelos.get(this.vuelos.size() -1).presentarse());

		}

		//2
		public void cambiarEstado() {
			String id, estado;
			int index;

			//Pedimos los datos necesarios

			System.out.print("ID del vuelo: ");
			id = sc.nextLine();

			System.out.print("Nuevo  estado (ESPERANDO, EMBARCANDO, RETRASADO, CANCELADO): ");
			estado = sc.nextLine();

			index = buscarXID(id);

			if(index ==  -1) {
				System.out.println("\t Vuelo " + id + " No encontrado"); //En la hoja con la consigna, en la parte de ejemplo de ejecucion hay algunos resultados con  tabulaciones y otros que no, si se ve raro, es que lo intente asemejar lo mejor que pude 
				return;
			}

			//Seteamos el nuevo estado al vuelo si lo encontro
			this.vuelos.get(index).estado = estado;
			System.out.println("Vuelo " + id + " actualizado a " + estado) ;
		}

		//3
		public void mostrarXEstado() {
			String estado;
			int c = 0; //Usaremos un contador para verificar si al final del bucle no se encontro ningun vuelo y hay que informarlo

			//Pedimos el estado
			System.out.print("Estado a filtrar (ESPERANDO, EMBARCANDO, RETRASADO, CANCELADO): ");
			estado = sc.nextLine();

			for(Vuelo v : this.vuelos) {
				if(estado.equalsIgnoreCase(v.estado)) {
					c++;
					System.out.println(v.toString());
				}
			}

			if(c == 0) System.out.println("\t No hay vuelos con estado " + estado);
		}
		//4
		public void buscarVuelo() {
			String id;
			int index;

			//Pedimos los datos necesarios

			System.out.print("ID del vuelo: ");
			id = sc.nextLine();

			index = buscarXID(id);

			if(index ==  -1) {
				System.out.println("Vuelo " + id + " No encontrado");
				return;
			}
			
			System.out.println(this.vuelos.get(index).toString());
		}
	}
	//Definimos la clase vuelo
	static class Vuelo{
		//Definimos sus atributos
		private String id;
		private String ciuOrg;
		private String ciuDes;
		private String horaSal;
		private String estado;

		//Constructor
		public Vuelo(String ciuOrg, String ciuDes, String hora) {
			this.id = this.generarIdentificador(ciuOrg, ciuDes, hora);
			this.ciuOrg = ciuOrg;
			this.ciuDes = ciuDes;
			this.horaSal = hora;
			this.estado = "ESPERANDO";
		}

		
		//No son necesarios getters y setters ya que se manejan los atributos desde PanelVuelo

		//Definimos el metodo generadorIDentificador
		//Lo generamos aqui, dentro de la clase dado a que no se utiliza fuera de esta
		public String generarIdentificador(String ciuOrg, String ciuDes, String hora) {
			//Agarramos las 3 primeras letras de ambas ciudades cambiando sus letras a mayusculas y le quitamos el : al horario
			return ciuOrg.substring(0, 3).toUpperCase() +  ciuDes.substring(0, 3).toUpperCase() + hora.replace(":","");
		}

		public String presentarse() {
			return this.id + " (" +this.estado + ")";
		}

		public String toString() {
			return "Vuelo " + this.id + " de " + this.ciuOrg + " a " + this.ciuDes + " a las " + this.horaSal +" esta " + this.estado;
		}
	}

	public static void main(String[] args) {
		int opt;

		do {
			opt = menu();  //Pedimos una opcion al usuario
			switch (opt) { //En base a esa opcion se ejecuta cada funcion
			case 1:
				panel.agregarVuelo();
				break;
			case 2:
				panel.cambiarEstado();
				break;
			case 3:
				panel.mostrarXEstado();
				break;
			case 4:
				panel.buscarVuelo();
				break;
			case 5:
				System.out.println("Que tenga un feliz vuelo");
				break;

			default:
				System.out.println("Valor no valido");
				break;
			}
		}while(opt != 5);
	}

	public static int menu() {
		int  opt;

		System.out.println("Gestion del panel de vuelos: ");
		System.out.println("1.Agregar vuelo");
		System.out.println("2.Cambiar estado de un vuelo");
		System.out.println("3. Mostrar vuelos por estado");
		System.out.println("4. Buscar vuelo por id");
		System.out.println("5. Salir");
		System.out.print("Opcion: ");

		opt = sc.nextInt();
		sc.nextLine(); //Vaciamos el buffer

		return opt;
	}


}
