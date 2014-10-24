/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package porgramaciondinamica.mochila;

/**
 *
 * @author Jeffrey
 */
public class Mochila {
        int Peso []; // pesos de cada item de arreglo
        int Ganancia []; // gancia de cada item de arreglo
        int TamanoMochila; // capacidad maxima items de la mochila
        
        Mochila(int [] Peso, int [] Ganancia, int TamanoMochila ){        
            this.Peso = Peso;
            this.Ganancia = Ganancia;
            this.TamanoMochila = TamanoMochila;
        }
        
        public int [] getPeso(){
        return this.Peso;
        }
        
        public int [] getGanancia(){
            return this.Ganancia;
        }
        
        public int getTamanoMochila(){
            return this.TamanoMochila;        
        }         
}
