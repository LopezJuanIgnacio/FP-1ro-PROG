package paquete;

public class Cafetera {
    private int capacidadMaxima;
    private int cantidadActual;

    public Cafetera(int max) {
        this.capacidadMaxima = max;
        this.cantidadActual = 0;
    }

    public void llenar_cafetera(){
        this.cantidadActual = this.capacidadMaxima;
    }

    public void servir_taza(int cant){
        if(this.cantidadActual ==0) System.out.println("La cafetera esta vacia");
        else if(cant > this.cantidadActual) {
            System.out.println("Solo puedo servir " + this.cantidadActual);
            this.vaciar_cafetera();
        }else {
            this.cantidadActual -= cant;
            System.out.println("Sirviendo taza de " + cant + "ml");
        }
    }

    public void vaciar_cafetera(){
        this.cantidadActual = 0;
    }

    public void agregar_cafe(int cant){
        if(cant + this.cantidadActual > this.capacidadMaxima) this.cantidadActual = this.capacidadMaxima; 
        else  this.cantidadActual += cant;
    }
}
