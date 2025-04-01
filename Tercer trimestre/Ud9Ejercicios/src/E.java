
import java.util.ArrayList;


public class E {
    //E2
    public static void main(String[] args) {
        Escena2D escena = new Escena2D(30, 30);
        escena.fill('.');

        ArrayList<IDrawable> drawables = new ArrayList<>();
        drawables.add(new Rectangulo(5, 5, 5, 5));
        drawables.add(new Ciruclo(20, 20, 5));
        drawables.add(new Triangulo(10, 10, 10, 10));
       
        escena.draw(drawables, '#');
        escena.print();
    }

    public interface IDrawable {
        // dibuja el objeto en el plano usando c
        void draw(char[][] plano, char c);
    }

    public static class Escena2D{
        private char[][] escena;

        public Escena2D(int ancho, int alto) {
            this.escena = new char[alto][ancho];
        }

        public char[][] getEscena() {
            return escena;
        }

        public void setEscena(char[][] escena) {
            this.escena = escena;
        }

        public void fill(char c){
            for (int i = 0; i < escena.length; i++) {
                for (int j = 0; j < escena[i].length; j++) {
                    escena[i][j] = c;
                }
            }
        }

        public void clear(){
            for (int i = 0; i < escena.length; i++) {
                for (int j = 0; j < escena[i].length; j++) {
                    escena[i][j] = ' ';
                }
            }
        }

        public void draw(IDrawable d, char c){
            d.draw(escena, c);
        }

        public void draw(ArrayList<IDrawable> d, char c){
            for (IDrawable drawable : d) {
                drawable.draw(escena, c);
            }
        }

        public void print(){
            for (int i = 0; i < escena.length; i++) {
                for (int j = 0; j < escena[i].length; j++) {
                    System.out.print(escena[i][j]);
                }
                System.out.println();
            }
        }


    }

    public static class Rectangulo implements IDrawable {
        private int x;
        private int y;
        private int ancho;
        private int alto;

        public Rectangulo(int x, int y, int ancho, int alto) {
            this.x = x;
            this.y = y;
            this.ancho = ancho;
            this.alto = alto;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getAncho() {
            return ancho;
        }

        public void setAncho(int ancho) {
            this.ancho = ancho;
        }

        public int getAlto() {
            return alto;
        }

        public void setAlto(int alto) {
            this.alto = alto;
        }

        @Override
        public void draw(char[][] plano, char c) {
            for (int i = y; i < y+alto; i++) {
                for (int j = x; j < x+ancho; j++) {
                    plano[i][j] = c;
                }
            }
        }
    }

    public static class Ciruclo implements IDrawable {
        private int x;
        private int y;
        private int radio;

        public Ciruclo(int x, int y, int radio) {
            this.x = x;
            this.y = y;
            this.radio = radio;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getRadio() {
            return radio;
        }

        public void setRadio(int radio) {
            this.radio = radio;
        }

        @Override
        public void draw(char[][] plano, char c) {
            for (int i = y-radio; i < y+radio; i++) {
                for (int j = x-radio; j < x+radio; j++) {
                    if (Math.sqrt(Math.pow(i-y, 2) + Math.pow(j-x, 2)) <= radio) plano[i][j] = c;
                }
            }
        }
    }

    public static class Triangulo implements IDrawable {
        private int x;
        private int y;
        private int base;
        private int altura;

        public Triangulo(int x, int y, int base, int altura) {
            this.x = x;
            this.y = y;
            this.base = base;
            this.altura = altura;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getBase() {
            return base;
        }

        public void setBase(int base) {
            this.base = base;
        }

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        @Override
        public void draw(char[][] plano, char c) {
            for (int i = y; i < y+altura; i++) {
                for (int j = x; j < x+base; j++) {
                    if (i <= y+altura-1-(j-x) && i >= y) plano[i][j] = c;
                }
            }
        }
    }
    //E1
    public interface IMinMax {
        int getMinimo();
        int getMaximo();
    }

    public interface IEstadisticas {
        double getMedia();
        double getMediana();
        int getModa();
    }

    public interface IComparable {
        boolean esIgual(int[] v);
        boolean esMayor(int[] v);
        boolean esMenor(int[] v);
        }

    public static class VectorInt implements IMinMax, IEstadisticas, IComparable {
        private int[] vector;

        public VectorInt(int v) {
            this.vector = new int[v];
        }

        public int[] getVector() {
            return vector;
        }

        public void setVector(int[] vector) {
            this.vector = vector;
        }

        @Override
        public String toString() {
            return "VectorInt{" +
                    "vector=" + java.util.Arrays.toString(vector) +
                    '}';
        }

        public void random(int min, int max){
            for (int i = 0; i < vector.length; i++)  vector[i] = (int) (Math.random()*((max-min)+1))+min;
        }


        @Override
        public int getMinimo() {
            int min = vector[0];
            for (int i = 1; i < vector.length; i++) {
                if (vector[i] < min) min = vector[i];
            }
            return min;
        }

        @Override
        public int getMaximo() {
            int max = vector[0];
            for (int i = 1; i < vector.length; i++) {
                if (vector[i] > max) max = vector[i];
            }
            return max;
        }

        @Override
        public double getMedia() {
            double media = 0;
            for (int i = 0; i < vector.length; i++) {
                media += vector[i];
            }
            return media/vector.length;
        }

        @Override
        public double getMediana() {
            java.util.Arrays.sort(vector);
            if (vector.length % 2 == 0) return (vector[vector.length/2] + vector[vector.length/2-1])/2;
            else return vector[vector.length/2];
        }

        @Override
        public int getModa() {
            int moda = 0;
            int max = 0;
            for (int i = 0; i < vector.length; i++) {
                int cont = 0;
                for (int j = 0; j < vector.length; j++) {
                    if (vector[i] == vector[j]) cont++;
                }
                if (cont > max) {
                    max = cont;
                    moda = vector[i];
                }
            }
            return moda;
        }

        @Override
        public boolean esIgual(int[] v) {
            if (vector.length != v.length) return false;
            for (int i = 0; i < vector.length; i++) {
                if (vector[i] != v[i]) return false;
            }
            return true;
        }

        @Override
        public boolean esMayor(int[] v) {
            StringBuilder thisVector = new StringBuilder();
            StringBuilder otherVector = new StringBuilder();

            for (int num : vector) {
                thisVector.append(Math.abs(num));
            }
            for (int num : v) {
                otherVector.append(Math.abs(num));
            }

            return Long.parseLong(thisVector.toString()) > Long.parseLong(otherVector.toString());
        }

        public boolean esMenor(int[] v) {
            StringBuilder thisVector = new StringBuilder();
            StringBuilder otherVector = new StringBuilder();

            for (int num : vector) {
                thisVector.append(Math.abs(num));
            }
            for (int num : v) {
                otherVector.append(Math.abs(num));
            }

            return Long.parseLong(thisVector.toString()) < Long.parseLong(otherVector.toString());
        }
    }
}
