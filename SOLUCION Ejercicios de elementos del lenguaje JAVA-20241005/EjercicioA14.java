public class EjercicioA14 {

    public enum diasSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    };

    public static void main(String[] args) {
        diasSemana hoy = diasSemana.MARTES;
        diasSemana dom = diasSemana.DOMINGO;

        System.out.println("Hoy es " + hoy);
        System.out.println("Domingo es el dia numero " + dom.ordinal());
    }
}
