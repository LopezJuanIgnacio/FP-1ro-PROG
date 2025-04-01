import java.util.ArrayList;

public class B {
    // B4
    public static class Cooperativa {
        private ArrayList<Trabajadora> trabajadoras;

        public Cooperativa() {
            trabajadoras = new ArrayList<>();
        }

        public void añadirTrabajadora(Trabajadora trabajadora) {
            trabajadoras.add(trabajadora);
        }

        public void mostrarInformacion() {
            for (Trabajadora t : trabajadoras) {
                System.out.println("Nombre: " + t.nombre + ", Horas trabajadas: " + t.horas + ", Salario por hora: " + t.precioHora);
            }
        }

        public void simularSemana() {
            for (Trabajadora t : trabajadoras) {
                int horas = (int) (Math.random() * (50 - 10 + 1)) + 10;
                t.trabajar(horas);
                System.out.println("Nombre: " + t.nombre + ", Cobro semanal: " + t.cobrar());
            }
        }
    }

    public static class  Trabajadora{
        protected String nombre;
        protected int horas;
        protected final double precioHora = 10;

        public Trabajadora(String nombre, int horas) {
            this.nombre = nombre;
            this.horas = 0;
        }

        public void trabajar(int horas){
            this.horas += horas;
        }

        public double cobrar(){
            double cobro = horas * precioHora;
            this.horas = 0;
            return cobro;
        }
    }

    public static class Operaria extends Trabajadora{

        public Operaria(String nombre, int horas) {
            super(nombre, horas);
        }

        @Override
        public void trabajar(int horas) {
            if(this.horas + horas > 40 ) super.trabajar(40 - this.horas);
            else super.trabajar(horas);
        }

        @Override
        public double cobrar() {
            return super.cobrar() * 1.2;
        }
        
    }

    public static class Oficinista extends Trabajadora{

        public Oficinista(String nombre, int horas) {
            super(nombre, horas);
        }

        @Override
        public double cobrar() {
           if(horas < 30) return super.cobrar() * 0.5;
            else return super.cobrar();
        }
        
    }

    public static class Transportista extends Trabajadora{

        public Transportista(String nombre, int horas) {
            super(nombre, horas);
        }

        @Override
        public void trabajar(int horas) {
            this.horas += horas;
        }
        
    }

    // B3
    public static class Cuenta{
        protected double saldo;
        protected String titular;
        protected double interes;
        protected double comision;
        protected  double comisionMes;

        public Cuenta(String titular, String numeroCuenta, double saldo, double interes, double comision, double comisionMes) {
            this.titular = titular;
            this.saldo = saldo;
            this.interes = interes;
            this.comision = comision;
            this.comisionMes = comisionMes;
        }

        public void ingresar(double cantidad){
            saldo += cantidad - comision;
        }

        public void retirar(double cantidad){
            saldo -= cantidad - comision;
        }

        public double getSaldo() {
            return saldo;
        }

        public String getTitular() {
            return titular;
        }

        public double getInteres() {
            return interes;
        }

        public double getComision() {
            return comision;
        }

        public double getComisionMes() {
            return comisionMes;
        }

        public void actualizarSaldo(){
            saldo += saldo * interes - comisionMes;
        }
    }
    
    public static class CuentaCorriente extends Cuenta{
        
        public CuentaCorriente(String titular, String numeroCuenta, double saldo) {
            super(titular, numeroCuenta, saldo, 0.01, 1, 5);
        }

        @Override        public void retirar(double cantidad) {
            if(saldo - cantidad < 0) return;
            super.retirar(cantidad);
        }
    }
    
    public static class CuentaAhorro extends Cuenta{

        private int movimientos;
        
        public CuentaAhorro(String titular, String numeroCuenta, double saldo) {
            super(titular, numeroCuenta, saldo, 0.1, 0, 0);
            movimientos = 3;
        }
        
        @Override
        public void ingresar(double cantidad) {
           if(movimientos == 0) return;
           movimientos--;
            super.ingresar(cantidad);
        }

        @Override
        public void retirar(double cantidad) {
            if(movimientos == 0) return;
            movimientos--;
            super.retirar(cantidad);
        }
    }
    
    public static class CuentaPro extends Cuenta{

        public CuentaPro(String titular, String numeroCuenta, double saldo) {
            super(titular, numeroCuenta, saldo, 0, 0, 100);
        }
        
    }
    // B2
    public static void b2(String[] args) {
        Animal animal = new Animal();
        Pez pez = new Pez();
        Pajaro pajaro = new Pajaro();
        Gallo gallo = new Gallo();
        PezPayaso payaso = new PezPayaso();
        PezEspada espada = new PezEspada();
        PajaroCarpintero carpintero = new PajaroCarpintero();
        animal.cantar();
        System.out.println();
        pez.cantar();
        System.out.println();
        pajaro.cantar();
        System.out.println();
        gallo.cantar();
        System.out.println();
        payaso.cantar();
        System.out.println();
        espada.cantar();
        System.out.println();
        carpintero.cantar();
        System.out.println();
    }

    public static class Animal {
        protected void cantar() {
            System.out.print("Animal ");
        }
    }

    public static class Pajaro extends Animal {
        @Override
        protected void cantar() {
            super.cantar();
            System.out.print("Pio pio ");
        }
    }

    public static class PajaroCarpintero extends Pajaro {
        @Override
        protected void cantar() {
            super.cantar();
            System.out.print("Picomadera ");
        }
    }

    public static class Gallo extends Pajaro {
        @Override
        protected void cantar() {
            super.cantar();
            System.out.print("Quiquiriqui ");
        }
    }

    public static class Pez extends Animal {
        @Override
        protected void cantar() {
            super.cantar();
            System.out.print("Glu glu ");
        }
    }

    public static class PezPayaso extends Pez {
        @Override
        protected void cantar() {
            super.cantar();
            System.out.print("Chorprecha ");
        }
    }

    public static class PezEspada extends Pez {
        @Override
        protected void cantar() {
            super.cantar();
            System.out.print("Ríndete ");
        }
    }

    // B1

    public static class Figura {
        protected double area; // Si no es protected no se hereda

        public double area() {
            return area; // No importa el tipo de figura se devuelve area
        }

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
            calcularArea();
        }

        private void calcularArea() {
            area = Math.PI * Math.pow(radio, 2);
        }
    }

    public static class Cuadrado extends Figura {
        private double lado;

        public Cuadrado(double lado) {
            this.lado = lado;
            calcularArea();
        }

        private void calcularArea() {
            area = Math.pow(lado, 2);
        }
    }

    public static class Triangulo extends Figura {
        private double base;
        private double altura;

        public Triangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
            calcularArea();
        }

        private void calcularArea() {
            area = (base * altura) / 2;
        }
    }

    public static void B(String[] args) {
        ArrayList<Figura> figuras = new ArrayList<Figura>();
        figuras.add(new Circulo(10)); // Radio=10
        figuras.add(new Cuadrado(10)); // Lado=10
        figuras.add(new Triangulo(10, 5)); // Base=10, Altura=5;
        for (Figura f : figuras)
            System.out.println("Área: " + f.area());
    }

}
