#include <iostream>
#include <string>
#include <stdio.h>
#include <fstream>
#include <cstring>
using namespace std;

typedef struct NODO nodo;
struct NODO{
	char chData;
	int iData;
	nodo *pnSig;
};

class LISTA{
	private:
	nodo *pnContador;
	nodo *pnLista;
	
	public:
	
	LISTA(){
		pnContador = 0;
		pnLista = 0;
	}
	
	nodo *pnCrearNodo(char chData){
		nodo *pnAux;
		pnAux = new nodo;
		pnAux->chData = chData;
		pnAux->iData = '\0';
		pnAux->pnSig = 0;
	}
	
	nodo *pnCrearNodoInt(int iData){
		nodo *pnAux;
		pnAux = new nodo;
		pnAux->iData = iData;
		pnAux->chData = '\0';
		pnAux->pnSig = 0;
	}
	
	int iInsertarFinal(nodo *E){
		nodo *pnAux;
		if(pnLista == 0)
			pnLista = E;
		else{
			pnAux = pnLista;
			while(pnAux->pnSig){
				pnAux = pnAux->pnSig;
			}
			pnAux->pnSig = E;
		}
		pnContador = pnLista;
	}
	
   nodo *pnExtraerNodo()
   {
     nodo *pnAux;
     if (pnLista==0) 
     	return (0);
     pnAux = pnLista;
     pnLista = pnAux->pnSig;
     pnAux->pnSig = 0;
     return (pnAux);
   }
	
	int iNumeroNodos(){
		nodo *pnAux;
		int N = 0;
		pnAux = pnLista;
		while(pnAux != 0){
			N += 1;
			pnAux = pnAux->pnSig;
		}
		return(N);
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
	
	nodo *pnInicio(){
		return pnLista;
	}
};

class PILA{
	private:
	nodo *pnContador;
	nodo *pnTope;
	
	public:
	PILA(){
		pnContador = 0;
		pnTope = 0;
	}
	
	nodo *pnTopePila(){
		return pnTope;
	}
	
	void PUSH (nodo *E){
		int i = 0;
		nodo *pnAux;
		if(pnTope == 0)
			pnTope = E;
		else{
			E->pnSig = pnTope;
			pnTope = E;
		}
		pnContador = pnTope;
	}
	
	nodo *POP (){
		nodo *pnAux;
		if (pnTope == 0) 
		   return (0);
      pnAux = pnTope;
      pnTope = pnAux->pnSig;
      pnAux->pnSig = 0;
      return (pnAux);
	}
	
	/*bool isEmpty(){
		if (pnTope = 0)
			return true;
		else
			return false;
	}*/
	
};

class INFIJO_POSFIJO{
	private:
		LISTA listaInfija, listaPosfija;
		PILA Pila, PilaOperacion;
		
	public:
	
	INFIJO_POSFIJO(){
	}
	
	int precedencia(char op){
		switch (op){
			case '(':
				return -2;
				break;
			case ')':
				return -1;
				break;
			case '+':
			case '-':
				return 1;
				break;
			case '*':
			case '/':
				return 2;
				break;
			case '^':
				return 3;
				break;
			default: return 0;
		}
	}
	
	nodo *infijoPosfijo(LISTA pnLista){
		char opAux;
		nodo *pnAux;
		nodo *E ,*pnAuxPila;
		int preAux, preAuxInt, preAuxTope, i;
		listaInfija = pnLista;
		if (listaInfija.pnInicio() == NULL){
			return 0;
		}
		else{
			while(listaInfija.pnInicio() != NULL){
				pnAux = listaInfija.pnExtraerNodo();
				preAux = precedencia(pnAux->chData);
					
				if (pnAux->iData){
					listaPosfija.iInsertarFinal(pnAux);
				}
				else if (preAux == -2){
					Pila.PUSH(pnAux);
				}
				else if (preAux == -1){
					i = precedencia(Pila.pnTopePila()->chData);
					while(Pila.pnTopePila() != NULL && i != -2){
						pnAuxPila = Pila.pnTopePila();
						Pila.POP();
						if(precedencia(pnAuxPila->chData) != -2)
							listaPosfija.iInsertarFinal(pnAuxPila);
					}
					if ( i == -2 ){
						pnAuxPila = Pila.pnTopePila();
						Pila.POP();
					}
				}
				
				else{
					if(Pila.pnTopePila() != NULL)
						preAuxTope = precedencia(Pila.pnTopePila()->chData);
					while(Pila.pnTopePila() != NULL && preAux <= preAuxTope){
						pnAuxPila = Pila.pnTopePila();
						Pila.POP();
						listaPosfija.iInsertarFinal(pnAuxPila);
					}
					Pila.PUSH(pnAux);
				}
			}
			while(Pila.pnTopePila() != NULL){
				pnAuxPila = Pila.pnTopePila();
				Pila.POP();
				
				listaPosfija.iInsertarFinal(pnAuxPila);
			}
		}
		pnAux = listaPosfija.pnInicio();
		cout << "Operacion Posfija: ";
		while(pnAux){
			if (pnAux->iData)
				cout << pnAux->iData << " ";
			else
				cout << pnAux->chData << " ";
			pnAux = pnAux->pnSig;	
			
		}
		return listaPosfija.pnInicio();
	}
	
