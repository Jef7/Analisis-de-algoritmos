package pruebamochila;

/**
 *
 * @author Jeffrey
 */
public class Poblacion {
    Individuo[] individuos;

	//crear poblacion
	public Poblacion(int tamanoPoblacion, boolean inicializar){
		individuos = new Individuo[tamanoPoblacion];
		// inicializar la poblacion
		if (inicializar){
			// crear individuos
			for (int i = 0; i < size(); i++){
				Individuo nuevoIndividuo = new Individuo();
				nuevoIndividuo.generarIndividuo();
				guardarIndividuo(i, nuevoIndividuo);
			}
		}
	}

	public Individuo getIndividuo(int index){
		return individuos[index];
	}

	public Individuo getFittest(){
		Individuo fittest = individuos[0];
		// para encontar el optimo
		for (int i = 0; i < size(); i++){
			if (fittest.getFitness() <= getIndividuo(i).getFitness()){
				fittest = getIndividuo(i);
			}
		}
		return fittest;
	}

	// tamano de poblacion
	public int size(){
		return individuos.length;
	}

	// guardar individuo
	public void guardarIndividuo(int index, Individuo indiv){
		individuos[index] = indiv;
	}
}
