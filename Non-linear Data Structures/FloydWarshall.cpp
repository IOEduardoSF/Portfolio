#include <cstdlib>
#include <iostream>
#include <limits>

using namespace std;
#define INF 999999

class Graph{
private:
  int** adjMatrix;
  int** pMatrix;
  int nVertices;
public:
  Graph(int nVertices){
    this->nVertices = nVertices;
    adjMatrix = new int*[nVertices];
    pMatrix = new int*[nVertices];
    for (int i = 0; i < nVertices; i++) {
      adjMatrix[i] = new int[nVertices];
      pMatrix[i] = new int[nVertices];
      for (int j = 0; j < nVertices; j++) {
        adjMatrix[i][j] = INF;
        pMatrix[i][j] = INF;
      }
    }
  }

  void addEdge(int i, int j, int weight) {
    if (adjMatrix[i][j] == INF){
      adjMatrix[i][j] = weight;
      pMatrix[i][j] = weight;
    }
  }

  void printMatrix(int r, int c){
    for (int i = 0; i < nVertices; i++){
      for (int j = 0; j < nVertices; j++) {
        if (i == r && j == c) {
          if (adjMatrix[i][j] == INF) {
            cout << "INF, e";
          } else {
            cout << adjMatrix[i][j] << ", ";
            getPath(r, c);
         }
       }
      }
    }
    cout << "\n";
  }

  void getPath(int i , int j){
    if (i == j) {
      cout << i << " ";
    } else if (pMatrix[i][j] == INF) {
      cout << " e";
    } else {
      getPath(i, pMatrix[i][j]);
      cout << j << " ";
    }
  }

  void floydWarshall(int v){
    for (int i = 0; i < v; i++) {
      for (int j = 0; j < v; j++){
        if (adjMatrix[i][j] != 0 && adjMatrix[i][j] != INF) {
          pMatrix[i][j] = i;
        } else {
          pMatrix[i][j] = -1;
        }
      }
    }

    for (int k = 0; k < v; k++) {
      for (int i = 0; i < v; i++) {
        for (int j = 0; j < v; j++) {
          if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
            adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
            pMatrix[i][j] = pMatrix[k][j];
          }
        }
      }
    }
  }

};

int main(){
  int u, v, weight, vertices, tuples, consults, c, r;
  cin >> vertices;
  cin >> tuples;
  cin >> consults;
  Graph g(vertices);

  for (int i = 0; i < tuples; i++) {
    cin >> u;
    cin >> v;
    cin >> weight;
    g.addEdge(u, v, weight);
  }

  g.floydWarshall(vertices);

  for (int i = 0; i < consults; i++) {
    cin >> r;
    cin >> c;
    g.printMatrix(r, c);
  }
}