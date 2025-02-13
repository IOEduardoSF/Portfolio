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

class INSERCION_ASCENDENTE{
	private:
		nodo *pnContador;
		nodo *pnLista;
		nodo *pnListaAsc;
	public:
	
	INSERCION_ASCENDENTE(){
		pnContador = 0;
		pnLista = 0;
		pnListaAsc = 0;
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
		if(!pnListaAsc){
			pnListaAsc = E;
		}
		else{
			pnAux2 = pnListaAsc->pnAnt;
			pnAux = pnListaAsc;
			while (pnAux != 0 && E->iData > pnAux->iData){
				pnAux2 = pnAux;
				pnAux = pnAux->pnSig;
			}
			if(pnAux2 != 0){
				pnAux2->pnSig = E;
			}
			else{
				pnListaAsc = E;
			}
			E->pnAnt = pnAux2;
			if (pnAux != 0){
				pnAux->pnAnt = E;
			}
			E->pnSig = pnAux;
		}
		pnContador = pnListaAsc;
		return pnListaAsc;
	}
	
	nodo *pnRecorre(){
		nodo *pnAux;
		pnAux = pnContador;
		if(pnContador == 0)
			pnContador = pnListaAsc;
		else
			pnContador = pnContador->pnSig;
		return(pnAux);
	}
};

class MITAD_LISTA{
	public:
	MITAD_LISTA(){
	}
	/*Este es el método que regresa la mitad de la lista, usamos dos nodos, uno que indique
	  el final de la lista y otro que indique la mitad de la lista, el nodo que indica el final
	  es recorrido dos veces a la vezmientras que el que indica la mitad es recorrido una posición
	  a la vez, todo esto hasta que no hay más elementos en la lista. Todo esto regresa la mitad
	  de la lista.
	*/
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
		/*Este método es el de la busqueda binaria y se repite mientras el nodo final
		  sea diferente de cero/nulo o el nodo final sea diferente a el nodo inicio.
		*/		
		do{
			pnMitad = mLista.mitadLista(pnInicio, pnFinal);
			//Si la mitad de la lista es cero, regresa cero y termina el ciclo.
			if(pnMitad == NULL){
				return NULL;
			}
			/*Si el dato del nodo que se encuentra en la mitad de la lista es igual
			  que la llave entonces se ha encontrado el elemento y regresa el nodo.
			*/
			if(pnMitad->iData == llave){
				return pnMitad;
			}
			/*Si el dato del nodo que se encuentra en la mitad de la lista es menor que la llave
			  entonces se actualiza el inicio de la lista y ahora el nodo en la mitad es el
			  nuevo inicio de la lista.
			*/
			else if(pnMitad->iData < llave){
				pnInicio = pnMitad->pnSig;
			}
			/*Si ninguna de las condiciones anteriores se cumple entonces el final de la lista
			  es el nodo que se encuentra en la mitad de la lista y el inicio sigue siendo el mismo.
			*/
			else{
				pnFinal = pnMitad;
			}
		}while(pnFinal == NULL || pnFinal != pnInicio);
		return NULL;
	}
};

class RANDOM_NUMBER{
	public:
	RANDOM_NUMBER(){
	}
	
	int randomNumber(){
		/*Ésta linea se puede modificar para cambiar el rango de números de los que se generan los
		  números aleatorios
		*/
		int randomN = rand()%1000000;
		return randomN;
	}

};

int main(){
	class INSERCION_ASCENDENTE insAsc;
	class RANDOM_NUMBER aleatorioN;
	class BINARY_SEARCH busquedaBinaria;
	nodo *pnAux, *iAsc, *pnAux2;
	int i, N, nNodos, llave;
	int start_s=clock();//Esta es la variable que guarda el tiempo inicial.
	/*Ésta linea se puede modificar para cambiar el número de nodos de los que se compone
	  nuestra lista doblemente ligada.
	*/
	nNodos = 100000;
	srand(time(NULL));
	for (i = 0; i < nNodos; i++){
		N = aleatorioN.randomNumber();
		pnAux = insAsc.pnCrearNodo(N);
		pnAux = insAsc.insercionAscendente(pnAux);
		pnAux2 = pnAux;
	}
	int stop_s=clock();//Esta es la variable que guarda el tiempo final.
	//La siguiente línea muestra el tiempo que tomó al ciclo en crear los nodos y el tiempo
	//que tomó ordenarlos. Estas variables se usarán para tomar el tiempo en la busqueda binaria.
	cout << "Tiempo que tomó en ordenar los números: " << ((float)stop_s - start_s)/ (CLOCKS_PER_SEC) << " segundos.";
	
	/*Si se desea imprimir la lista descomentar esta sección de código, pero no se recomienda
	  si el número de nodos es muy grande, se recomienda que la lista sea de 100 o menos
	  elementos para que se puedan mostrar todos en la terminal de Linux.
	pnAux = insAsc.pnRecorre();
	while (pnAux){
		cout << pnAux->iData <<"\n";
		pnAux = insAsc.pnRecorre();
	}*/
	
	//La siguiente línea puede ser módificada para buscar una nueva llave en la lista ordenada.
	llave = 379913;
	start_s= clock();
	pnAux = busquedaBinaria.binarySearch(pnAux2, llave);
	if(pnAux == NULL)
		cout << "\nLa llave " << llave << " no se encuentra en la lista." << "\n";
	else
		cout << "El número " << pnAux->iData << " se encuentra en la lista." << "\n";
	stop_s = clock();
	cout << "Tiempo que tardó en realizar la busqueda: " << (stop_s-start_s)/double(CLOCKS_PER_SEC)*1000 << endl;
	//cout << "Fin." << "\n";
	//cout << "Lista Ascendente:" << "\n";
	
	
	
}
