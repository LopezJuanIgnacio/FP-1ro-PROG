package paquete;

public class Luchador {
    private int vida;
    private String nom;
    private String msgVictoria;
    private int minGolpe = 1;
    private int maxGolpe = 50;

    //Constructor
    public Luchador(String nom, String msg){
        this.nom = nom;
        this.msgVictoria = msg;
        this.vida = 100;
    }

    public String getNom(){
        return this.nom;
    }

    public int getVida(){
        return this.vida;
    }

    //Devuelve un numero aleatorio entre el minimo y el maximo de golpe
    public int golpear(){
        return (int) (Math.random() * (this.maxGolpe - this.minGolpe) + this.minGolpe);
    }

    //Resta la vida del luchador, si el golpe es mayor que la vida, la vida se pone a 0
    public void serGolpeado(int golpe){
        this.vida -= ( (this.vida - golpe) <= 0 ) ? this.vida  :  golpe;
    }

    //Reinicia la vida del luchador al terminar el round
    public void finRound(){
        this.vida = 100;
    }

    //Mensaje de victoria del luchador recibiendo el nombre del enemigo
    public void msgVictoria(String enemigo){
        System.out.printf(this.msgVictoria, enemigo);
        System.out.println();
    }

}
