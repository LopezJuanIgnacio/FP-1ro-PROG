import java.io.IOException;

public class ResumenUD3 {

    public static void main(String[] args) {
        // TRY CATCH
        try {
            // Codigo con errores
        } catch (ExceptionA e) {
            // Manejo de la excepción A
        } catch (ExceptionB e) {
            // Manejo de la excepción B
        } catch (Exception e) {
            // Manejo de la excepción genérica
        }
        // Ejemplo real
        String texto[] = { "Uno", "Dos", "Tres", "Cuatro", "Cinco" };
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("indice " + i + " = " + texto[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Fallo en el índice " + i);
            }
        }

        try {
            System.out.print("Valor: ");
            int valor = sc.nextInt();
            int auxiliar = 8 / valor;
            System.out.println(auxiliar);
        } catch (ArithmeticException e) {
            System.out.println("Division por cero");
        }

        // TRY CATCH FINALLY
        try {
            System.out.print("Valor: ");
            int valor = lector.nextInt();
            int auxiliar = 8 / valor;
            System.out.println(auxiliar);
        } catch (ArithmeticException e1) {
            System.out.println("Division por cero");
        } catch (InputMismatchException e2) {
            System.out.println("No se ha leído un entero....");
        } catch (Exception e9) {
            System.out.println("Error general");
        } finally {
            lector.nextLine(); // Se ejecuta siempre
        }

        // Metodos
        try {
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage()); // Muestra el mensaje de error
            System.out.println(ioe.toString()); // Muestra la clase y el mensaje de error
            ioe.printStackTrace(); // Muestra la pila de llamadas
        }

        // Crear excepciones
        new ArithmeticException();
        Exception error = new Exception();
        Exception correoErroneo = new Exception("E-MAIL ERRONEO !!!");

        class MisErrores extends Exception {  } //Aca escribis la clase de tu excepcion

        // Lanzar excepciones
        try {
            throw new Exception("Error de lectura");
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Error de lectura
        }
    }

    //Cuando la excepción es lanzada por un método, se debe indicar en la cabecera del método
    public void miMetodo() throws Exception {
        throw new Exception("Error en miMetodo");
    }

}
