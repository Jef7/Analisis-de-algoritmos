#Analisis de algoritmos

##Jeffrey Camareno Fonseca

#Problema de la mochila

1. la mochila tiene atributos de  capacidad maxima 
2. y tenemos una lista de  items 0,1...n-1
3. cada item tiene un peso dado
4. y tiene una ganancia cada item
5. la pregunta seria: cual es el maximo de ganancia que puedo tener en la mochila
6. vamos a tener una ganancia todal
7. hay restriccion que, no puedo pasarme de la cantidad maxima que soporta la mochila, se representa comola sumatoria de todos los pesos 

##FUNCION OBJETIVO A MAXIMIZAR
En recursividad para usar la programacion dimanica
9. maximo de ganancia para una mochila de capacidad
10. para la recursion con objetos tiene que en instancias anteriores
11. si inserto un nuevo item en la  maleta optengo una ganancia G[i] (donde i = item),  quiere decir que se me "genera" una nueva maleta restandole el peso del item insertado anteriormente: TamanoMochila-P[i]

#mi caso base
o mas trivial seria que tenga una maleta de capacidad 0 entonces mi maxima ganancia tambiensera 0.

##Derivacion 
conforme vaya insertando mas items a la mochila voy tomando mos subotimos anteriores para al final obtener mi ganancia maxima

-----------------------------



#Problema de Fibonacci

##caso base
es cuando mi numero natural es 0, el resulado es 0
y si el numero natural es 1, el resulbtado es 1

##Derivacion
si mi numero es mayor o igual a 2, entonces el algoritmo dice que  tomo mi indice sub i- 1, y le sumo, indice sub i-2



#compilacion
desarrollado con IDE netbeans, se adjunta el proyecto completo dividido por paquetes, por lo que se recomienda hacer una importacion del proyecto completo para poderlo ejecutar desde el IDE