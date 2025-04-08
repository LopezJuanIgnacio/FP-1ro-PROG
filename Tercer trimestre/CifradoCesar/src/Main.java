import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String nom, contra, frase;
            Scanner scanner = new Scanner(System.in);
            File f = new File("user_info.txt");
            FileWriter fw = new FileWriter(f);

            do {
                System.out.println("Introduce un nombre de usuario (entre 5 y 15 caracteres):");
                nom = scanner.nextLine();
            } while (!nom.matches("^[a-zA-Z0-9]{5,15}$"));

            do {
                System.out.println("Introduce una contraseña (entre 5 y 15 caracteres):");
                contra = scanner.nextLine();
            } while (!contra.matches("^[a-zA-Z0-9]{5,15}$"));

            do {
                System.out.println("Introduce una frase de recordatorio de la contraseña (mínimo 15 caracteres):");
                frase = scanner.nextLine();
            } while (!frase.matches("^[a-zA-Z0-9 ]{16,}$"));

            scanner.close();
            cifrarYEscribir(nom, fw);
            cifrarYEscribir(contra, fw);
            cifrarYEscribir(frase, fw);
            fw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cifrarYEscribir(String txt, FileWriter fw) throws Exception {
        final int contraCifrado = 5;
        for (char letra : txt.toCharArray()) {
            if (Character.isLetter(letra)) {
                char base = Character.isLowerCase(letra) ? 'a' : 'A';
                letra = (char) ((letra - base + contraCifrado) % 26 + base);
            }
            fw.write(letra);
        }
        fw.write("\n");
    }
}
