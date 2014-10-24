package porgramaciondinamica.Fibonacci;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.Arrays;
import porgramaciondinamica.mochila.Mochila;

/**
 *
 * @author Jeffrey
 */
public class Main {
    
    public static void main(String[] args) {
        int numeroNatural = 5;
        int [] tabla = new int [numeroNatural+1];   
 
        System.out.println(Fibonacci(numeroNatural, tabla));         
    }
    
    static int  Fibonacci (int numeroNatural, int [] tabla){
        if (numeroNatural == 0){
                return 0;
        }
        else if (numeroNatural == 1){
            return 1;
        }
        else 
            tabla[0] = 0;
            tabla[1] = 1;
            
            for (int i=2; i < numeroNatural+1; i++){
                tabla[i] = tabla[i-1] + tabla [i-2];         
                
            }
            
            int sumatoria=0;
            for(int j=0; j<tabla.length; j++){
                sumatoria += tabla[j];
            }
            return sumatoria;   
    }   
}
