package pruebamochila;
/**
 *
 * @author Jeffrey
 */
public class Main {
	public static void main(String[] args){
            Individuo.setLargoPorDefectoGen(5);
            
            //Crear una poblacion inicial
            Poblacion myPop = new Poblacion(4, true);

            //Evolucionar la poblacion hasta alcanzar el optimo
            int cuentaDeGeneraciones = 0;
            for (int i=0; i<10; i++){
                    cuentaDeGeneraciones ++;
                    System.out.println("Generacion: " + cuentaDeGeneraciones + " Fittest: "
                                    + myPop.getFittest().getFitness());
                    myPop = Algoritmo.evolicionarPoblacion(myPop);
            }
            System.out.println("Generacion: " + cuentaDeGeneraciones);
            System.out.println("Genes: "+ myPop.getFittest());
	}  
}


