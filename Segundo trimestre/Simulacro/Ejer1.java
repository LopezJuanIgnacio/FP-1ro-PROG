package simulacro;

public class Ejer1 {
    public static void main(String[] args) {
        //Declaramos variables
    	int dias = 1;
    	int jugadores = 456;
    	int votosPos = 0;
    	int muertos;
    	
    	//Primer mensaje
    	System.out.println("BIENVENIDOS AL JUEGO DEL CALAMAR");
    	
    	do {
    		//Reiniciamos la votacion
    		//Solo es necesario contar los positivos, los negativos se pueden asumir con jugadores - positivos
    		
    		votosPos = 0;
    		//Anunciamos cuantos jugadores quedan
    		System.out.println("Quedan: " + jugadores + " jugadores");
    		
    		//Hacemos un bucle para que voten
    		for(int i = 0; i < jugadores; i++) {
				//Hacemos una tirada random entre 1 y 0 para decidir que votaron
				//Si sale 1, votaron positivo
				if(((int) (Math.random() * 2)) == 1) votosPos++;
    		}
    		//Anunciamos los votos
    		System.out.println("Han votado SI: " + votosPos + " Han votado NO: " + (jugadores - votosPos));
    		//Si la mayoria voto positivo el juego termina, ergo, se sale del bucle
    		if(votosPos >= (jugadores/2)) break;
    		//Si no termina hacemos una tirada random de cuantos se mueren entre 1 y la mitad de los jugadores
    		muertos = (int) (Math.random() * ((jugadores/2) - 1) + 1);
    		jugadores -= muertos; 
    		
    		//Anunciamos los muertos
    		System.out.println("Han muerto " + muertos + " participantes!!!");
    		
    		//Aumentamos el contador de dias
    		dias++;
    		//Confirmamos si queda alguno vivo, sino se termina el juego
    	}while(jugadores > 0);
    	
    	//Anunciamos el resultado
    	System.out.println("SE ACABA EL JUEGO a los " + dias +" dias! con " + jugadores + " jugadores");
    	
    }
}
