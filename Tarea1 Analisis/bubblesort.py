#Bubble sort
# mientras la lista no este ordenada:
#	para cada indice en la lista:
# 		si el elemento en i es mayor al elemento i+1
#		 invierta los elemnts en i y i+1
#			al llegar al final, marque el ultimo elemento como fijo

import time
import random

lista = []
for i in range(1,100000):
	numero = int(random.uniform(0,500))
	lista.append(numero)

def bubblesort(lista):
	
	hastadondellegar = len(lista)-1

	while hastadondellegar != 0:
		for i in range(0,hastadondellegar):
			if lista[i] > lista[i+1]:
				temp = lista[i]
				lista[i] = lista[i+1]
				lista[i+1] = temp
		hastadondellegar-= 1	
	return lista
	
t0 = time.clock() #tiempo inicial
print(bubblesort(lista))
print "%.2f sec" % (time.clock() - t0) #tiempo final




