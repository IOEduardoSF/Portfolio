using namespace std; 
#include <iostream>
#include <stdlib.h>
#include "lista.h"
#include "lista.cpp"
#include "pila.h"
#include "pila.cpp"
#include "nodos.h"


 int main (int iArgs, char *pscArg[])
 {
   //Lista de numeros flotantes
   LISTA<float> MiLista;
   NODO<float> *pnAux, *pnFinal, *pnAux2;
   int N;
   int *piArreglo, i, j, k, iAux, iLlave;
   //Revisamos los argumentos
   if (iArgs<2) {
   	cout << "Escriba el numero de Nodos que contendrá la lista: ";
   	cin >> N;
      cout << "Por default: ";
   }
   else N = atoi (pscArg[1]);
   cout << "Creamos una lista de " << N << " nodos." << endl;
   //Arreglo de numeros aleatorios
   piArreglo = new int [N];
   //Arreglo ordenado, desde 1 hasta N
   for (i=0; i<N; i++) piArreglo[i] = i + 1;
   for (i=0; i<N; i++)
   { //Se desordena todo el arreglo
     j = rand () % N;
     k = rand () % N;
     iAux = piArreglo[j];
     piArreglo[j] = piArreglo[k];
     piArreglo[k] = iAux;
   }
   //Insertamos los elementos en la lista y ordenamos
   for (i=0; i<N; i++){
   	MiLista.iInserta (MiLista.pnCrea(piArreglo[i], (float)piArreglo[i]+0.123));
   }
   
   //Se Imprime la lista desordenada.
   cout << "Lista Desordenada: \n";
   MiLista.vImprimeLlaves();
   
   //Se inicia el ordenamiento QUICKSORT
   pnAux = MiLista.pnRecorre();
   MiLista.vQuickSort(&pnAux, NULL);
   
   //MiLista.vOrdenaBurbuja ();
   //Insertamos los elementos en la lista con prioridad
   //for (i=0; i<N; i++) MiLista.iInsertaPrioridad (MiLista.pnCrea(piArreglo[i], (float)piArreglo[i]+0.123)); 
   //Se elimina el arreglo
   delete (piArreglo);
   
   //Ahora recorremos la lista.
   cout << "\n Lista Ordenada: \n";
   while (pnAux)
   { //Muestra las llaves.
     cout << "  " << pnAux->iLlave << endl;
     pnAux = pnAux->pnSig;
   }
   
   
   //Esta en orden?
   if (MiLista.iEstaEnOrden()) cout << "Lista ordenada." << endl;
   //Buscamos el dato
   iLlave = 77;   
   cout << "Se buscan los datos de la llave: " << iLlave << endl; 
   /*pnAux = MiLista.pnBuscaSecuencial (iLlave);
   if (pnAux) cout << "La llave " << iLlave << " contiene el dato: " << pnAux->Dato << endl;
   else cout << "No se encontro." << endl;*/
   
   pnAux = MiLista.pnRecorre();
   pnFinal = 0;
   pnAux = MiLista.pnBuscaBinaria(pnAux, pnFinal, iLlave);
   if(pnAux == NULL)
		cout << "\nLa llave " << iLlave << " no se encuentra en la lista." << "\n";
	else
		cout << "El número " << pnAux->iLlave << " se encuentra en la lista." << "\n";
   return (0);
 }
