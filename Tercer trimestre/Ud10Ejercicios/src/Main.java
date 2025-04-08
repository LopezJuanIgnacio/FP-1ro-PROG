import java.io.*;
import java.util.*;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			b7();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A1
	public static void a1() {
		try {
			String ruta;
			File f;
			do {
				System.out.println("Introduce la ruta del archivo: ");
				ruta = sc.nextLine();
				if (ruta.isEmpty())
					break;
				f = new File(ruta);
				muestraInfoRuta(f, true);
			} while (true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void muestraInfoRuta(File ruta) throws Exception {
		if (!ruta.exists())
			throw new FileNotFoundException();
		if (ruta.isDirectory()) {
			File[] files = ruta.listFiles();
			if (files != null) {
				for (File e : files) {
					if (e.isDirectory()) {
						System.out.println(e.getName() + " *");
					}
				}
				for (File e : files) {
					if (e.isFile()) {
						System.out.println(e.getName() + " A");
					}
				}
			}
		} else {
			System.out.println(ruta.getName() + " A");
		}
	}

	// A2
	public static void muestraInfoRuta(File ruta, boolean info) throws Exception {
		if (!ruta.exists())
			throw new FileNotFoundException();
		if (ruta.isDirectory()) {
			File[] files = ruta.listFiles();
			Arrays.sort(files, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
			if (files != null) {
				for (File e : files) {
					if (e.isDirectory()) {
						System.out.print(e.getName() + " *");
						if (info)
							System.out.println("\t Length: " + e.length() + " Last modified: " + e.lastModified());
						System.out.println();
					}
				}
				for (File e : files) {
					if (e.isFile()) {
						System.out.print(e.getName() + " A");
						if (info)
							System.out.println("\t Length: " + e.length() + " Last modified: " + e.lastModified());
						System.out.println();
					}
				}
			}
		} else {
			System.out.println(ruta.getName() + " A");
			if (info)
				System.out.println("\t Length: " + ruta.length() + " Last modified: " + ruta.lastModified());
			System.out.println();
		}
	}

	// A3
	public static void a3() throws Exception {
		File docs = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/Documentos");
		File fotos = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/Fotografias");
		File lecturas = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/Libros");

		docs.renameTo(new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS"));
		fotos.renameTo(new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/FOTOS"));
		lecturas.renameTo(new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/LECTURAS"));

		for (File e : fotos.listFiles()) {
			if (e.isFile()) {
				String newName = e.getName().substring(0, e.getName().lastIndexOf('.'));
				e.renameTo(new File(fotos.getAbsolutePath() + "/" + newName));
			}
		}
		for (File e : lecturas.listFiles()) {
			if (e.isFile()) {
				String newName = e.getName().substring(0, e.getName().lastIndexOf('.'));
				e.renameTo(new File(lecturas.getAbsolutePath() + "/" + newName));
			}
		}
	}

	// A4
	public static void a4() throws Exception {
		File fotos = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/FOTOS");
		File lecturas = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/LECTURAS");

		File MisCosas = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/Mis cosas");
		File Alfabeto = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/Alfabeto");

		MisCosas.mkdir();
		Alfabeto.mkdir();

		fotos.renameTo(
				new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/Mis cosas/LECTURAS"));
		lecturas.renameTo(
				new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS/Mis cosas/FOTOS"));

		for (int i = 65; i <= 90; i++) {
			File letra = new File(Alfabeto.getAbsolutePath() + "/" + (char) i + "/");
			letra.mkdir();
		}
	}

	// A5
	public static void a5() throws Exception {
		System.out.println(borraTodo(new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/DOCS")));
	}

	public static boolean borraTodo(File f) throws Exception {
		if (!f.exists())
			throw new FileNotFoundException();
		if (f.isFile())
			return f.delete();
		else {
			boolean borrado = true;
			File[] files = f.listFiles();
			if (files != null)
				for (File e : files)
					if (!borraTodo(e))
						borrado = false;
			return f.delete() && borrado;
		}
	}

	// B1
	public static void b1() throws Exception {
		File nums = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/Documentos/numeros.txt");
		Scanner sc = new Scanner(nums);
		int max, min, aux;

		max = sc.nextInt();
		min = max;

		while (sc.hasNext()) {
			aux = sc.nextInt();
			max = max < aux ? aux : max;
			min = min > aux ? aux : min;
		}

		System.out.println("Min: " + min);
		System.out.println("Max: " + max);

	}

	// B2
	public static void b2() throws Exception {
		class Alumno {
			private String nombre;
			private float nota;

			public Alumno(String nombre, float nota) {
				this.nombre = nombre;
				this.nota = nota;
			}

			public String getNombre() {
				return nombre;
			}

			public float getNota() {
				return nota;
			}
		}
		File notas = new File(
				"C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/Documentos/alumnos_notas.txt");
		Scanner sc = new Scanner(notas);
		String nom;
		float notaMedia = 0;
		int i = 0;
		ArrayList<Alumno> alumnos = new ArrayList<>();

		while (sc.hasNext()) {
			i = 0;
			notaMedia = 0;
			nom = sc.next() + " " + sc.next();
			while (sc.hasNextInt()) {
				i++;
				notaMedia += (float) sc.nextInt();
			}
			notaMedia = notaMedia / i;
			alumnos.add(new Alumno(nom, notaMedia));
		}
	}

	// B3
	public static void b3() throws Exception {
		String lectura, escritura, aux;

		System.out.println("Introduce la ruta del archivo de lectura: ");
		lectura = sc.nextLine();
		System.out.println("Introduce la ruta del archivo de escritura: ");
		escritura = sc.nextLine();
		File fLectura = new File(lectura);
		File fEscritura = new File(escritura);

		if (!fLectura.exists())
			throw new FileNotFoundException();

		Scanner sc = new Scanner(fLectura);
		FileWriter fw = new FileWriter(fEscritura);

		TreeSet<String> lines = new TreeSet<>();

		while (sc.hasNext()) {
			aux = sc.nextLine();
			lines.add(aux);
		}

		for (String line : lines) {
			fw.write(line + "\n");
		}

		fw.write("\n");
		fw.close();
	}

	// B4
	public static void b4() throws Exception {
		ArrayList<String> Nombres = new ArrayList<>();
		ArrayList<String> Apellidos = new ArrayList<>();
		File fNom = new File(
				"C:\\Users\\Juani\\Desktop\\FP 1er Año\\Programacion\\Tercer trimestre\\Documentos\\usa_nombres.txt");
		File fApe = new File(
				"C:\\Users\\Juani\\Desktop\\FP 1er Año\\Programacion\\Tercer trimestre\\Documentos\\usa_apellidos.txt");

		Scanner scLec = new Scanner(fNom);

		while (scLec.hasNext())
			Nombres.add(scLec.nextLine());
		scLec = new Scanner(fApe);
		while (scLec.hasNext())
			Apellidos.add(scLec.nextLine());

		while (!Nombres.isEmpty() && !Apellidos.isEmpty())
			System.out.println(
					Nombres.remove((int) (Math.random() * (Nombres.size())))
							+ " " +
							Apellidos.remove((int) (Math.random() * (Apellidos.size()))));

	}

	// B5
	public static void b5() throws Exception{
		String palabra;
		char letraActual = 'a', aux;
		File Diccionario = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/Documentos/diccionario.txt");
		File Alfabeto = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/Documentos/Alfabeto");

		Alfabeto.mkdir();
		
		File letra = new File(Alfabeto.getAbsolutePath() + "/" + letraActual + ".txt");
		FileWriter fw = new FileWriter(letra);
		Scanner Lector = new Scanner(Diccionario);

		while(Lector.hasNext()){
			palabra = Lector.nextLine();
			aux = palabra.charAt(0);
			if ("áéíóúÁÉÍÓÚ".indexOf(aux) != -1) {
				aux = Character.toLowerCase(aux);
				switch (aux) {
					case 'á': aux = 'a'; break;
					case 'é': aux = 'e'; break;
					case 'í': aux = 'i'; break;
					case 'ó': aux = 'o'; break;
					case 'ú': aux = 'u'; break;
				}
			}

			if(letraActual != aux){
				letraActual = aux;
				letra = new File(Alfabeto.getAbsolutePath() + "/" + letraActual + ".txt");
				fw = new FileWriter(letra);
			}
			fw.write(palabra + "\n");
		}
	}

	//B6
	public static void b6() throws Exception{
		File pi = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/Documentos/pi-million.txt");
		Scanner Lector = new Scanner(pi);
		String num = "1234";
		String aux;

		while (Lector.hasNext()) {
			aux = Lector.next();
			for (int i = 0; i < aux.length(); i++) {
				if (num.length() == 4) num = num.substring(1);
				num = num.concat(String.valueOf(aux.charAt(i)));
				if (num.equals("1224")) {
					System.out.println("Se encontro en " + i);
					return;
				}
			}
		}
		System.out.println("No se encontro");
	}

	//B7
	public static void b7() throws Exception{
		Hashtable<String,Integer> tabla = new Hashtable<String,Integer>();
		File frases = new File("C:/Users/Juani/Desktop/FP 1er Año/Programacion/Tercer trimestre/Documentos/frases.txt");
		Scanner Lector = new Scanner(frases);
		int cLineas = 0;
		String linea;
		
		while(Lector.hasNext()) {
			cLineas++;
			linea = Lector.nextLine();
			for (String palabra : linea.split(" ")) {
				if (tabla.containsKey(palabra)) {
					tabla.put(palabra, tabla.get(palabra) + 1);
				} else {
					tabla.put(palabra, 1);
				}
			}
		}

		System.out.println("Total de lineas: " + cLineas);
		System.out.println("Total de palabras: " + tabla.size());
		System.out.println("Palabra mas repetida: " + Collections.max(tabla.entrySet(), Map.Entry.comparingByValue()).getKey() + " " + Collections.max(tabla.entrySet(), Map.Entry.comparingByValue()).getValue() + " veces");
		System.out.println("Palabra menos repetida: " + Collections.min(tabla.entrySet(), Map.Entry.comparingByValue()).getKey() + " " + Collections.min(tabla.entrySet(), Map.Entry.comparingByValue()).getValue() + " veces");
		System.out.println("Palabras: ");
		for (Map.Entry<String, Integer> entry : tabla.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue() + " veces");
			
		}
		
	}
}
