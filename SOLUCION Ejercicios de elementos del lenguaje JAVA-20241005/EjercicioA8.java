public class EjercicioA8 {

    public static void main(String[] args) {
        int cantidad = 2000;
        double interes = 2.75;
        int retHac = 18;
        double beneficio, retencion, cantidadFinal;
        double tiempo = 0.5 ; // años

        System.out.println("Cantidad inicial: " + cantidad);

        beneficio = ((cantidad * interes) / 100); //anual
        System.out.println("Intereses anuales: " + beneficio);

        beneficio = beneficio / 2;
        System.out.println("Intereses a los 6 meses: " + beneficio);

        retencion = (beneficio * retHac) / 100;
        System.out.println("Retencion Hacienda: " + retencion);

        beneficio = beneficio - retencion;
        System.out.println("Interes neto: " + beneficio);
        
        cantidadFinal = cantidad + beneficio;
        System.out.println("Cantidad final: " + cantidadFinal);
    }
}
