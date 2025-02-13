#include <cstdlib>
#include <iostream>
#include <limits>
#include "vector"
#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> edgePair;

class DIJKSTRA{
public:
  void addEdge(vector <pair<int, int> > adj[], int u, int v, int weight){
      adj[u].push_back(make_pair(v, weight));
      adj[v].push_back(make_pair(u, weight));
  }

  void dijkstraAlg(vector <pair<int, int> > adj[], int vertices, int source, int dest){
    int infinite = numeric_limits<int>::max();
    bool flag = false;
    vector <int> path(vertices);
    path[source] = -1;
    priority_queue< edgePair, vector <edgePair> , greater<edgePair> > pQ;
    vector<int> dist(vertices, infinite);
    pQ.push(make_pair(0, source));
    dist[source] = 0;

    while (!pQ.empty()) {
      int u = pQ.top().second;
      pQ.pop();

      for (int x = 0; x < (int)adj[u].size(); ++x) {
        int v = adj[u].at(x).first;
        int weight = adj[u].at(x).second;
        if (dist[v] > dist[u] + weight) {
          //flag = duplicatePath(path, u);
          //if (flag == false){
          path[v] = u;
          //}
          dist[v] = dist[u] + weight;
          pQ.push(make_pair(dist[v], v));
        }
      }
    }

    //sort(path.begin(), path.end());
    for (int i = 0; i < vertices; ++i) {
      if (i == dest) {
        cout << dist[i];
        cout << " [";
        printPath(path, dest);
        cout << "]";
      }
    }
  }

  void printPath(vector<int> path, int v){
    if (path[v] == -1){
      cout << v;
      return;
    }
    printPath(path, path[v]);
    cout << " " << v;
  }

  bool duplicates(vector <pair<int, int > > vV, int u, int v){
    for (int i = 0; i < vV.size(); ++i) {
      if((vV[i].first == u && vV[i].second == v) || (vV[i].first == v && vV[i].second == u)){
        return true;
      }
    }
    return false;
  }

  bool duplicatePath(vector <int> path, int u){
    for (int i = 0; i < path.size(); ++i) {
      if (path[i] == u){
        return true;
      }
    }
    return false;
  }
};

int main(){
  DIJKSTRA p;

  int V;
  int dest;
  int source;
  int u, v, weight;
  bool flag = false;
  cin >> V;
  vector<edgePair > vV;
  vector<edgePair > adj[V + 1];
  cin >> source;
  cin >> dest;

  for (int i = 0; i < V; i++) {
    cin >> u;
    cin >> v;
    cin >> weight;

    flag = p.duplicates(vV, u, v);
    if (flag == false) {
      p.addEdge(adj, u, v, weight);
      vV.push_back(make_pair(u, v));
    }
  }

  p.dijkstraAlg(adj, V + 1, source, dest);

  return 0;
}