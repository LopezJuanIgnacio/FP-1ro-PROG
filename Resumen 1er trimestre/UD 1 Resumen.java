import java.util.*;

public class main {
    public static void main(String[] args) {

        //SCANNER
       Scanner sc = new Scanner(System.in);
        int numClase;
        String nombre;
        double nota;
        System.out.println("Introduce el número de clase:");
        numClase = sc.nextInt();
        //NOTA: esta línea es para capturar el retorno de carro
        sc.nextLine();
        System.out.println("Introduce el nombre del alumno:");
        nombre = sc.nextLine();
        System.out.println("Introduce la nota del exámen:");
        nota = sc.nextDouble();
        //Tambein se puede hacer con un int
        //nextInt () para leer un entero y asi con las demas variables

        //PRINTF
        //Declaración de variables
        int a = 8;
        int b = 3;
        int resultado = 0;
        //%d se sustituye por la variable entera, resultado
        //%n indica un salto de línea
        resultado = (a + b);
        System.out.printf(“La suma es: %d %n”, resultado);
        resultado = (a - b);
        System.out.printf("La resta es: %d %n", resultado);
        String texto = "Mayor";
        //Imprime: El resultado es Mayor
        System.out.printf("El resultado es: %s \n", texto);
        //Imprime: El resultado es MAYOR
        System.out.printf("El resultado es: %S %n", texto);
        //Imprime el valor de PI con 4 decimales y un ancho de 6 digitos
        System.out.printf("valor pi: %6.4f", Math.PI);

        //Literals
        //Se pueden usar para hacer más legible el código, para usar caracteres que no se pueden escribir directamente, como las comillas dobles
        String texto = “Pedro dijo: \"Hoy hace un día fantástico…\"";

        //CASTING
        //Lo que pasa con java es que si se hace una operación con dos enteros, el resultado será un entero, 
        //por lo que si se quiere que el resultado sea un decimal, como por ejemplo al dividir 3 sobre 2, aunque sean ambos enteros, se requiere un resultado decimal, asique se debe hacer un casting
        int x = 3;
        int y = 2;
        double z = 0;
        z = (double) x / y;
        String c  = ((double) numeros[i] / 100) * 100) + "%");

        //Casting de cadenas
        //Para convertir una cadena a un número se puede usar el método parseInt de la clase Integer
        String cadena = "123";
        int numero = Integer.parseInt(cadena);
        //Para convertir un número a una cadena se puede usar el método valueOf de la clase String
        int numero = 123;
        String cadena = String.valueOf(numero);

        

        //MATH
        //Math.random() devuelve un número decimal entre 0 y 1
        //Se puede generar un numero entre un rango con la formula (int) Math.random() * (max - min + 1) + min
        int d6 = (int) (Math.random() * 6 + 1);
        //Math.round() redondea un número decimal
        //Math.abs() devuelve el valor absoluto de un número
        //Math.pow() eleva un número a una potencia
        //Math.sqrt() devuelve la raíz cuadrada de un número
        //Math.floor() devuelve el número entero menor o igual más cercano
        //Math.PI devuelve el valor de PI
        //Math.E devuelve el valor de E

        //Calendar
        //Para obtener la fecha y hora actual se puede usar la clase Calendar
        Calendar calendario = Calendar.getInstance();
        //Para obtener el año actual
        int año = calendario.get(Calendar.YEAR);
        //Para obtener el mes actual
        int mes = calendario.get(Calendar.MONTH) + 1;
        //Para obtener el día actual
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        //String
        //String.equals()
        //Para comparar dos cadenas se debe usar el método equals de la clase String
        String cadena1 = "hola";
        String cadena2 = "hola";
        if (cadena1.equals(cadena2)) {
            System.out.println("Las cadenas son iguales");
        } else {
            System.out.println("Las cadenas son diferentes");
        }
        //Para comparar dos cadenas sin importar si son mayúsculas o minúsculas se debe usar el método equalsIgnoreCase de la clase String
        if (cadena1.equalsIgnoreCase(cadena2)) {
            System.out.println("Las cadenas son iguales");
        } else {
            System.out.println("Las cadenas son diferentes");
        }
        System.out.println(cadena1.charAt(0)); //Imprime: h

        //String.format()
        //Para formatear una cadena se puede usar el método format de la clase String
        String cadena = String.format("El número %d es par", 2);
        System.out.println(cadena); //Imprime: El número 2 es par

        //String.substring()
        //Para obtener una subcadena de una cadena se puede usar el método substring de la clase String
        String cadena = "hola mundo";
        String subcadena = cadena.substring(5, 10);
        System.out.println(subcadena); //Imprime: mundo

        //String.indexOf()
        //Para obtener la posición de una subcadena en una cadena se puede usar el método indexOf de la clase String
        int posicion = cadena.indexOf("mundo", 1);
        System.out.println(posicion); //Imprime: 5

        //String.split()
        //Para dividir una cadena en un array de cadenas se puede usar el método split de la clase String
        String[] palabras = cadena.split(" ");
        System.out.println(palabras[0]); //Imprime: hola

        //String.replace()
        //Para reemplazar una subcadena en una cadena se puede usar el método replace de la clase String
        String nuevaCadena = cadena.replace("mundo", "amigos");

        //String.trim()
        //Para eliminar los espacios en blanco al principio y al final de una cadena se puede usar el método trim de la clase String
        String cadena = " hola mundo ";
        System.out.println(cadena.trim()); //Imprime: hola mundo

        //String.toCharArray()
        //Para convertir una cadena en un array de caracteres se puede usar el método toCharArray de la clase String
        char[] caracteres = cadena.toCharArray();
        System.out.println(caracteres[0]); //Imprime: h


    }
}