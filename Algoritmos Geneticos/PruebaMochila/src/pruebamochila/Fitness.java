package pruebamochila;

/**
 *
 * @author Jeffrey
 */
public class Fitness {
    static byte[] solucion = new byte[4];
    
	public static void setSolucion(byte[] nuevaSolucion){
		solucion = nuevaSolucion;
	}
        
	// con ceros y unos
	static void setSolucion(String nuevaSolucion){
		solucion = new byte[nuevaSolucion.length()];
                
		for (int i = 0; i < nuevaSolucion.length(); i++){
			String string = nuevaSolucion.substring(i, i + 1);
			if (string.contains("0") || string.contains("1")){
				solucion[i] = Byte.parseByte(string);
			} else{
				solucion[i] = 0;
			}
		}
	}

	// comparacion de fitness de los individuos
	static int getFitness(Individuo individuo){
		int fitness = 0;
		// comparacion de fitness para cada candidato
		for (int i = 0; i < individuo.size() && i < solucion.length; i++){
			if (individuo.getGene(i) == solucion[i]){
				fitness++;
			}
		}
		return fitness;
	}

	// toma el optimo, el mas fitness
	static int getMaxFitness(){
		int maxFitness = solucion.length;
		return maxFitness;
	}   
}
