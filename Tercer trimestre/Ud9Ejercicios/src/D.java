import java.util.ArrayList;

public class D {
    //D3
    public static void d3() {
        SistemaSolar sistemaSolar = new SistemaSolar("Sistema Solar");

        Planeta tierra = new Planeta("Tierra", 5972, 15, 149600000);
        Planeta marte = new Planeta("Marte", 641, -60, 227900000);

        Satelite luna = new Satelite("Luna", 7348, -20, 384400);
        Satelite fobos = new Satelite("Fobos", 11, -40, 9376);
        Satelite deimos = new Satelite("Deimos", 2, -40, 23460);

        tierra.addSatelite(luna);
        marte.addSatelite(fobos);
        marte.addSatelite(deimos);

        sistemaSolar.addPlaneta(tierra);
        sistemaSolar.addPlaneta(marte);

        System.out.println("Información inicial del sistema solar:");
        for (Planeta planeta : sistemaSolar.planetas) {
            System.out.println(planeta.toString());
            for (Satelite satelite : planeta.satelites) {
                System.out.println("  " + satelite.toString());
            }
        }

        System.out.println("\nEliminando el satélite Fobos de Marte...");
        marte.rmSatelite(fobos);

        System.out.println("\nInformación del sistema solar después de los cambios:");
        for (Planeta planeta : sistemaSolar.planetas) {
            System.out.println(planeta.toString());
            for (Satelite satelite : planeta.satelites) {
                System.out.println("  " + satelite.toString());
            }
        }
    }
    public static abstract class Astro{
        protected  String nombre;
        protected  int masa;
        protected  int temp;

        public Astro(String nombre, int masa, int temp) {
            this.nombre = nombre;
            this.masa = masa;
            this.temp = temp;
        }
    }

    public static class Planeta extends Astro{
        private int distSol;
        private ArrayList<Satelite> satelites;

        public Planeta(String nombre, int masa, int temp, int distSol) {
            super(nombre, masa, temp);
            this.distSol = distSol;
            this.satelites = new ArrayList<>();
        }

        public void addSatelite(Satelite satelite){
            satelites.add(satelite);
        }

        public void rmSatelite(Satelite satelite){
            satelites.remove(satelite);
        }

        @Override
        public String toString() {
            return "Planeta: " + nombre + ", masa: " + masa + ", temp: " + temp + ", distSol: " + distSol;
        }
    }

    public static class Satelite extends Astro{
        private int distPlaneta;

        public Satelite(String nombre, int masa, int temp, int distPlaneta) {
            super(nombre, masa, temp);
            this.distPlaneta = distPlaneta;
        }

        @Override
        public String toString() {
            return "Satelite: " + nombre + ", masa: " + masa + ", temp: " + temp + ", distPlaneta: " + distPlaneta;
        }
    }

    public static class SistemaSolar{
        private  String nombre;
        private  ArrayList<Planeta> planetas;

        public SistemaSolar(String nombre) {
            this.nombre = nombre;
            this.planetas = new ArrayList<>();
        }

        public void addPlaneta(Planeta planeta){
            planetas.add(planeta);
        }

        public void rmPlaneta(Planeta planeta){
            planetas.remove(planeta);
        }
    }
    //D2
    public static void d2() {
        // Mascota m = new Mascota("Test", 1);

        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Perro("Rex", 3, true));
        mascotas.add(new Perro("Max", 5, false));
        mascotas.add(new Gato("Luna", 2, "Blanco"));
        mascotas.add(new Gato("Milo", 4, "Negro"));
        mascotas.add(new Canario("Tweety", 1, true));
        mascotas.add(new Canario("Sunny", 2, false));

        System.out.println("Información inicial de las mascotas:");
        for (Mascota mascota : mascotas) {
            System.out.println(mascota);
        }

        for (int i = 0; i < 5; i++) {
            for (Mascota mascota : mascotas) {
                mascota.cumpleaños();
            }
        }

        System.out.println("\nInformación de las mascotas después de 5 cumpleaños:");
        for (Mascota mascota : mascotas) {
            System.out.println(mascota);
        }

        System.out.println("\nSonidos de las mascotas:");
        for (Mascota mascota : mascotas) {
            mascota.habla();
        }
    }
    public static abstract class Mascota {
        protected String nombre;
        protected int edad;

        public Mascota(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public abstract String toString();
        public void cumpleaños(){
            this.edad += 1;
        }
        public abstract void habla();
    }  

    public static class Perro extends Mascota {
        private boolean pulgas;

        public Perro(String nombre, int edad, boolean pulgas) {
            super(nombre, edad);
            this.pulgas = pulgas;
        }

        @Override
        public String toString() {
            return "Perro: " + nombre + ", " + edad + " años, pulgas: " + pulgas;
        }

        @Override
        public void habla() {
            System.out.println("Guau guau");
        }
    }

    public static class Gato extends Mascota {
        private String color;

        public Gato(String nombre, int edad, String color) {
            super(nombre, edad);
            this.color = color;
        }

        @Override
        public String toString() {
            return "Gato: " + nombre + ", " + edad + " años, color: " + color;
        }

        @Override
        public void habla() {
            System.out.println("Miau miau");
        }
    }

    public static class Canario extends Mascota {
        private boolean volando;

        public Canario(String nombre, int edad, boolean volando) {
            super(nombre, edad);
            this.volando = volando;
        }

        @Override
        public String toString() {
            return "Canario: " + nombre + ", " + edad + " años, volando: " + volando;
        }

        @Override
        public void cumpleaños() {
            this.edad += 2;
        }

        @Override
        public void habla() {
            System.out.println("Pio pio");
        }
    }

    // D1
    public static void ProgramaFiguras () {
        ArrayList<Figura> figuras = new ArrayList<Figura>();
        figuras.add(new Circulo(10)); // Radio=10
        figuras.add(new Cuadrado(10)); // Lado=10
        figuras.add(new Triangulo(10, 5)); // Base=10, Altura=5;
        figuras.add(new Rectangulo(10, 5)); // Base=10, Altura=5;
        for (Figura f : figuras)
            System.out.println("Área: " + f.Area());
    }

    public static abstract  class Figura {
        protected double area; // Si no es protected no se hereda

        protected abstract double Area();

        public Figura(double area) {
            this.area = area;
        }

        public Figura() { // Constructor vacío por si no hay area
        }
    }

    public static class Circulo extends Figura {
        private double radio;

        public Circulo(double radio) {
            super();
            this.radio = radio;
            Area();
        }

        @Override
        public double Area() {
            return area = Math.PI * Math.pow(radio, 2);
        }
    }

    public static class Cuadrado extends Figura {
        private double lado;

        public Cuadrado(double lado) {
            this.lado = lado;
            Area();
        }
        @Override
        public double Area() {
            return area = Math.pow(lado, 2);
        
        }
    }

    public static class Triangulo extends Figura {
        private double base;
        private double altura;

        public Triangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
            Area();
        }
        
        @Override
        public double Area() {
            return area = (base * altura) / 2;
        }
    }

    public static class Rectangulo extends Figura {
        private double base;
        private double altura;

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double Area() {
            return area = base * altura;
        }
    }
}
