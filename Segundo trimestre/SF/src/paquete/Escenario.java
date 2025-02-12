package paquete;

public class Escenario {
    private String nom;

    //Constructor
    public Escenario(String nom){
        this.nom = nom;
    }

    //Anuncia la pelea con todos los nombres
    private void anunciar(String l1, String l2){
        System.out.println(l1 +" Pelea contra " + l2 + " en " + this.nom);
    }

    //Desarrolla un round entre dos luchadores
    //Tira una excepcion si se interrumpe el hilo con la funcion de sleep
    public boolean desarrollarRound(Luchador l1, Luchador l2) throws InterruptedException {
        //Variable para saber de quien es el turno
        boolean turno = true;
        int aux;

        while (true){
            //Dependiendo de quien sea el turno, se elige a un luchador u otro para golpear y ser golpeado
            aux = (turno ?  l1 : l2).golpear();
            System.out.printf("%s golpea a %s",
            turno ? l1.getNom() : l2.getNom(),
            turno ? l2.getNom() : l1.getNom()
            );
            //Si el golpe es menor que 10, se añade un 0 delante para que no se vea feo
            System.out.print( " con una intensidad de " + (aux <= 9 ? "0"+aux : aux)+ "\t" );
            (turno ?  l2 : l1).serGolpeado(aux);
            System.out.println(l1.getNom() + ":" + l1.getVida()  + "|" + l2.getNom() + ":" + l2.getVida());
            //Si la vida de uno de los luchadores es menor o igual a 0, se acaba el round
            if((turno ?  l2 : l1).getVida() <= 0){
                break;
            }
            Thread.sleep(1000);

            //Se cambia el turno
            turno = !turno;
        };
        //Ya que solo se puede ganar cuando es su turno, el turno nos indica al ganador
        System.out.println((turno ? l1 : l2).getNom() + " ha ganado el round");
        return turno;
    }

    //Desarrolla la pelea entre dos luchadores
    public Luchador desarrollarPelea(Luchador l1, Luchador l2) throws InterruptedException {
        //Variable para guardar al ganador
        Luchador lGanador;
        //Variable para saber cuantos rounds ha ganado el luchador 1
        int r = 0;

        this.anunciar(l1.getNom(), l2.getNom());
        for(int i = 1; i <= 3; i++){
            //Si el luchador 1 ha ganado 2 rounds o no ha ganado ninguno de los 2 primeros osea, el luchador 2 ha ganado 2 rounds, se acaba la pelea
            if(r == 2 || (i == 3 && r == 0)) break;
            System.out.println("Round " + i);

            //Si el luchador 1 ha ganado el round, se suma 1 a la variable r
           if(this.desarrollarRound(l1, l2)) r++;

            //Se reinicia la vida de los luchadores
            l1.finRound();
            l2.finRound();
        }
        //El luchador ganador es el que ha ganado 2 rounds dependiendo de cuantos rounds haya ganado el luchador 1
        lGanador = (r == 2) ? l1 : l2;
        System.out.println(lGanador.getNom() + " ha ganado la pelea");
        lGanador.msgVictoria(((r == 2) ? l2.getNom() : l1.getNom()));

        return lGanador;
    }

}
