public class EjercicioA3 {

    public static void main(String[] args) {
    	// variables
        double parcial1 = 8.2;
        double parcial2 = 6.5;
        double parcial3 = 9.5;
        double notaFinal;
        
        // mostrar parciales
        System.out.println("Programación");
        System.out.println("Parcial 1 = " + parcial1);
        System.out.println("Parcial 2 = " + parcial2);
        System.out.println("Parcial 3 = " + parcial3);

	// calcular y mostrar la nota final
        notaFinal = (parcial1 + parcial2 + parcial3) / 3;
        System.out.print("Final = " + notaFinal);
    }
}
