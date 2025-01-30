package paquete;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int num, int den){
        this.denominador = den;
        this.numerador = num;
    }

    public int get_numerador() {
        return this.numerador;
    }

    public int get_denominador() {
        return this.denominador;
    }

    public Fraccion invertir(){
        return new Fraccion(this.denominador, this.numerador);
    }

    public void escribir_fraccion(){
        System.out.println(this.numerador + "/" + this.denominador);
    }

    public Fraccion multiplicar(Fraccion f2){
        return new Fraccion(this.numerador * f2.get_numerador(), this.denominador * f2.get_denominador());
    }

    public Fraccion dividir(Fraccion f2){
        return this.multiplicar(f2.invertir());
    }
}
