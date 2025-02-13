#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

typedef struct NODO nodo;
struct NODO{
	int iData;
	nodo *pnSig;
	nodo *pnAnt;
};

class ORDENAMIENTO_DOBLE{
	private:
		nodo *pnContador;
		nodo *pnLista;
	public:
	
	ORDENAMIENTO_DOBLE(){
	 	pnContador = 0;
		pnLista = 0;
	}
	
	nodo *pnCrearNodo(int iData){
		nodo *pnAux;
		pnAux = new nodo;
		pnAux->iData = iData;
		pnAux->pnSig = 0;
		pnAux->pnAnt = 0;
	}
	
	nodo *insercionAscendente(nodo *E){
		nodo *pnAux, *pnAux2;
		if(!pnLista){
			pnLista = E;
		}
		else{
			pnAux2 = pnLista->pnAnt;
			pnAux = pnLista;
			while (pnAux != 0 && E->iData > pnAux->iData){
				pnAux2 = pnAux;
				pnAux = pnAux->pnSig;
			}
			if(pnAux2 != 0){
				pnAux2->pnSig = E;
			}
			else{
				pnLista = E;
			}
			E->pnAnt = pnAux2;
			if (pnAux != 0){
				pnAux->pnAnt = E;
			}
			E->pnSig = pnAux;
		}
		pnContador = pnLista;
		return pnLista;
	}
	
	nodo *insercionDescendente(nodo *E){
		nodo *pnAux, *pnAux2;
		if(!pnLista){
			pnLista = E;
		}
		else{
			pnAux2 = pnLista->pnAnt;
			pnAux = pnLista;
			while (pnAux != 0 && E->iData < pnAux->iData){
				pnAux2 = pnAux;
				pnAux = pnAux->pnSig;
			}
			if(pnAux2 != 0){
				pnAux2->pnSig = E;
			}
			else{
				pnLista = E;
			}
			E->pnAnt = pnAux2;
			if (pnAux != 0){
				pnAux->pnAnt = E;
			}
			E->pnSig = pnAux;
		}
		pnContador = pnLista;
		return pnLista;
	}
	
