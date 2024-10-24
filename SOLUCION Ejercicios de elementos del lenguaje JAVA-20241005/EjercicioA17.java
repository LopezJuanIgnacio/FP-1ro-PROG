public class EjercicioA17 {

    public static void main(String[] args) {
        // Variables
        int entrada;
        double area, perimetro;

        // Lectura de teclado
        java.util.Scanner lector = new java.util.Scanner(System.in);
        System.out.print("Introduce el lado del triangulo: ");
        entrada = lector.nextInt();

        // Cálculo de permitetro y área
        perimetro = entrada * 3;
        area = Math.pow(entrada, 2) * (Math.sqrt(3) / 4);

        // Mostrar perímetro y área
        System.out.println("Perímetro =\t" + perimetro);
        System.out.println("Area =\t" + area);

    }
}
