//Este archivo contiene la definicion de la clase "nodo"

#ifndef TIPO_NODO
 #define TIPO_NODO
 #define FALSE 0
 #define TRUE  1
 #define CERO  0
 
 template <class T>
 class NODO
 { //Esta clase nodo, alamacena cualquier cosa y su respectiva llave
   public:
   int iLlave;   //Para buscar en la lista
   T Dato;       //Los datos que se van a almacenar
   NODO *pnSig;
   NODO *pnAnt;
   NODO (int iL, T Dat)
   {
     iLlave = iL;
     Dato = Dat;
     pnSig = 0;
     pnAnt = 0;
   }
 };

 typedef struct DLISTA dlista;
 struct DLISTA
 { //Para almacenar en la pila el inicio y fin de la sublista
   void *pnI;
   void *pnF;
 };
 
#endif