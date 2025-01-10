public class Resumen {
    //Funciones
    // Función que suma dos números
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Función que resta dos números
    public static int restar(int a, int b) {
        return a - b;
    }

    // Función que multiplica dos números
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    // Función que divide dos números
    public static double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return (double) a / b;
    }

    //RECURSIVIDAD
    // Función que calcula el factorial de un número de forma recursiva
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Función principal para demostrar el uso de las funciones
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        System.out.println("Suma: " + sumar(num1, num2));
        System.out.println("Resta: " + restar(num1, num2));
        System.out.println("Multiplicación: " + multiplicar(num1, num2));
        System.out.println("División: " + dividir(num1, num2));
        System.out.println("Factorial de " + num1 + ": " + factorial(num1));
    }

    //Sobrecarga de funciones
    // Sobrecarga de la función sumar para sumar tres números
    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Sobrecarga de la función restar para que sea double
    public static double restar(double a, double b) {
        return a - b;
    }

    

}