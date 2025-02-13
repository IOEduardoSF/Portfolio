#include "nodos.h"
#include "pila.h"

 template <typename T>
 PILA<T>::PILA ()
 {
   pnTope = CERO;
 }
 
 template <typename T>
 void PILA<T>::vPush (NODO<T> *pnAux)
 {
   if (pnTope) pnAux->pnSig = pnTope;
   pnTope = pnAux; 
 }
 
 template <typename T>
 NODO<T> PILA<T>::pnPop ()
 {
   NODO<T> *pnAux;
   if (!pnTope) return (CERO);
   pnAux = pnTope;
   pnTope = pnAux->pnSig;
   return (pnAux);
 }
 
 template <typename T>
 int PILA<T>::iIsEmpty ()
 {
   if (!pnTope) return (TRUE);
   return (FALSE);
 }