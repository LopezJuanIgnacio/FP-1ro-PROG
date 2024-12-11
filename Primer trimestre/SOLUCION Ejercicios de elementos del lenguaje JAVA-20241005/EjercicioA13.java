public class EjercicioA13 {

    public static void main(String[] args) {
        boolean result;

        result = 25 > 20 && 13 > 5;
        System.out.println("25>20 && 13>5 = " + result);
        // (25 > 20) && (13 > 5)

        result = 10 + 4 < 15 - 3 || 2 * 5 + 1 > 14 - 2 * 2;
        System.out.println("10+4 < 15-3 || 2*5 + 1 > 14 - 2*2 = " + result);
        // ((10 + 4) < (15 - 3)) || (((2 * 5) + 1) > (14 - (2 * 2)))

        result = 4 * 2 <= 8 || 2 * 2 < 5 && 4 > 3 + 1;
        System.out.println("4*2 <= 8 || 2*2 < 5 && 4 > 3 + 1 = " + result);
        // ((4 * 2) <= 8 )|| ((2 * 2) < 5) && (4 >( 3 + 1))

        result = 10 <= 2 * 5 && 3 < 4 || !(8 > 7) && 3 * 2 <= 4 * 2 - 1;
        System.out.println("10 <= 2*5 && 3 < 4 || !(8 > 7) && 3*2 <= 4*2-1; = " + result);
        // ((((10 <= (2 * 5))&& (3 < 4)) || !(8 > 7)) && ((3 * 2) <= ((4 * 2) - 1))

    }
}
