package pruebamochila;

/**
 *
 * @author Jeffrey
 */
public class Individuo {
    
    	static int largoPorDefectoGen = 4;
	private byte[] genes = new byte[largoPorDefectoGen];
	// Cache
	private int fitness = 0;

	// Crear un individuo aleatorio
	public void generarIndividuo(){
		for (int i = 0; i < size(); i++){
			byte gene = (byte) Math.round(Math.random());
			genes[i] = gene;
		}
	}

	//Puede usarse para cambiar el largo por defecto
	public static void setLargoPorDefectoGen(int length){
		largoPorDefectoGen = length;
	}

	public byte getGene(int index){
		return genes[index];
	}

	public void setGene(int index, byte value){
		genes[index] = value;
		fitness = 0;
	}

	/*Metodos publicos*/
	public int size(){
		return genes.length;
	}

	public int getFitness(){
		if (fitness == 0){
                    fitness = Fitness.getFitness(this);
		}
		return fitness;
	}

	@Override
	public String toString(){
		String geneString = "";
		for (int i = 0; i < size(); i++){
			geneString += getGene(i);
		}
		return geneString;
        }  
}
