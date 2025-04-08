import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MiniTerminal {
	public static class MiniFileManager {
		private File root;

		public MiniFileManager() {
			this.root = new File(System.getProperty("user.dir"));
		}

		public String pwd() {
			return root.getAbsolutePath();
		}
		public void ls(boolean info){
			File[] lista = root.listFiles();
			if (lista != null) {
				Arrays.sort(lista, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
				for (File e : lista) {
					if (e.isDirectory()) {
						System.out.print(e.getName() + " *");
						if (info)
							System.out.println("\t Length: " + e.length() + " Last modified: " + e.lastModified());
						System.out.println();
					}
				}
				for (File e : lista) {
					if (e.isFile()) {
						System.out.print(e.getName() + " A");
						if (info)
							System.out.println("\t Length: " + e.length() + " Last modified: " + e.lastModified());
						System.out.println();
					}
				}
			}
		}
		public void mkdir(String dir){
			File f = new File(pwd() + "/" + dir +"/");
			f.mkdir();
		}
		public void rm(String dir){
			File f = new File(pwd() + "/" + dir +"/");
			File[] lista;
			if(f.exists()){
				if(f.isFile()){
					f.delete();
				}else{
					lista = f.listFiles();
					if(lista != null){
						for (File e : lista) {
							if (e.isDirectory()) {
								System.out.println("No se puede eliminar porque tiene subcarpetas");
								return;
							}
						}
	
						for (File e : lista) e.delete();
	
					}
					f.delete();
				}
			}else{
				System.out.println("No existe el directorio o archivo a eliminar");
			}
		}

		public void cd(String dir){
			if ("..".equals(dir)) {
				File parent = root.getParentFile();
				if (parent != null) {
					root = parent;
				} else {
					System.out.println("No hay carpeta padre");
				}
			} else {
				File f = new File(root, dir);
				if (f.exists() && f.isDirectory()) {
					root = f;
				} else {
					System.out.println("No es un directorio válido");
				}
			}
		}

		public void mv(String f1, String f2){
			File f = new File(pwd() + "/" + f1);
			File dest = new File(pwd() + "/" + f2);
			if(f.exists()){
				f.renameTo(dest);
			}else{
				System.out.println("El archivo origen no existe");
			}
		}
	}

	public static MiniFileManager mfm = new MiniFileManager();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			String cmd;
			String[] cmdParts;
			do {
				cmd = menu();
				cmdParts = cmd.split(" ");
				switch (cmdParts[0]) {
					case "pwd":
						System.out.println(mfm.pwd());
						break;
					case "ls":
						mfm.ls(false);
						break;
					case "ll":
						mfm.ls(true);
						break;
					case "cd":
						mfm.cd(cmdParts[1]);
						break;
					case "mkdir":
						mfm.mkdir(cmdParts[1]);
						break;
					case "rm":
						mfm.rm(cmdParts[1]);
						break;
					case "mv":
						mfm.mv(cmdParts[1], cmdParts[2]);
						break;
					case "help":
						System.out.println("Comandos disponibles: pwd, ls, cd, mkdir, rm, mv, help, exit");
						break;
					case "exit":
						System.out.println("Saliendo del programa...");
						break;

					default:
						throw new AssertionError();
				}

			} while (cmd.equals("exit") == false);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String menu() {
		System.out.print("MiniTerminal>" + mfm.pwd()+">");
		String cmd = sc.nextLine().trim();
		return cmd;
	}
}
