using namespace std; 
#include <iostream>
#include <stdlib.h>
#include "lista.h"
#include "nodos.h"

 template <typename T>
 LISTA<T>::LISTA ()
 {
   pnI = CERO;
   pnF = CERO;
 }
 
 template <typename T>
 LISTA<T>::~LISTA ()
 {
   vEliminaLista ();
 }
 
 template <typename T>
 NODO<T> *LISTA<T>::pnCrea (int iLlave, T Dato)
 {
   NODO<T> *pnAux;
   pnAux = new NODO<T> (iLlave, Dato);
   pnAux->iLlave = iLlave;
   pnAux->Dato = Dato;
   return (pnAux);
 }
 
// template <typename T>
// void LISTA<T>::vElimina (int iLlave, T Dato)
 
 template <typename T>
 int LISTA<T>::iInserta (NODO<T> *pnAux)
 {
   if (!pnAux) return (FALSE);
   if (!pnI) pnF = pnAux;
   else pnI->pnAnt = pnAux;
   pnAux->pnSig = pnI;
   pnI = pnAux; 
   pnC = pnI;  
   return (TRUE);
 }
 
 template <typename T>
 int LISTA<T>::iInsertaPrioridad (NODO<T> *pnAux)
 {
   NODO<T> *pnR, *pnIns=CERO;
   if (!pnAux) return (FALSE);
   if (!pnI)
   {
     pnI = pnAux;
     pnF = pnAux;
     pnC = pnI;
     return (TRUE);
   }
   pnR = pnI;
   while (pnR)
   {
     if (pnR->iLlave>pnAux->iLlave) { pnIns = pnR;  pnR = CERO; }
     else pnR = pnR->pnSig;
   }
   if (pnIns) return (iInsertaAntes(pnIns, pnAux)); 
   else 
   {     
     pnF->pnSig = pnAux;
     pnAux->pnAnt = pnF;
     pnF = pnAux;
   }
   pnC = pnI;
   return (TRUE);
 }
 
 template <typename T>
 NODO<T> *LISTA<T>::pnExtraer ()
 {
   NODO<T> *pnAux;
   if (!pnF) return (CERO);
   pnAux = pnF;
   pnF = pnAux->pnAnt;
   if (!pnF) pnI = CERO;
   pnAux->pnSig = CERO;
   pnAux->pnAnt = CERO;
   pnC = pnI;
   return (pnAux);
 }
 
 template <typename T>
 void LISTA<T>::vIniciaRecorrido ()
 {
   pnC = pnI;
 }
 
 template <typename T>
 NODO<T> *LISTA<T>::pnRecorre ()
 {
   NODO<T> *pnAux;
   if (!pnC) 
   {
     pnC = pnI;
     return (CERO);
   }
   pnAux = pnC;
   pnC = pnC->pnSig;
   return (pnAux);
 }

 template <typename T>
 NODO<T> *LISTA<T>::pnBuscaSecuencial (int iLlave)
 {
   NODO<T> *pnAux;
   for (pnAux=pnI; pnAux; pnAux=pnAux->pnSig)
   {
     if (pnAux->iLlave==iLlave) return (pnAux);
   }
   return (CERO);
 }
 
 template <typename T>
 NODO<T> *LISTA<T>::pnBuscaBinaria (NODO <T> *pnIn, NODO <T> *pnFinal, int iLlave){
 		NODO <T> *pnMitad, *pnInicio, *pnFin, *pnAuxFin;
		pnInicio = pnIn;
		pnAuxFin = pnFinal;
		
		if(pnAuxFin != pnInicio){
			if(pnInicio == NULL)
 				return NULL;
	 		pnMitad = pnInicio;
	 		pnFin = pnInicio->pnSig;
			while (pnFin != pnAuxFin){
				pnFin = pnFin->pnSig;
				if(pnFin != pnAuxFin){
					pnMitad = pnMitad->pnSig;
					pnFin = pnFin->pnSig;
				}
			}
			if(pnMitad == NULL)
				return NULL;
			if(pnMitad->iLlave == iLlave)
				return pnMitad;
			else if(pnMitad->iLlave < iLlave)
				return pnBuscaBinaria(pnMitad->pnSig, pnFinal, iLlave);
			else
				return pnBuscaBinaria(pnInicio, pnMitad, iLlave);
		}
		return NULL;
 }
 
 template <typename T>
 void LISTA<T>::vOrdenaBurbuja ()
 {
   NODO<T> *pnAux1, *pnAux2, *pnSig;
   for (pnAux1=pnI; pnAux1; pnAux1=pnAux1->pnSig)
   {
     for (pnAux2=pnI; pnAux2; pnAux2=pnAux2->pnSig)
     {
       pnSig = pnAux2->pnSig;
       if (pnSig)
       {
         if (pnAux2->iLlave>pnSig->iLlave) 
         {
           iIntercambia (pnAux2, pnSig);
           if (pnAux2==pnAux1) pnAux1 = pnSig;
           pnAux2 = pnSig;
         } 
       }
     }
   } 
 }
 
 template <typename T>
 void LISTA<T>::vQuickSort (NODO <T> **pnIn, NODO <T> *pnFinal){
 	NODO <T> *a, *A, *pnPivote, *pnAux;
 	bool flag;
 	a = (*pnIn);
 	pnPivote = (*pnIn);
 	if((*pnIn) == pnFinal)
 		return;
 	while(a->pnSig != pnFinal){
 		if((a->pnSig)->iLlave < pnPivote->iLlave){
 			A = (*pnIn);
 			*pnIn = a->pnSig;
 			A->pnAnt = (*pnIn);
 			a->pnSig = (a->pnSig)->pnSig;
 			(*pnIn)->pnSig = A;
 			(*pnIn)->pnAnt = NULL;
 		}
 		else
 			a = a->pnSig;
 	}
 	vQuickSort(pnIn, pnPivote);
 	vQuickSort(&(pnPivote->pnSig), pnFinal);
 	
 	
 }
 
 template <typename T>
 int LISTA<T>::iIntercambia (NODO<T> *pnA, NODO<T> *pnB)
 {
   NODO<T> *pnAA, *pnAS, *pnBA, *pnBS;
   if ((!pnA)||(!pnB)) return (FALSE);
   if ((pnA->pnSig!=pnB)&&(pnB->pnSig!=pnA))
   {
     pnAA = pnA->pnAnt;
     pnAS = pnA->pnSig;
     pnBA = pnB->pnAnt;
     pnBS = pnB->pnSig;   
     if (pnAA) pnAA->pnSig = pnB;
     else pnI = pnB;
     pnB->pnAnt = pnAA;
     if (pnAS) pnAS->pnAnt = pnB;
     else pnF = pnB;
     pnB->pnSig = pnAS;   
     if (pnBA) pnBA->pnSig = pnA;
     else pnI = pnA;
     pnA->pnAnt = pnBA;
     if (pnBS) pnBS->pnAnt = pnA;
     else pnF = pnA;
     pnA->pnSig = pnBS;
     pnC = pnI;
   }
   else
   {
     if (pnA->pnSig==pnB)
     {
       pnAA = pnA->pnAnt;
       pnBS = pnB->pnSig;
       if (pnAA) pnAA->pnSig = pnB;
       else pnI = pnB;
       pnB->pnAnt = pnAA;
       if (pnBS) pnBS->pnAnt = pnA;
       else pnF = pnA;
       pnA->pnSig = pnBS;
       pnA->pnAnt = pnB;
       pnB->pnSig = pnA;
     }
     else
     {
       pnBA = pnB->pnAnt;
       pnAS = pnA->pnSig;
       if (pnBA) pnBA->pnSig = pnA;
       else pnI = pnA;
       pnA->pnAnt = pnBA;
       if (pnAS) pnAS->pnAnt = pnB;
       else pnF = pnB;
       pnB->pnSig = pnAS;
       pnA->pnSig = pnB;
       pnB->pnAnt = pnA;
     }
   }
   return (TRUE);
 }
 
 template <typename T>
 void LISTA<T>::vEliminaLista ()
 {
   NODO<T> *pnAux;
   pnF = CERO;
   pnC = CERO;
   pnAux = pnI;
   while (!pnAux)
   {
     pnI = pnI->pnSig;
     delete (pnAux);
     pnAux = pnI;
   }
 }
 
 template <typename T>
 int LISTA<T>::iInsertaAntes (NODO<T> *pnA, NODO<T> *pnAux)
 {
   NODO<T> *pnAA;
   if ((!pnA)||(!pnAux)) return (FALSE);
   pnAA = pnA->pnAnt;
   if (pnAA) pnAA->pnSig = pnAux;
   else pnI = pnAux;
   pnAux->pnAnt = pnAA;
   pnA->pnAnt = pnAux;
   pnAux->pnSig = pnA; 
   pnC = pnI;
   return (TRUE);   
 }
 
 template <typename T>
 int LISTA<T>::iInsertaDespues (NODO<T> *pnA, NODO<T> *pnAux)
 {
   NODO<T> *pnAS;
   if ((!pnA)||(!pnAux)) return (FALSE);
   pnAS = pnA->pnSig;
   if (pnAS) pnAS->pnAnt = pnAux;
   else pnF = pnAux;
   pnAux->pnSig = pnAS;
   pnA->pnSig = pnAux;
   pnAux->pnAnt = pnA;
   pnC = pnI;
   return (TRUE);
 }
 
 template <typename T>
 NODO<T> *LISTA<T>::pnExtraeNodo (NODO<T> *pnA)
 {
   NODO<T> *pnAA, *pnAS;
   pnAA = pnA->pnAnt;
   pnAS = pnA->pnSig;
   if (pnAA) pnAA->pnSig = pnAS;
   else pnI = pnAS;
   if (pnAS) pnAS->pnAnt = pnAA;
   else pnF = pnAA; 
   pnA->pnSig = CERO;
   pnA->pnAnt = CERO;
   pnC = pnI;
   return (pnA);
 }
 
 template <typename T>
 int LISTA<T>::iEstaEnOrden ()
 {
   NODO<T> *pnR, *pnAux;
   int iFlag=TRUE;
   if (!pnI) return (TRUE);
   pnAux = pnI;
   pnR = pnI->pnSig;
   while (pnR)
   {
     if (pnAux->iLlave>pnR->iLlave) 
     {
       iFlag = FALSE;
       pnR = CERO;
     }
     else 
     {
       pnAux = pnR;
       pnR = pnR->pnSig;
     }
   }
   return (iFlag);
 }
 
 template <typename T>
 void LISTA<T>::vImprimeLlaves ()
 {
   NODO<T> *pnAux;
   pnAux = pnI;
   while (pnAux)
   {
     cout << pnAux->iLlave << " ";
     pnAux = pnAux->pnSig;
   }
   cout << endl;
 }
 

 