	nodo *evaluaPosfijo(nodo *pnLista){
		nodo *pnAux, *pilaAux, *pilaAux2, *pilaRes;
		char chNum, chNumAux;
		int iNum, iNumAux, preAux, resOp;
		if(pnLista){
			while(pnLista != 0){
				pnLista = pnLista->pnSig;
				pnAux = listaPosfija.pnExtraerNodo();
				if(pnAux->iData){
					PilaOperacion.PUSH(pnAux);
				}
				else{
					pilaAux = PilaOperacion.POP();
					pilaAux2 = PilaOperacion.POP();
					switch(pnAux->chData){
						case '+':
							pilaAux->iData += pilaAux2->iData;
							PilaOperacion.PUSH(pilaAux);
							break;
						case '-':
							pilaAux2->iData -= pilaAux->iData; 
							PilaOperacion.PUSH(pilaAux2);
							break;
						case '*':
							pilaAux->iData *= pilaAux2->iData;
							PilaOperacion.PUSH(pilaAux);
							break;
						case '/':
							pilaAux2->iData /= pilaAux->iData; 
							PilaOperacion.PUSH(pilaAux2);
							break;
						case '^':
							int iNum = pilaAux2->iData;
							while(pilaAux->iData != 1){
								pilaAux2->iData = pilaAux2->iData * iNum;
								pilaAux->iData = pilaAux->iData - 1;
							}
							//pilaAux->iData = resOp;
							PilaOperacion.PUSH(pilaAux2);
							break;
					}
				}
			}
		}
		return PilaOperacion.pnTopePila();
	}
};

class READFILE{
	private:
		string operacionLinea;
	public:
	
	READFILE(){
		string operacionLinea;
	}
	
	string readFile(){
		ifstream file;
		file.open("/home/eduardosf/EsDatosLineales/Operaciones.txt", ios::in); //ESTÁ ES LA LINEA QUE LLEVA LA UBICACIÓN DEL ARCHIVO, ESTÁ SE DEBE MODIFICAR.
		if (!file.is_open())
			cout << "Unable to open file." << "\n";
		else{
			getline(file, operacionLinea);
			cout << "Operación: " <<operacionLinea << endl;
			file.close();
		}
		return operacionLinea;
	}
};


int main(){
	class LISTA MiLista, listaAux;
	class INFIJO_POSFIJO infix_postfix;
	class READFILE leerArchivo;
	
	nodo *pnAux, *pnAux2, *pnFile;
	string operacionL;
	int N = 0, iAux, i;
	operacionL = leerArchivo.readFile();
	char chArreglo[operacionL.length()];
	strcpy(chArreglo, operacionL.c_str());
	
	for(i = 0; chArreglo[i]; i++){
		if(infix_postfix.precedencia(chArreglo[i]) == 0){
			iAux *= 10;
			iAux += chArreglo[i] - '0';
			
			if(chArreglo[i+1] == 0 || infix_postfix.precedencia(chArreglo[i+1]) != 0){
				pnFile = MiLista.pnCrearNodoInt(iAux);
				MiLista.iInsertarFinal(pnFile);
				iAux = 0;
			}
		}
		else{
			pnFile = MiLista.pnCrearNodo(chArreglo[i]);
			MiLista.iInsertarFinal(pnFile);
		}
	}
	
	pnAux = infix_postfix.infijoPosfijo(MiLista);
	//N = MiLista.iNumeroNodos();
	pnAux2 = infix_postfix.evaluaPosfijo(pnAux);
	cout << "\nResultado: " << pnAux2->iData << "\n";

}
