
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Cuenta> cuentas = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static class Cuenta {
        private String nombre;
        private String cuenta;
        private double saldo;
        private double tipoDeInteres;

        public Cuenta(String nombre, String cuenta, double saldo, double tipoDeInteres) throws Exception {
            this.nombre = nombre;
            this.cuenta = cuenta;
            this.saldo = saldo;
            this.tipoDeInteres = tipoDeInteres;
        }

        public void setNombre(String nombre) throws Exception {
            if (nombre == null || nombre.isEmpty()) {
                throw new Exception("Error: El nombre no puede estar vacío.");
            }
            this.nombre = nombre;
        }

        public void setCuenta(String cuenta) throws Exception {

            if (cuenta == null || cuenta.isEmpty() || cuenta.length() <= 8 || !cuenta.matches(".*[a-zA-Z].*")
                    || !cuenta.matches(".*\\d.*")) {
                throw new Exception(
                        "Error: La cuenta debe tener más de 8 caracteres, contener al menos una letra y un número.");
            }
            this.cuenta = cuenta;
        }

        public void setSaldo(double saldo) throws Exception {

            if (saldo < 0) {
                throw new Exception("Error: Ingreso negativo");
            }
            this.saldo = saldo;
        }

        public void ingreso(double cantidad) throws Exception {
            if (cantidad <= 0) {
                throw new Exception("Error: Cantidad negativa");
            }
            this.saldo += cantidad;
        }

        public void reintegro(double cantidad) throws Exception {

            if (cantidad <= 0) {
                throw new Exception("Error: Cantidad negativa");
            }
            if (cantidad > this.saldo) {
                throw new Exception("Error: Cantidad mayor que saldo");
            }
            this.saldo -= cantidad;
        }

        public String getCuenta() {
            return cuenta;
        }

        public String getNombre() {
            return nombre;
        }

        public double getSaldo() {
            return saldo;
        }

        public double getTipoDeInteres() {
            return tipoDeInteres;
        }
    }

    public static void main(String[] args) {
        System.out.println("1. Alta de cuentas");
        System.out.println("2. Consulta de una cuenta");
        System.out.println("3. Ingresar dinero");
        System.out.println("4. Retirar dinero");
        System.out.println("5. Anular cuentas");
        System.out.println("6. Listado de cuentas");
        System.out.println("0. Salir");
        int opt = 0;
        do {
            try {
                opt = menu();

                switch (opt) {
                    case 1:
                        altaCuenta();
                        break;
                    case 2:
                        consultaCuenta();
                        break;
                    case 3:
                        ingresoDinero();
                        break;
                    case 4:
                        reintegroDinero();
                        break;
                    case 5:
                        anularCuenta();
                        break;
                    case 6:
                        listadoCuentas();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opt != 0);
    }

    public static int menu() throws Exception {
        System.out.println("Selecciona una opcion:");

        try {
            int opt = sc.nextInt();
            sc.nextLine();
            return opt;
        } catch (Exception e) {
            throw new Exception("Error: Opción no válida. Debe ser un número.");
        }
    }

    public static void altaCuenta() throws Exception {
        System.out.print("Nombre:");
        String nombre = sc.nextLine();
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("Error: El nombre no puede estar vacío.");
        }
        System.out.print("Número de cuenta: ");
        String cuenta = sc.nextLine();
        if (cuenta == null || cuenta.isEmpty() || cuenta.length() <= 8 || !cuenta.matches(".*[a-zA-Z].*")
                || !cuenta.matches(".*\\d.*")) {
            throw new Exception(
                    "Error: La cuenta debe tener más de 8 caracteres, contener al menos una letra y un número.");
        }
        System.out.print("Saldo inicial:");
        double saldo;
        try {
            saldo = sc.nextDouble();
        } catch (Exception e) {
            sc.nextLine();
            throw new Exception("Error: Ese saldo no es un número.");
        }
        if (saldo < 0) {
            throw new Exception("Error: El saldo no puede ser negativo.");
        }
        System.out.print("Tipo de interés:");
        double tipoDeInteres;
        try {
            tipoDeInteres = sc.nextDouble();
        } catch (Exception e) {
            sc.nextLine();
            throw new Exception("Error: Ese tipo de interés no es un número.");
        }
        sc.nextLine();
        if (tipoDeInteres < 0) {
            throw new Exception("Error: El tipo de interés no puede ser negativo.");
        }
        Cuenta nuevaCuenta = new Cuenta(nombre, cuenta, saldo, tipoDeInteres);
        cuentas.add(nuevaCuenta);
        System.out.println("Cuenta creada exitosamente.");

    }

    public static void consultaCuenta() throws Exception {
        System.out.print("Número de cuenta: ");
        String cuenta = sc.nextLine();
        boolean encontrado = false;
        for (Cuenta c : cuentas) {
            if (c.getCuenta().equals(cuenta)) {
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Número de cuenta: " + c.getCuenta());
                System.out.println("Saldo: " + c.getSaldo());
                System.out.println("Tipo de interés: " + c.getTipoDeInteres());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: Cuenta no encontrada.");
        }

    }

    public static void ingresoDinero() throws Exception {
        System.out.print("Número de cuenta: ");
        String cuenta = sc.nextLine();
        boolean encontrado = false;
        for (Cuenta c : cuentas) {
            if (c.getCuenta().equals(cuenta)) {
                System.out.print("Cantidad a ingresar: ");
                double cantidad;
                try {
                    cantidad = sc.nextDouble();
                } catch (Exception e) {
                    sc.nextLine();
                    throw new Exception("Error: Esa cantidad no es un número.");
                }
                c.ingreso(cantidad);
                System.out.println("Ingreso realizado exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: Cuenta no encontrada.");
        }

    }

    public static void reintegroDinero() throws Exception {
        System.out.print("Número de cuenta: ");
        String cuenta = sc.nextLine();
        boolean encontrado = false;
        for (Cuenta c : cuentas) {
            if (c.getCuenta().equals(cuenta)) {
                System.out.print("Cantidad a retirar: ");
                double cantidad;
                try {
                    cantidad = sc.nextDouble();
                } catch (Exception e) {
                    sc.nextLine();
                    throw new Exception("Error: Esa cantidad no es un número.");
                }
                c.reintegro(cantidad);
                System.out.println("Reintegro realizado exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: Cuenta no encontrada.");
        }

    }

    public static void anularCuenta() throws Exception {
        System.out.print("Número de cuenta: ");
        String cuenta = sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getCuenta().equals(cuenta)) {
                cuentas.remove(i);
                System.out.println("Cuenta anulada exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: Cuenta no encontrada.");
        }

    }

    public static void listadoCuentas() throws Exception {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            for (Cuenta c : cuentas) {

                System.out.println("********************");
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Número de cuenta: " + c.getCuenta());
                System.out.println("Saldo: " + c.getSaldo());
                System.out.println("Tipo de interés: " + c.getTipoDeInteres());
                System.out.println("********************");
            }
        }
    }

}
