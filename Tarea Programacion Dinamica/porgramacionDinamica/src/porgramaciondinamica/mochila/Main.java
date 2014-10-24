/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package porgramaciondinamica.mochila;

import java.util.Arrays;

/**
 *
 * @author Jeffrey
 */
public class Main {
    
    public static void main(String[] args) {
        Mochila item = new Mochila(new int [] {3,2,4,2}, new int [] {15,9,5,10}, 8);
        System.out.println(maximaGananciaTotal(item.getPeso() ,item.getGanancia() ,item.getTamanoMochila())); //la salida es mi maxima ganancia
        System.out.println(Arrays.toString(numeroItemsTomados(item.getPeso() ,item.getGanancia() ,item.getTamanoMochila())));// la salida es un arreglo que muetra la cantidad de items tomados
        
    }
    
    
    static int maximaGananciaTotal(int Peso[], int Ganancia[], int TamanoMochila){
        //en programacion dinamica necesito guardar mis suboptimos anteriores
        
        int maximaGananciaTotal[] = new int[TamanoMochila+1]; //+1 porque se indexa en 0
        
        //resolver el caso base de una mochula con capacidad 0
        maximaGananciaTotal[0] = 0; //mi mayor ganacia sera 0 tambien
        
        for (int TamanoMochilaAux = 0; TamanoMochilaAux < maximaGananciaTotal.length; TamanoMochilaAux ++) { //cuando el tamano de todo sea menor que el tamaño de la mochila
            
            int maxGananciaAux = 0; //variable que va a ir guardando mis optimos en ganancia
            for (int item = 0; item < Peso.length; item ++) { //ciclo para verificar el item con mayor ganancia mientras este no sea mayor al tamano de la mochila
                if (TamanoMochilaAux >= Peso[item]){ //verifica que nuestro item no sea mas grande que el peso de la maleta, para que no nos genere numeros negativos en los indices
   
               //evaluo la ganancia de poner el item i en la maleta
                int gananciaAux = maximaGananciaTotal[TamanoMochilaAux-Peso[item]] + Ganancia[item]; //genera la maxima ganancia total
                if (gananciaAux > maxGananciaAux)
                    maxGananciaAux = gananciaAux; 
                }
            }
            maximaGananciaTotal[TamanoMochilaAux] = maxGananciaAux; // guardar mi nueva maxima ganancia          
        }
        return maximaGananciaTotal[TamanoMochila]; //respuesta final
    }
      
    static int[] numeroItemsTomados(int Peso[], int Ganancia[], int TamanoMochila){ //va a retornar cuantos items de cada uno esta tomando
        //para guardar las soluciones suboptimas anteriores
        int maximaGananciaTotal[] = new int[TamanoMochila+1]; //+1 porque se indexa en 0
        int decision[] = new int[TamanoMochila+1];//guardar memorizar las desiciones tomadas
        int cantidadItem[] = new int[Peso.length];//guardar cuantos items tengo de cada uno
              
        //resolver el caso base de una mochila con capacidad 0
        maximaGananciaTotal[0] = 0; //mi mayor ganacia sera 0 tambien
        
        for (int TamanoMochilaAux = 0; TamanoMochilaAux < maximaGananciaTotal.length; TamanoMochilaAux ++){ //cuando el tamano de todo sea menor que el tamaño de la mochila
            int maxGananciaAux = 0; //variable que va a ir guardando mis optimos en ganancia
            
            int itemMax = -1;//recordar en momoria cual item tiene el maximo
            for (int item = 0; item < Peso.length; item ++) { //ciclo para verificar el item con mayor ganancia mientras este no sea mayor al tamano de la mochila
                if (TamanoMochilaAux >= Peso[item]){ //verifica que nuestro item no sea mas grande que el peso de la maleta, para que no nos genere numeros negativos en los indices
   
                    //evaluo la ganancia de poner el item i en la maleta
                    int gananciaAux = maximaGananciaTotal[TamanoMochilaAux-Peso[item]] + Ganancia[item]; //genera la maxima ganancia total
                    if (gananciaAux > maxGananciaAux){
                        maxGananciaAux = gananciaAux; 
                        itemMax = item; //guarda la posicion
                    }
                }
            }    
            maximaGananciaTotal[TamanoMochilaAux] = maxGananciaAux; // guardar mi nueva maxima ganancia
            decision[TamanoMochilaAux] =  itemMax; //guarda la posicion del maximo
        }
        //ciclo de atras hacia adelante que revisa cuales desiciones tomar a partir de la respuesta
        int itemTomado = 0;
        for (int TamanoMochilaAux = TamanoMochila; TamanoMochilaAux>0 && itemTomado!=-1;){
        itemTomado = decision[TamanoMochilaAux];
        
        cantidadItem[itemTomado]++;
        
        TamanoMochilaAux = TamanoMochilaAux-Peso[itemTomado]; 
        }
        return cantidadItem; //respuesta final
    }
    
}
