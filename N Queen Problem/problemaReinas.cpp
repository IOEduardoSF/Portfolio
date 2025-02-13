#include<cstdlib>
#include <iostream>
using namespace std;

const int N = 8;
class nReinas{
	public:
	nReinas(){
	}
	
	void imprimeTablero(int tablero[N][N]){
		static int cont = 1;
		cout << "Solución: " << cont << "\n";
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++)
				cout << " " <<tablero[i][j];
		   cout << "\n";
		}
		cout <<"\n";
		cont = cont + 1;
	}

	bool noAtaque(int tablero[N][N], int ren, int col){
		int i, j;

		for (i = 0; i < col; i++)
			if (tablero[ren][i])
		   	return false;
		   	
		for (i=ren, j=col; i>=0 && j>=0; i--, j--)
			if (tablero[i][j])
		   	return false;
		for (i=ren, j=col; j>=0 && i<N; i++, j--)
			if (tablero[i][j])
		   	return false;
		return true;
	}

	bool colocaReina(int tablero[N][N], int col){
		if (col == N ){
			imprimeTablero(tablero);
		   return true;
		}
		for (int i = 0; i < N; i++){
			if(noAtaque(tablero, i, col)){
		   	tablero[i][col] = 1;
		   	colocaReina(tablero, col + 1) ;
		      tablero[i][col] = 0;
		     }
		}
		return false;
	}

	void tableroReinas(){
		int tablero[N][N];
		
		for(int ren = 0; ren < N; ren++){
			for(int col = 0; col < N; col++)
				tablero[ren][col] = 0;
		}
	
		if(colocaReina(tablero, 0)){
			cout << "La solución no existe.\n";
			return;
		}
	}
};

int main(){
	nReinas nR;
	nR.tableroReinas();
   return 0;
}
