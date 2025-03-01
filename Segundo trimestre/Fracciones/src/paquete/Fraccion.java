package paquete;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int num, int den){
        this.denominador = den;
        this.numerador = num;
    }

    public Fraccion invertir(){
        return new Fraccion(this.denominador, this.numerador);
    }

    public void escribir_fraccion(){
        System.out.println(this.numerador + "/" + this.denominador);
    }

    public Fraccion multiplicar(Fraccion f2){
        return new Fraccion(this.numerador * f2.numerador, this.denominador * f2.denominador);
    }

    public Fraccion dividir(Fraccion f2){
        return this.multiplicar(f2.invertir());
    }
}
