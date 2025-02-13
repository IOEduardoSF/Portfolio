#include <bits/stdc++.h>
#include "vector"
#include <iostream>

using namespace std;

class ADJLIST{
public:
  void addEdge(vector<int> adj[], int u, int v){
    adj[u].push_back(v);
    adj[v].push_back(u);
  }

  void printGraph(vector<int> adj[], int v){
    for (int i = 0; i < v; i++) {
      if (!adj[i].empty()){
        cout << i;
        for (int x = 0; x < (int)adj[i].size(); x++){
          cout << "--" << adj[i].at(x);
        }
        cout << "\n";
      }
    }
  }
};

int main(){
  ADJLIST adjL;
  int v, x, y;
  cin >> v;
  vector<int> adj[v + 1];
  for (int i = 0; i < v; i++) {
    cin >> x;
    cin >> y;
    if (x != y && x != 0 || y != 0 ){
      adjL.addEdge(adj, x, y);
    }
  }
  if(!adj[v + 1].empty())
    adjL.printGraph(adj, v + 1);
}