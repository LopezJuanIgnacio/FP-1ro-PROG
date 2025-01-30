package paquete;

public class main {
    public static void main(String[] args){
        Cafetera cafe1 = new Cafetera(1000);
        cafe1.llenar_cafetera();
        cafe1.servir_taza(90);
        cafe1.servir_taza(10);
        cafe1.agregar_cafe(50);
        cafe1.servir_taza(900);
        cafe1.servir_taza(1);
        cafe1.agregar_cafe(1200);
        cafe1.agregar_cafe(50);
        cafe1.vaciar_cafetera();
        cafe1.llenar_cafetera();
    }
}
