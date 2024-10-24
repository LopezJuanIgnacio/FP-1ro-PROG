package paquete;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        EJ4();
    }

    public static void EJ4(){
       int[] numeros = new int[6];
       int aux;
       for (int i = 0; i < 100; i++) {
           aux = (int) (Math.random()* 6 + 1);
            numeros[aux-1]++;
            System.out.println(i);
       }
       for (int i = 0; i < 6; i++) System.out.println("El numero " + (i+1) + " salio " + numeros[i] + " veces " + Math.round(((double) numeros[i] / 100) * 100) + "%");
    }

    public static void EJ6(){
        String n;
        int total = 0;
        System.out.println("Ingrese un numero");
        Scanner sc = new Scanner(System.in);
        n = sc.nextLine();
        sc.close();
        for (int i = 0; i < n.length(); i++) 
            total += Integer.parseInt(String.valueOf(n.charAt(i)));
        
        System.out.println("La suma de los digitos es: " + total);
    }
}
