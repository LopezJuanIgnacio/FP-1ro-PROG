
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

   
    public void A() {
        ArrayList<Persona> lista = new ArrayList<>();

        lista.add(new Profesor("Juan", "Garcia", "12/12/1980", 2000, "Matematicas"));
        lista.add(new Profesor("Maria", "Lopez", "12/12/1980", 2000, "Fisica"));
        lista.add(new Profesor("Luis", "Batres", "12/12/1980", 0, "Fisica"));
        lista.add(new Alumno("Pedro", "Gomez", "12/12/1980", 8, "2º ESO"));
        lista.add(new Alumno("Ana", "Garcia", "12/12/1980", 7, "3º ESO"));
        lista.add(new Alumno("Ana", "Garcia", "12/12/1980", 7, "3º ESO"));
        lista.add(new Persona("Sofia", "Hernandez", "05/05/1990"));
        lista.add(new Persona("Miguel", "Rodriguez", "22/08/1985"));
        lista.add(new Persona("Elena", "Lopez", "30/01/1992"));

        for (Persona p : lista)
            System.out.println(p.toString());
    }

    public class Persona {
        protected String nombre;
        protected String apellidos;
        protected String fechaNacim;

        public Persona(String n, String a, String f) {
            nombre = n;
            apellidos = a;
            fechaNacim = f;
        }

        public String getApellidos() {
            return apellidos;
        }

        public String getFechaNacim() {
            return fechaNacim;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public class Profesor extends Persona {
        protected int salario;
        protected String especialidad;

        public Profesor(String nombre, String apellidos, String fechaNacim, int salario, String especialidad) {
            super(nombre, apellidos, fechaNacim);
            this.salario = salario;
            this.especialidad = especialidad;
        }

        @Override
        public String toString() {
            return super.toString() + " " + especialidad + " " + salario;
        }

        @Override
        public String getNombre() {
            return "Profesor " + super.getNombre();
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public int getSalario() {
            return salario;
        }

    }

    public class Alumno extends Persona {
        protected double notaMedia;
        protected String grupo;

        public Alumno(String nombre, String apellidos, String fechaNacim, int notaMedia, String grupo) {
            super(nombre, apellidos, fechaNacim);
            this.notaMedia = notaMedia;
            this.grupo = grupo;
        }

        @Override
        public String toString() {
            return super.toString() + " " + grupo + " " + notaMedia;
        }

        @Override
        public String getNombre() {
            return "Alumno " + super.getNombre();
        }

        public double getNotaMedia() {
            return notaMedia;
        }

        public String getGrupo() {
            return grupo;
        }
    }
}
