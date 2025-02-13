#include "nodos.h"

#ifndef CLASSNODOLISTA
 #define CLASSNODOLISTA
 template <class T>
 class PILA
 {
   private:
   NODO<T> *pnTope;
   public:
   PILA ();
   void vPush (NODO<T> *pnAux);
   NODO<T> pnPop ();
   int iIsEmpty ();
 };
#endif