public class EjercicioA7 {

    public static void main(String[] args) {
        int cantidad = 2000;
        double interes = 2.75;
        int retHac = 18;
        double beneficio, retencion, cantidadFinal;
        double tiempo = 0.5; // años

        beneficio = ((cantidad * interes) / 100) * tiempo;
        retencion = (beneficio * retHac) / 100;
        cantidadFinal = cantidad + beneficio - retencion;

        System.out.println("Cantidad inicial: " + cantidad);
        System.out.println("Cantidad final:   " + cantidadFinal);

    }
}
