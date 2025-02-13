#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <cstdlib>
using namespace std;

typedef struct NODO nodo;
struct NODO{
	int iLlave;
	nodo *pnSig;
	nodo *pnAnt;
};

class FILA{
	private:
		nodo *pnContador;
		nodo *pnLista;
		nodo *pnFinal;
	public:
	
	FILA(){
		pnContador = 0;
		pnLista = 0;
		pnFinal = 0;
	}
	
	nodo *pnCrearNodo(int iLlave){
		nodo *E;
		E = new nodo;
		E->iLlave = iLlave;
		E->pnSig = 0;
		E->pnAnt = 0;
		return E;
	}
	
	void iInsertar(nodo *E){
		nodo *pnAux = pnLista;
		if(!pnLista)
			pnLista = E;
		else{
			E->pnSig = pnLista;
			pnAux->pnAnt = E;
			pnLista = E;
		}
		pnContador = pnLista;
	}
	
	nodo *pnRecorre(){
		nodo *pnAux;
		pnAux = pnContador;
		if(pnContador == 0)
			pnContador = pnLista;
		else
			pnContador = pnContador->pnSig;
		return(pnAux);
	}
	
	nodo *pnExtraeMezcla(nodo *pnAux, nodo** pnAux2){
		*pnAux2 = (*pnAux2)->pnSig;
		if(*pnAux2)
			(*pnAux2)->pnAnt = 0;
		pnAux->pnSig = 0;
		pnAux->pnAnt = 0;
		return pnAux;
	}
	
	void vImprimeLlaves(){
		nodo *pnAux;
		pnAux = pnLista;
		while(pnAux){
			cout << pnAux->iLlave << " ";
			pnAux = pnAux->pnSig;
		}
		cout << endl;
	}
	
	int iNumeroNodos(){
		nodo *pnAux;
		int N = 0;
		pnAux = pnLista;
		while(pnAux){
			pnAux = pnAux->pnSig;
			N += 1;
		}
		return N;
	}
	
	void vIniciaRecorrido(){
		pnContador = pnLista;
	}
	
	void nAleatorio(int N){
		nodo *E;
   	int *piArreglo, i, j, k, iAux;
		piArreglo = new int [N];
	
		for (i=0; i<N; i++) 
			piArreglo[i] = i + 1;
		for (i=0; i<N; i++){
		  j = rand () % N;
		  k = rand () % N;
		  iAux = piArreglo[j];
		  piArreglo[j] = piArreglo[k];
		  piArreglo[k] = iAux;
		}
		
		for (i=0; i<N; i++){
   		E = pnCrearNodo(piArreglo[i]);
   		iInsertar(E);
   	}
	}
	
	void iInsertarMezcla(nodo *E){
		nodo* pnAux = pnLista;
		nodo* pnAux2 = pnFinal;
		 
		if(pnLista==0){   
			pnLista = E;
		   pnFinal = E;
		 }
		 else{
		 	if(pnLista->iLlave <= pnFinal->iLlave){
				E->pnAnt = pnFinal;
				pnAux2->pnSig = E;
		      pnFinal = E;
		   }
		   else{
				E->pnSig = pnLista;
		      pnAux->pnAnt = E;
		      pnLista = E;  
		   }  
		 }
		pnContador = pnLista;
	}
	
	nodo *pnMitadFila(nodo *pnInicio, nodo *pnFin){
		nodo *pnMitad, *pnFinal;
		if(pnInicio == NULL)
 			return NULL;
 		pnMitad = pnInicio;
 		pnFinal = pnInicio->pnSig;
		while (pnFinal != pnFin){
			pnFinal = pnFinal->pnSig;
			if(pnFinal != pnFin){
				pnMitad = pnMitad->pnSig;
				pnFinal = pnFinal->pnSig;
			}
		}
		return pnMitad;
	}
	
	void iIntercambia(nodo *pnAux){
		if(pnAux->pnSig || pnAux->pnAnt){
			if(pnAux->iLlave > (pnAux->pnSig)->iLlave){
				pnAux->pnAnt = pnAux->pnSig;
				pnAux->pnSig = 0;
				(pnAux->pnAnt)->pnSig = pnAux;
				(pnAux->pnAnt)->pnAnt = 0;
				pnLista = pnAux->pnAnt;
			}
		}
	}
	
	void ordenaMitad(nodo *a, nodo *A){
		nodo *aAnt, *AAnt;
		aAnt = a;
		AAnt = A;
		while(aAnt && AAnt){
			if(aAnt->iLlave > AAnt->iLlave){
				AAnt = pnExtraeMezcla(AAnt, &A);
				iInsertarMezcla(AAnt);
			}
			else{
				aAnt = pnExtraeMezcla(aAnt, &a);
				iInsertarMezcla(aAnt);
			}
			aAnt = a;
			AAnt = A;
		}
		
		while(AAnt){
			AAnt = pnExtraeMezcla(AAnt, &A);
			iInsertarMezcla(AAnt);
			AAnt = A;
		}
		
		while(a){
			aAnt = pnExtraeMezcla(aAnt, &a);
			iInsertarMezcla(aAnt);
			aAnt = a;
		}
	}
	
	void mergeSort(int i, int N, nodo *pnAux){
		nodo *a, *A;
		a = pnAux;
		int mitad;
		
		mitad = (i + N)/2;
		
		if(i != N && i + 1 != N){
			pnAux = pnMitadFila(pnAux, NULL);
			A = pnAux->pnSig;
			pnAux->pnSig = 0;
			A->pnAnt = 0;
			mergeSort(i, mitad, a);
			mergeSort(mitad + 1, N, A);
			while(a->pnAnt != 0)
				a = a->pnAnt;
			while(A->pnAnt != 0)
				A = A->pnAnt;
			pnLista = 0;
			pnFinal = 0;
			ordenaMitad(a, A);
		}
		else
			iIntercambia(pnAux);
	}
	
	void solMergeSort(){
		nodo *pnAux = 0;
		int i = 1;
		int finFila = iNumeroNodos();
		pnAux = pnLista;
		if(0 <= finFila)
			mergeSort(i, finFila, pnAux);
	}
};

int main(){
	FILA mSort;
	int N;
        cout << "Escriba el número de elementos que tendrá la fila: ";
        cin >> N;
	mSort.nAleatorio(N);
	cout << "Fila Desordenada: \n";
	mSort.vImprimeLlaves();
	cout << endl;
	mSort.solMergeSort();
	cout << endl;
	cout << "Fila Ordenada: \n";
	mSort.vImprimeLlaves();
	cout << endl;
	return 0;
}
