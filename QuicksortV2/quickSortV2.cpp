#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

typedef struct NODO nodo;
struct NODO{
	int iDato;
	nodo *pnSig;
	nodo *pnAnt;
};

typedef struct NODOP nodoP;
struct NODOP{
	nodo *pnInicio;
	nodo *pnFinal;
	nodoP *pnSig;
};

class PILA{
	private:
	nodoP *pnTope;
	
	public:
	PILA(){
		pnTope = 0;
	}
	
	nodoP *pnTopePila(){
		return pnTope;
	}
	
	void PUSH (nodoP *E){
		int i = 0;
		if(pnTope == 0)
			pnTope = E;
		else{
			E->pnSig = pnTope;
			pnTope = E;
		}
	}
	
	nodoP *POP (){
		nodoP *pnAux;
		if (pnTope == 0) 
		   return (0);
      pnAux = pnTope;
      pnTope = pnAux->pnSig;
      pnAux->pnSig = 0;
      return pnAux;
	}
	
	bool isEmpty(){
		if (pnTope = 0)
			return true;
		else
			return false;
	}
	
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
	
	nodo *pnCrearNodo(int iDato){
		nodo *E;
		E = new nodo;
		E->iDato = iDato;
		E->pnSig = 0;
		E->pnAnt = 0;
		return E;
	}
	
	nodoP *pnCrearNodoP(nodo *Inicio, nodo *Final){
		nodoP *E;
		E = new nodoP;
		E->pnInicio = Inicio;
		E->pnFinal = Final;
		E->pnSig = 0;
		return E;
	}
	
	void iInsertar(nodo *E){
		if(!pnLista)
			pnLista = E;
		else{
			E->pnSig = pnLista;
			pnLista->pnAnt = E;
			pnLista = E;
		}
		pnContador = pnLista;
	}
	
	int iInsertarAP(nodo *pivote, nodo * E){
		if(!pivote->pnAnt)
			pnLista = E;
		else
			(pivote->pnAnt)->pnSig = E;
		E->pnSig = pivote;
		E->pnAnt = pivote->pnAnt;
		pivote->pnAnt = E;
	}
	
	void FinLista(){
		pnFinal = pnLista;
		while(pnFinal->pnSig)
			pnFinal = pnFinal->pnSig;
	}
	
	void setInicio(nodo *pnLista){
		this->pnLista = pnLista;
	}
	
	nodo *getInicio(){
		return pnLista;
	}
	
	void setFinal(nodo *pnFinal){
		this->pnFinal = pnFinal;
	}
	
	nodo *getFinal(){
		return pnFinal;
	}
	
	nodo *pnExtraer(nodo *E){
		if(!E->pnAnt)
			pnLista = E->pnSig;
		else
			(E->pnAnt)->pnSig = E->pnSig;
		if(E->pnSig)
			(E->pnSig)->pnAnt = E->pnAnt;
		else
			pnFinal = E->pnAnt;
		E->pnSig = 0;
		E->pnAnt = 0;
		return E;		
	}
	
	void printList(){
		nodo *pnAux;
		pnAux = pnLista;
		while(pnAux){
			cout << pnAux->iDato << "\n";
			pnAux = pnAux->pnSig;
		}
	}
	
	void printFila(nodo *pnFila){
		while(pnFila){
			cout << pnFila->iDato << "\n";
			pnFila = pnFila->pnSig;
		}
	}
};

class QUICKSORT{
	private:
		PILA Pila;
		FILA Fila;
	public:
		QUICKSORT(){
		}
		
		void quickSort(nodo **pnFila){
		nodo *pnAux, *Inicio, *Fin, *Ext, *fila, *pivote, *a, *A;
		nodoP *puntero;
		bool flag;
		Inicio = *pnFila;
		
		if(Inicio){
			Fila.setInicio(Inicio);
			Fila.FinLista();
			Fin = Fila.getFinal();
			puntero = Fila.pnCrearNodoP(Inicio, Fin);
			Pila.PUSH(puntero);
			while(Pila.pnTopePila() != NULL){
				puntero = Pila.POP();
				fila = puntero->pnInicio;
				Fin = puntero->pnFinal;
				pivote = fila;
				a = fila->pnSig;
				A = Fin;
				if(fila->pnSig)
					flag = true;
				else
					flag = false;
				
				while(flag){
					while(a->iDato < pivote->iDato && a != Fin)
						a = a->pnSig;
					while(A->iDato >= pivote->iDato && A != fila)
						A = A->pnAnt;
					if(A != pivote && A->pnSig != a && a->iDato >= pivote->iDato){
						if(A == Fin)
							Fin = a;
						if(a->pnSig == A){
							a->pnSig = A->pnSig;
							if(A->pnSig)
								(A->pnSig)->pnAnt = a;
							A->pnAnt = a->pnAnt;
							(a->pnAnt)->pnSig = A;
							A->pnSig = a;
							a->pnAnt = A;
						}
						else{
							pnAux = a->pnSig;
							a = Fila.pnExtraer(a);
							Fila.iInsertarAP(A, a);
							A = Fila.pnExtraer(A);
							Fila.iInsertarAP(pnAux, A);
							A = a;
							a = pnAux->pnAnt;
						}
					}
					else
						flag = false;
					if(A->pnSig == a && pivote != A){
						fila = fila->pnSig;
						pivote = Fila.pnExtraer(pivote);
						Fila.iInsertarAP(a, pivote);
						flag = false;
					}
					else{
						if(a == Fin && a->iDato < pivote->iDato){
						fila = fila->pnSig;
						pivote = Fila.pnExtraer(pivote);
						pivote->pnSig = Fin->pnSig;
						if(Fin->pnSig)
							(Fin->pnSig)->pnAnt = pivote;
						Fin->pnSig = pivote;
						pivote->pnAnt = Fin;
						Fin = pivote;
						} 
					}
				}
				
				if(fila != Fin){
					if(fila->pnSig != Fin){
						if(pivote != fila){
							puntero = Fila.pnCrearNodoP(fila, pivote->pnAnt);
							Pila.PUSH(puntero);
						}
						if(pivote != Fin){
							puntero = Fila.pnCrearNodoP(pivote->pnSig, Fin);
							Pila.PUSH(puntero);
						}
					}
				}
			}
		}
		*pnFila = Fila.getInicio();
	}
};

class RANDOM_NUMBER{
	
	public:
	RANDOM_NUMBER(){
	}
	int randomNumber(){
		int randomN = rand()%10000000;
		return randomN;
	}
};

int main(){
	FILA fila;
	QUICKSORT QuickSort;
	RANDOM_NUMBER aleatorioN;
	
	nodo *pnAux, *pnFila, *E;
	int i, N, nNodos, start, stop;
	cout << "Escriba el número de elementos que tendrá la fila: " << "\n";
	cin >> nNodos;
	cout << "\n";
	srand(time(NULL));
	for(i = 0; i < nNodos; i++){
		N = aleatorioN.randomNumber();
		pnAux = fila.pnCrearNodo(N);
		fila.iInsertar(pnAux);
	}
	
	/*cout << "Fila Desordenada: " << "\n";
	fila.printList();*/
	
	pnFila = fila.getInicio();
	start = clock();
	QuickSort.quickSort(&pnFila);
	stop = clock();
	/*cout << "\nFila Ordenada: " << "\n";
	fila.printFila(pnFila);*/
	cout << "Tiempo que tardó en ordenar la fila: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
}
