#para i=1 hasta n-1
#    minimo = i;
#    para j=i+1 hasta n
#        si lista[j] < lista[minimo] entonces
#            minimo = j /* (!) */
#        fin si
#    fin para
#    intercambiar(lista[i], lista[minimo])
#fin para

import time
import random

lista = []
for i in range(1,100000):
	numero = int(random.uniform(0,500))
	lista.append(numero)

def selectionSort(lista):
    n = len(lista)
   
    for i in range(n - 1):
        min = i
        for j in range(i + 1, n):
            if lista[j] < lista[min]:
                min = j
        if min != i:
            lista[i], lista[min] = lista[min], lista[i]
	return lista

t0 = time.clock() #tiempo inicial	
print(selectionSort(lista))
print "%.2f sec" % (time.clock() - t0)
            

