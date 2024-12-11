package paquete;

public class Combatiente {
	private int vida;
	private String Nombre;
	private int ataque;
	private int defensa;

	public Combatiente(String Nombre, int ataque, int defensa) {
		this.vida = 150;
		this.Nombre = Nombre;
		this.ataque = ataque;                                                                	
        this.defensa = defensa;
	}

	public int getVida() {
		return this.vida;
	}
	public static int d20()  {
        return (int) (Math.random() * 20 + 1);
    }
	public String getNombre() {
		return this.Nombre;
	}
	public int Atacar() {
		int d = d20();
        int num = d * this.ataque;
        System.out.println(this.Nombre + " ataca con " + num + " de daño");
		return num;
	}
    public boolean RecibirAtaque(int ataque) {
		double d = (double) (d20() + this.defensa);
		d = d > 20 ? 20 : d;
        int num = (int) (ataque - ( ataque *  (d/20)));
        System.out.println(this.Nombre + " recibe " + num + " de daño");
        this.vida -= num;
        if(this.vida <= 0) {
            System.out.println(this.Nombre + " ha muerto");
            return true;
        }
        return false;
    }
}
