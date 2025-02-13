#include "nodos.h"

//En este caso, para una lista de prioridad, suponemos que las "llaves menores"
//estan al inicio (pnI), mientras que las "llaves mayores" estan al final (pnF).

#ifndef CLASS_LISTA
 #define CLASS_LISTA
 template <class T>
 class LISTA
 {
   private:
   NODO<T> *pnI;  //Se insertan nodos al inicio
   NODO<T> *pnF;  //Se extraen nodos al final
   NODO<T> *pnC;  //Contador de recorrido
   public:
   LISTA ();  //Constructor
   ~LISTA ();  //Destructor
   NODO<T> *pnCrea (int iLlave, T Dato);  //Crea un nodo
   int iInserta (NODO<T> *pnAux);  //Inserta un nodo al inicio
   int iInsertaPrioridad (NODO<T> *pnAux);  //Inserta de menor (pnI) a mayor (pnF). Orden ascendente
   NODO<T> *pnExtraer ();  //Extrae un nodo del final
   void vIniciaRecorrido ();  //Inicia el recorrido de inicio a fin
   NODO<T> *pnRecorre ();  //Recorre de inicio a fin
   NODO<T> *pnBuscaSecuencial (int iLlave);  //Realiza una busqueda secuencial por Llave
   NODO<T> *pnBuscaBinaria (NODO <T> *pnI, NODO<T> *pnFinal, int iLlave);  //Realiza una busqueda binaria
   void vOrdenaBurbuja ();  //Bubble Sort
   void vQuickSort (NODO <T> **pnIn, NODO <T> *pnFinal);  //QuickSort
   
   //Estos son algunos metodos para operaciones
   int iIntercambia (NODO<T> *pnA, NODO<T> *pnB);  //Intercambia los nodos en la lista
   void vEliminaLista ();  //Elimina todos los elementos de la lista
   int iInsertaAntes (NODO<T> *pnA, NODO<T> *pnAux);  //Inserta Aux antes de A
   int iInsertaDespues (NODO<T> *pnA, NODO<T> *pnAux);  //Inserta Aux despues de A
   NODO<T> *pnExtraeNodo (NODO<T> *pnA);  //Extrae el nodo A de la lista
   int iEstaEnOrden ();  //Determina si la lista esta en orden ascendente (con respecto a la llave)
   void vImprimeLlaves ();  //Imprime las llaves de la lista
   
 };
#endif
