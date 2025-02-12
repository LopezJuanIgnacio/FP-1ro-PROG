package paquete;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Declaramos a los luchadores
        Luchador jefe = new Luchador("Mr. Bison", "%s, No vales ni para ser Youtuber");
        Luchador luchador1 = new Luchador("Ryu", "%s, Pensaba que eras mas fuerte coleguilla");
        Luchador luchador2 = new Luchador("Ken", "No es una rivalidad si te viven apalizando, %s");

        //Declaramos los escenarios
        Escenario e1 = new Escenario("Templo de Pekin");
        Escenario e2 = new Escenario("Bison Mansion");
        
        //Desarrollar pelea devuelve al ganador, por lo que podemos hacer una pelea entre el ganador de la pelea anterior y el jefe
        e2.desarrollarPelea(jefe, e1.desarrollarPelea(luchador1, luchador2));
    }
}
