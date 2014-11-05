package pruebamochila;

/**
 *
 * @author Jeffrey
 */
public class Algoritmo {
    
	private static final double uniformRate = 0.5;
	private static final double mutationRate = 0.015;
	private static final int tamanoTorneo = 5;
	private static final boolean elegido = true;

	//Evolucionar una poblacion
	public static Poblacion evolicionarPoblacion(Poblacion pop){
		Poblacion nuevaPoblacion = new Poblacion(pop.size(), false);

		// el mejor individuo
		if (elegido){
			nuevaPoblacion.guardarIndividuo(0, pop.getFittest());
		}

		//cruce
		int encenderBit;
		if (elegido){
			encenderBit = 1;
		} else{
			encenderBit = 0;
		}
		//cruce
		for (int i = encenderBit; i < pop.size(); i++){
			Individuo indiv1 = seleccionPorTorneo(pop);
			Individuo indiv2 = seleccionPorTorneo(pop);
			Individuo nuevoIndividuo = cruce(indiv1, indiv2);
			nuevaPoblacion.guardarIndividuo(i, nuevoIndividuo);
		}

		// mutacion de la poblacion
		for (int i = encenderBit; i < nuevaPoblacion.size(); i++){
			mutar(nuevaPoblacion.getIndividuo(i));
		}
		return nuevaPoblacion;
	}

	// cruce de individuos
	private static Individuo cruce(Individuo indiv1, Individuo indiv2){
		Individuo nuevaSolucion = new Individuo();
		// sobre los genes
		for (int i = 0; i < indiv1.size(); i++){
			// cruce
			if (Math.random() <= uniformRate){
				nuevaSolucion.setGene(i, indiv1.getGene(i));
			} else{
				nuevaSolucion.setGene(i, indiv2.getGene(i));
			}
		}
		return nuevaSolucion;
	}

	// mutar un individuo
	private static void mutar(Individuo indiv){
		// sobre los genes
		for (int i = 0; i < indiv.size(); i++){
			if (Math.random() <= mutationRate){
				// genes aleatorios
				byte gene = (byte) Math.round(Math.random());
				indiv.setGene(i, gene);
			}
		}
	}

	// Seleccionar los individuos por torneo
	private static Individuo seleccionPorTorneo(Poblacion pop){
		// crear el torneo
		Poblacion torneo = new Poblacion(tamanoTorneo, false);
		// se consigue un nuevo individuo aleatoriamente
		for (int i = 0; i < tamanoTorneo; i++){
			int randomId = (int) (Math.random() * pop.size());
			torneo.guardarIndividuo(i, pop.getIndividuo(randomId));
		}
		// tomar al mas apto
		Individuo fittest = torneo.getFittest();
		return fittest;
	} 
}
