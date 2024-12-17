package test;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        char[][] grilla = new char[10][10];

        for(int i = 0; i < grilla.length; i++){
            Arrays.fill(grilla, '*');
        }
        rellenarGrilla(grilla);
        do{

        }while(termino(grilla) == false);
    }

    public static void turno(char[][] grilla){

    }

    public static void rellenarGrilla(char[][] grilla){
        int x;
        char orien;
        for(int i = 0; i < grilla.length; i++){
            for(int j = 0; j < grilla[i].length; j++){
                x = (int) Math.random() * (6-1);
                if(x == 0) break;
                else{
                    orien = (Math.random() < 0.5) ? 'V' : 'H';
                    if(esPosible(orien, i, j, x) == false) break;
                    else ponerBarco(grilla, orien);
                }
            }
        }
    }

    public static boolean esPosible(char orien,int i,int j, int x){
        if (orien == 'V') {
            if((j+x) > 10) return false;
            else return true;
        }else{
            if((i+x) > 10) return false;
            else return true;
        }
    }

    public static boolean termino(char[][] grilla) {
        for(int i = 0; i < grilla.length; i++) {
            for(int j = 0; j < grilla[i].length; j++) {
                if(grilla[i][j] != '*') {
                    return false;
                }
            }
        }
        return true;
    }

    // public static void main(String[] args) {
    //     int neg = 0, pos = 0, x, y = 0;
    //     Scanner sc = new Scanner(System.in);

    //     for(int i = 0; i < 20; i++) {
    //         System.out.println("Escribe un número: ");
    //         x= sc.nextInt();
    //         y += x;
    //         if(x> 0) pos += x;
    //         else neg += x;
    //     }
    //     y = y / 20;
    //     System.out.println("La suma de los números positivos es: " + pos);
    //     System.out.println("La suma de los números negativos es: " + neg);
    //     System.out.println("El promedio de los números es: " + y);
    // }
    // public static void main(String[] args) {
    //     int[] arr = new int[10];
    //     int x = 0, max = 0;
    //     Scanner sc = new Scanner(System.in);

    //     for(int i = 0; i < 10; i++) {
    //         System.out.println("Escribe un número: ");
    //         arr[i] = sc.nextInt();
    //     }
    //     System.out.println("Los números que escribiste son: ");
    //     for (int i = 0; i < 10; i++) {
    //         x += arr[i];
    //         System.out.println(arr[i]);
    //         if(arr[i] > max) max = arr[i];
    //     }
    //     System.out.println("La suma de los números es: " + x);
    //     System.out.println("El número mayor es: " + max);
    // }
}