	int iInsertar(nodo *E){
		if(pnLista == 0)
			pnLista = E;
		else{
			E->pnSig = pnLista;
			pnLista->pnAnt = E;
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
	
	void printList(){
		nodo *pnAux;
		pnContador = pnLista;
		pnAux = pnRecorre();
		while(pnAux){
			cout << pnAux->iData << "\n";
			pnAux = pnRecorre();
		}
	}
	
	nodo *ordenBurbuja(nodo *pnLista){
		nodo *pnAux, *pnAux2, *temp;
		bool flag = true;
		pnAux = pnLista;
		while(flag){
			flag = false;
			pnAux2 = pnAux;
			if(pnAux->iData > (pnAux->pnSig)->iData && pnAux)
				temp = pnAux->pnSig;
			else
				temp = pnAux;
			while(pnAux2){
				if (comparaAscendente(pnAux2, pnAux2->pnSig) != 1)
					pnAux2 = pnAux2->pnSig;
				else
					flag = true;
			}
			pnAux = temp;
		}
		return pnAux;
	}
	
	int comparaAscendente(nodo *pnAux, nodo *pnAux2){
		if(pnAux == 0 || pnAux2 == 0)
			return 0;
		if(pnAux->iData > pnAux2->iData){
			if(pnLista == pnAux)
				pnLista = pnAux2;
			if(pnAux->pnAnt != 0)
				(pnAux->pnAnt)->pnSig = pnAux2;
			pnAux->pnSig = pnAux2->pnSig;
			if(pnAux2->pnSig != 0)
				(pnAux2->pnSig)->pnAnt = pnAux;
			pnAux2->pnAnt = pnAux->pnAnt;
			pnAux2->pnSig = pnAux;
			pnAux->pnAnt = pnAux2;
			return 1;
		}
		else
			return 0;
	}
	
	nodo *ordenBurbujaDes(nodo *pnLista){
		nodo *pnAux, *pnAux2, *temp;
		bool flag = true;
		pnAux = pnLista;
		while(flag){
			flag = false;
			pnAux2 = pnAux;
			if(pnAux->iData < (pnAux->pnSig)->iData && pnAux)
				temp = pnAux->pnSig;
			else
				temp = pnAux;
			while(pnAux2){
				if (comparaDescendente(pnAux2, pnAux2->pnSig) != 1)
					pnAux2 = pnAux2->pnSig;
				else
					flag = true;
			}
			pnAux = temp;
		}
		return pnAux;
	}
	
	int comparaDescendente(nodo *pnAux, nodo *pnAux2){
		if(pnAux == 0 || pnAux2 == 0)
			return 0;
		if(pnAux->iData < pnAux2->iData){
			if(pnLista == pnAux)
				pnLista = pnAux2;
			if(pnAux->pnAnt != 0)
				(pnAux->pnAnt)->pnSig = pnAux2;
			pnAux->pnSig = pnAux2->pnSig;
			if(pnAux2->pnSig != 0)
				(pnAux2->pnSig)->pnAnt = pnAux;
			pnAux2->pnAnt = pnAux->pnAnt;
			pnAux2->pnSig = pnAux;
			pnAux->pnAnt = pnAux2;
			return 1;
		}
		else
			return 0;
	}
};

///////////////////////////////////////////////////////////////////////////////////////////
/* Aquí comienza la clase con los métodos de ordenamiento para la Lista Circular Doblemente
   Enlazada.
*/

class ORDENAMIENTO_CIRCULAR{
	private:
		nodo *pnContador;
		nodo *pnLista;
	public:
		ORDENAMIENTO_CIRCULAR(){
			pnContador = 0;
			pnLista = 0;
		}
		
	nodo *pnCrearNodoC(int iData){
		nodo *pnAux;
		pnAux = new nodo;
		pnAux->iData = iData;
		pnAux->pnSig = 0;
		pnAux->pnAnt = 0;
		return pnAux;
	}
	
	int iInsertarC(nodo *E){
		nodo *pnAux;
		pnAux = pnLista;
		if(!pnLista){
			E->pnSig = E;
			E->pnAnt = E;
			pnLista = E;
		}
		else{
			pnAux = pnAux->pnAnt;
			E->pnSig = pnAux->pnSig;
			(pnAux->pnSig)->pnAnt = E;
			pnAux->pnSig = E;
			E->pnAnt = pnAux;
			pnLista = E;
		}
		pnContador = pnLista;
	}
	
	nodo *pnRecorreC(){
		nodo *pnAux;
		pnAux = pnContador;
		if(pnContador == 0 || pnContador->pnSig == pnLista || pnContador->pnSig == 0)
			pnContador = pnLista;
		else
			pnContador = pnContador->pnSig;
		return(pnAux);
	}
	
	nodo *insercionAscendenteC(nodo *E){
		nodo *pnAux, *pnAux2, *I;
		I = pnLista;
		if(!pnLista){
			E->pnSig = E;
			E->pnAnt = E;
			pnLista = E;
		}
		else{
			if(pnLista->iData > E->iData){
				if(pnLista->pnAnt == pnLista){
					pnLista->pnSig = E;
					E->pnSig = pnLista;
					pnLista->pnAnt = E;
					E->pnAnt = pnLista;
					pnLista = E;
				}
				else{
					(pnLista->pnAnt)->pnSig = E;
					E->pnAnt = pnLista->pnAnt;
					E->pnSig = pnLista;
					pnLista->pnAnt = E;
					pnLista = E;
				}
			}
			else if(pnLista->iData < E->iData && E->iData > (pnLista->pnAnt)->iData){
				(pnLista->pnAnt)->pnSig = E;
				E->pnSig = pnLista;
				E->pnAnt = pnLista->pnAnt;
				pnLista->pnAnt = E;
			}
			else{
				pnAux2 = pnLista->pnAnt;
				pnAux = pnLista;
				while(E->iData > pnAux->iData && pnAux->pnSig != pnLista){
					pnAux2 = pnAux;
					pnAux = pnAux->pnSig;
				}
				pnAux2->pnSig = E;
				E->pnSig = pnAux;
				pnAux->pnAnt = E;
				E->pnAnt = pnAux2;
			}
		}
		pnContador = pnLista;
		return pnLista;
	}
	
	nodo *insercionDescendenteC(nodo *E){
		nodo *pnAux, *pnAux2, *I;
		I = pnLista;
		if(!pnLista){
			E->pnSig = E;
			E->pnAnt = E;
			pnLista = E;
		}
		else{
			if(pnLista->iData <= E->iData){
				if(pnLista->pnAnt == pnLista){
					pnLista->pnSig = E;
					E->pnSig = pnLista;
					pnLista->pnAnt = E;
					E->pnAnt = pnLista;
					pnLista = E;
				}
				else{
					(pnLista->pnAnt)->pnSig = E;
					E->pnAnt = pnLista->pnAnt;
					E->pnSig = pnLista;
					pnLista->pnAnt = E;
					pnLista = E;
				}
			}
			else if(pnLista->iData > E->iData && E->iData < (pnLista->pnAnt)->iData){
				(pnLista->pnAnt)->pnSig = E;
				E->pnSig = pnLista;
				E->pnAnt = pnLista->pnAnt;
				pnLista->pnAnt = E;
			}
			else{
				pnAux2 = pnLista->pnAnt;
				pnAux = pnLista;
				while(E->iData < pnAux->iData && pnAux->pnSig != pnLista){
					pnAux2 = pnAux;
					pnAux = pnAux->pnSig;
				}
				pnAux2->pnSig = E;
				E->pnSig = pnAux;
				pnAux->pnAnt = E;
				E->pnAnt = pnAux2;
			}
		}
		pnContador = pnLista;
		return pnLista;
	}
	
	int comparaAscendenteC(nodo *pnAux, nodo *pnAux2){
		if(pnAux && pnAux2){
			if(pnAux->iData > pnAux2->iData){
				if(pnAux == pnLista)
					pnLista = pnAux2;
				pnAux->pnSig = pnAux2->pnSig;
				(pnAux2->pnSig)->pnAnt = pnAux;
				pnAux2->pnAnt = pnAux->pnAnt;
				(pnAux->pnAnt)->pnSig = pnAux2;
				pnAux2->pnSig = pnAux;
				pnAux->pnAnt = pnAux2;
				return 1;
			}
			else
				return 0;
		}
	}
	
	int comparaDescendenteC(nodo *pnAux, nodo *pnAux2){
		if(pnAux && pnAux2){
			if(pnAux->iData < pnAux2->iData){
				if(pnAux == pnLista)
					pnLista = pnAux2;
				pnAux->pnSig = pnAux2->pnSig;
				(pnAux2->pnSig)->pnAnt = pnAux;
				pnAux2->pnAnt = pnAux->pnAnt;
				(pnAux->pnAnt)->pnSig = pnAux2;
				pnAux2->pnSig = pnAux;
				pnAux->pnAnt = pnAux2;
				return 1;
			}
			else
				return 0;
		}
	}
	
	void ordenBurbujaC(){
		nodo *pnAux, *pnAux2, *temp;
		bool flag = true;
		pnAux = pnLista;
		while(flag){
			flag = false;
			pnAux2 = pnAux;
			while(pnAux2->pnSig != pnLista){
				if (comparaAscendenteC(pnAux2, pnAux2->pnSig) != 1){
					pnAux2 = pnAux2->pnSig;
				}
				else
					flag = true;
			}
			pnAux = pnLista;
		}
	}
	
	void ordenBurbujaCDes(){
		nodo *pnAux, *pnAux2, *temp;
		bool flag = true;
		pnAux = pnLista;
		while(flag){
			flag = false;
			pnAux2 = pnAux;
			while(pnAux2->pnSig != pnLista){
				if (comparaDescendenteC(pnAux2, pnAux2->pnSig) != 1){
					pnAux2 = pnAux2->pnSig;
				}
				else
					flag = true;
			}
			pnAux = pnLista;
		}
	}
	
	nodo* getLista(){
		return pnLista;
	}
	
};

class MITAD_LISTA{
	public:
	MITAD_LISTA(){
	}
	nodo *mitadLista(nodo *pnInicio, nodo *pnFinal){
		nodo *pnMitad, *pnFin;
		if(pnInicio == NULL)
 			return NULL;
 		pnMitad = pnInicio;
 		pnFin = pnInicio->pnSig;
		while (pnFin != pnFinal){
			pnFin = pnFin->pnSig;
			if(pnFin != pnFinal){
				pnMitad = pnMitad->pnSig;
				pnFin = pnFin->pnSig;
			}
		}
		return pnMitad;
	}
};

class BINARY_SEARCH{
	public:
	
	MITAD_LISTA mLista;
	BINARY_SEARCH(){
	}
	
	nodo *binarySearch(nodo *pnLista, int llave){
		nodo *pnAux, *pnMitad, *pnInicio, *pnFinal;
		pnInicio = pnLista;
		pnFinal = NULL;	
		do{
			pnMitad = mLista.mitadLista(pnInicio, pnFinal);
			if(pnMitad == NULL){
				return NULL;
			}
			if(pnMitad->iData == llave){
				return pnMitad;
			}
			else if(pnMitad->iData < llave){
				pnInicio = pnMitad->pnSig;
			}
			else{
				pnFinal = pnMitad;
			}
		}while(pnFinal == NULL || pnFinal != pnInicio);
		return NULL;
	}
	
	nodo *binarySearchDesc(nodo *pnLista, int llave){
		nodo *pnAux, *pnMitad, *pnInicio, *pnFinal;
		pnInicio = pnLista;
		pnFinal = NULL;
		do{
			pnMitad = mLista.mitadLista(pnInicio, pnFinal);
			if(pnMitad == NULL){
				return NULL;
			}
			if(pnMitad->iData == llave){
				return pnMitad;
			}
			else if(pnMitad->iData > llave){
				pnInicio = pnMitad->pnSig;
			}
			else{
				pnFinal = pnMitad;
			}
		}while(pnFinal == NULL || pnFinal != pnInicio);
		return NULL;
	}
	
	nodo *binarySearchC(nodo *pnLista, int llave){
		nodo *pnAux, *pnMitad, *pnInicio, *pnFinal;
		pnInicio = pnLista;
		pnFinal = pnInicio->pnAnt;
		do{
			pnMitad = mLista.mitadLista(pnInicio, pnFinal);
			if(pnMitad == NULL){
				return NULL;
			}
			if(pnMitad->iData == llave){
				return pnMitad;
			}
			else if(pnMitad->iData < llave){
				pnInicio = pnMitad->pnSig;
			}
			else{
				pnFinal = pnMitad;
			}
		}while(pnFinal == pnInicio->pnAnt || pnFinal != pnInicio);
		return NULL;
	}
	
	nodo *binarySearchCDes(nodo *pnLista, int llave){
		nodo *pnAux, *pnMitad, *pnInicio, *pnFinal;
		pnInicio = pnLista;
		pnFinal = pnInicio;
		do{
			pnMitad = mLista.mitadLista(pnInicio, pnFinal);
			if(pnMitad == NULL){
				return NULL;
			}
			if(pnMitad->iData == llave){
				return pnMitad;
			}
			else if(pnMitad->iData > llave){
				pnInicio = pnMitad->pnSig;
			}
			else{
				pnFinal = pnMitad;
			}
		}while(pnFinal == pnInicio->pnAnt || pnFinal != pnInicio);
		return NULL;
	}
	
};

class RANDOM_NUMBER{
	public:
	RANDOM_NUMBER(){
	}
	
	int randomNumber(){
		int randomN = rand()%1000;
		return randomN;
	}

};

int main(){
	ORDENAMIENTO_DOBLE ordDoble, ordBDoble;
	ORDENAMIENTO_CIRCULAR ordCirc, ordCircB;
	RANDOM_NUMBER aleatorioN;
	BINARY_SEARCH busquedaBinaria;
	
	nodo *pnAux, *pnAux2, *I, *pnLista, *bin;
	int i, N, nNodos, start, stop, input, llave;
	bool flag = true;
	nNodos = 25;
	srand(time(NULL));
	cout << "Lista Doble Ordenamiento por Inserción." << "\n";
	cout << "Presione 1 para ordenar lista de forma ascendente." << "\n";
	cout << "Presione 2 para ordenar lista de forma descendente." << "\n";
	cin >> input;
	cout << "\n";
	switch(input){
		case 1:
			for(i = 0; i < nNodos; i++){
				N = aleatorioN.randomNumber();
				//cout << N << "\n";
				pnAux = ordDoble.pnCrearNodo(N);
				pnAux = ordDoble.insercionAscendente(pnAux);
				pnAux2 = pnAux;
			}
			start = clock();
			cout << "Introduzca número que desea buscar en la lista: " << "\n";
			cin >> llave;
			pnAux = busquedaBinaria.binarySearch(pnAux2, llave);
			if(pnAux == NULL)
			cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
			else
				cout << "El número " << pnAux->iData << " se encuentra en la lista." << "\n";
			stop = clock();
			cout << "Tiempo que tardó en realizar la busqueda: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
			cout << "\nLista Doble-Ordenamiento por Inserción Ascendente: " << "\n";
			cout << "Lista Ordenada: " << "\n";
			ordDoble.printList();
			break;
		case 2:
			for(i = 0; i < nNodos; i++){
				N = aleatorioN.randomNumber();
				//cout << N << "\n";
				pnAux = ordDoble.pnCrearNodo(N);
				pnAux = ordDoble.insercionDescendente(pnAux);
			}
			pnAux2 = pnAux;
			start = clock();
			cout << "Introduzca número que desea buscar en la lista: " << "\n";
			cin >> llave;
			bin = busquedaBinaria.binarySearchDesc(pnAux2, llave);
			if(bin == NULL)
			cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
			else
				cout << "El número " << bin->iData << " se encuentra en la lista." << "\n";
			stop = clock();
			cout << "Tiempo que tardó en realizar la busqueda: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
			cout << "\nLista Doble-Ordenamiento por Inserción Descendente: " << "\n";
			cout << "Lista Ordenada: " << "\n";
			ordDoble.printList();
			break;
		default: return 0;
	}
	
	cout << "\nLista Doble Ordenamiento Burbuja." << "\n";
	cout << "Presione 1 para ordenar lista de forma ascendente." << "\n";
	cout << "Presione 2 para ordenar lista de forma descendente." << "\n";
	cin >> input;
	switch(input){
		case 1:
			for(i = 0; i < nNodos; i++){
				N = aleatorioN.randomNumber();
				//cout << N << "\n";
				pnAux = ordBDoble.pnCrearNodo(N);
				ordBDoble.iInsertar(pnAux);
			}
			pnAux2 = ordBDoble.ordenBurbuja(pnAux);
			start = clock();
			cout << "Introduzca número que desea buscar en la lista: " << "\n";
			cin >> llave;
			pnAux = busquedaBinaria.binarySearch(pnAux2, llave);
			if(pnAux == NULL)
			cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
			else
				cout << "El número " << pnAux->iData << " se encuentra en la lista." << "\n";
			stop = clock();
			cout << "Tiempo que tardó en realizar la busqueda: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
			cout << "\nLista Doble-Ordenamiento Burbuja Ascendente: " << "\n";
			cout << "Lista Ordenada:" << "\n";
			ordBDoble.printList();
			break;
		case 2:
			for(i = 0; i < nNodos; i++){
				N = aleatorioN.randomNumber();
				//cout << N << "\n";
				pnAux = ordBDoble.pnCrearNodo(N);
				ordBDoble.iInsertar(pnAux);
			}
			pnAux2 = ordBDoble.ordenBurbujaDes(pnAux);
			cout << "Lista Doble Burbuja pnAux: " << pnAux2->iData << "\n";
			cout << "Introduzca número que desea buscar en la lista: " << "\n";
			cin >> llave;
			start = clock();
			pnAux = busquedaBinaria.binarySearchDesc(pnAux2, llave);
			if(pnAux == NULL)
			cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
			else
				cout << "El número " << pnAux->iData << " se encuentra en la lista." << "\n";
			stop = clock();
			cout << "Tiempo que tardó en realizar la busqueda: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
			cout << "\nLista Doble-Ordenamiento Burbuja Descendente: " << "\n";
			cout << "Lista Ordenada:" << "\n";
			ordBDoble.printList();
			break;
		default: return 0;
	}
	
	cout << "\nLista Doble Circular Ordenamiento por Insercion." << "\n";
	cout << "Presione 1 para ordenar lista de forma ascendente." << "\n";
	cout << "Presione 2 para ordenar lista de forma descendente." << "\n";
	cin >> input;
	switch(input){
		case 1:
			for(i = 0; i < nNodos; i++){
				N = aleatorioN.randomNumber();
				//cout << N << "\n";
				pnAux = ordCirc.pnCrearNodoC(N);
				pnAux = ordCirc.insercionAscendenteC(pnAux);
				pnAux2 = pnAux;
			}
			
			I = pnAux;
			cout << "Introduzca número que desea buscar en la lista: " << "\n";
			cin >> llave;
			start = clock();
			bin = busquedaBinaria.binarySearchC(pnAux2, llave);
			if(bin == NULL)
			cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
			else
				cout << "El número " << bin->iData << " se encuentra en la lista." << "\n";
			stop = clock();
			cout << "Tiempo que tardó en realizar la busqueda: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
			pnAux = ordCirc.pnRecorreC();
			cout << "Lista Ordenada Ascendente: " <<"\n";
			cout << pnAux->iData << "\n";
			pnAux = ordCirc.pnRecorreC();
			while(pnAux->pnSig != I){
				cout << pnAux->iData << "\n";
				pnAux = ordCirc.pnRecorreC();
			}
			cout << pnAux->iData << "\n";
			break;
		case 2:
			cout << "\nLista Desordenada: " << "\n";
			for(i = 0; i < nNodos; i++){
				N = aleatorioN.randomNumber();
				//cout << N << "\n";
				pnAux = ordCirc.pnCrearNodoC(N);
				pnAux = ordCirc.insercionDescendenteC(pnAux);
				pnAux2 = pnAux;
			}
			
			I = pnAux;
			cout << "Introduzca número que desea buscar en la lista: " << "\n";
			cin >> llave;
			start = clock();
			bin = busquedaBinaria.binarySearchCDes(pnAux2, llave);
			if(bin == NULL)
			cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
			else
				cout << "El número " << bin->iData << " se encuentra en la lista." << "\n";
			stop = clock();
			cout << "Tiempo que tardó en realizar la busqueda: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
			pnAux = ordCirc.pnRecorreC();
			cout << "Lista Ordenada Descendente: " <<"\n";
			cout << pnAux->iData << "\n";
			pnAux = ordCirc.pnRecorreC();
			while(pnAux->pnSig != I){
				cout << pnAux->iData << "\n";
				pnAux = ordCirc.pnRecorreC();
			}
			cout << pnAux->iData << "\n";
			break;
		default: return 0;
	}
	
	cout << "\nLista Doble Circular Ordenamiento Burbuja." << "\n";
	cout << "Presione 1 para ordenar lista de forma ascendente." << "\n";
	cout << "Presione 2 para ordenar lista de forma descendente." << "\n";
	cin >> input;
	switch(input){
		case 1:
			cout << "\nLista Desordenada: " << "\n";
			for(i = 0; i < nNodos; i++){
				N = aleatorioN.randomNumber();
				//cout << N << "\n";
				pnAux = ordCircB.pnCrearNodoC(N);
				ordCircB.iInsertarC(pnAux);
			}
			ordCircB.ordenBurbujaC();
			pnLista = ordCircB.getLista();
			cout << "Introduzca número que desea buscar en la lista: " << pnLista->iData <<"\n";
			cin >> llave;
			start = clock();
			bin = busquedaBinaria.binarySearchC(pnLista, llave);
			if(bin == NULL)
			cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
			else
				cout << "El número " << bin->iData << " se encuentra en la lista." << "\n";
			stop = clock();
			cout << "Tiempo que tardó en realizar la busqueda: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
			cout << "\nLista Ordenada:" << "\n";
			pnAux = pnLista;
			while(pnAux->pnSig != pnLista){
				cout << pnAux->iData << "\n";
				pnAux = pnAux->pnSig;
			}
			cout << pnAux->iData << "\n";
			break;
		case 2:
			cout << "\nLista Desordenada: " << "\n";
			for(i = 0; i < nNodos; i++){
				N = aleatorioN.randomNumber();
				//cout << N << "\n";
				pnAux = ordCircB.pnCrearNodoC(N);
				ordCircB.iInsertarC(pnAux);
			}
			ordCircB.ordenBurbujaCDes();
			pnLista = ordCircB.getLista();
			cout << "Introduzca número que desea buscar en la lista: " << pnLista->iData <<"\n";
			cin >> llave;
			start = clock();
			bin = busquedaBinaria.binarySearchCDes(pnLista, llave);
			if(bin == NULL)
			cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
			else
				cout << "El número " << bin->iData << " se encuentra en la lista." << "\n";
			stop = clock();
			cout << "Tiempo que tardó en realizar la busqueda: " << ((float)stop - start)/ (CLOCKS_PER_SEC) << " segundos.\n";
			cout << "\nLista Ordenada:" << "\n";
			pnAux = pnLista;
			while(pnAux->pnSig != pnLista){
				cout << pnAux->iData << "\n";
				pnAux = pnAux->pnSig;
			}
			cout << pnAux->iData << "\n";
			break;
		default: return 0;
	}
}

