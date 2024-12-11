public class EjercicioA6 {

    public static void main(String[] args) {
        double precio = 85;
        int porcentaje = 15;
        double rebaja;
        double total;

        rebaja = precio * porcentaje / 100;
        total = precio - rebaja;

        System.out.println("Precio inicial    = " + precio + " €");
        System.out.println("Porcentaje Rebaja = " + porcentaje + " %");
        System.out.println("Rebaja            = " + rebaja + " €");
        System.out.println("Precio final      = " + total + " €");
    }
}
