public class EjercicioA12 {

    public static void main(String[] args) {
        double diam = 15.5;
        double alto = 42.4;
        double radio = diam / 2;
        double area;
        double volumen;

        // A = 2 Π r ( r + h )
        area = (2 * Math.PI * radio) * (alto + radio);

        // V = Π r 2·h
        volumen = Math.PI * Math.pow(radio, 2) * alto;

        System.out.println("Alto:\t\t" + alto);
        System.out.println("Diametro:\t" + diam);
        System.out.println("Area:\t\t" + area);
        System.out.println("Volumen:\t" + volumen);
    }
}