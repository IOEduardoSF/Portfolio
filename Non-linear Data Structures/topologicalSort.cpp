#include <cstdlib>
#include <list>
#include <vector>
#include <iostream>

using namespace std;

class TSORT{
public:
  int v;
  list<int> *adjList;
  vector<int> indegree;

  void graph(int v){
    this->v = v;
    adjList = new list<int>[v];
    for (int i = 0; i < v; i++) {
      indegree.push_back(0);
    }
  }

  void addEdge(int v, int w){
    adjList[v].push_back(w);
    indegree[w]++;
  }

  void topologicalSort(vector<int> &results, bool visited[]){
    bool flag = false;

    for (int i = 0; i < v; i++) {
      if (indegree[i] == 0 && !visited[i]) {
        list<int>:: iterator j;
        for (j = adjList[i].begin(); j != adjList[i].end(); j++) {
          indegree[*j]--;
        }

        results.push_back(i);
        visited[i] = true;
        topologicalSort(results, visited);
        flag = true;
      }
    }
    if (!flag) {
      cout << "[";
      for (int i = 0; i < results.size(); i++) {

        cout << results[i];
        if (i != results.size()- 1) {
          cout << " ";
        }
      }
      cout << "]";
    }
  }

  void tSortAlg(){
    bool *visited = new bool[v];
    for (int i = 0; i < v; i++) {
      visited[i] = false;
    }
    vector<int> results;
    topologicalSort(results, visited);
  }
};

int main() {
  int n, m, u, v;
  cin >> n;
  TSORT tS;
  tS.graph(n);
  cin >> m;
  for (int i = 0; i < m; i++) {
    cin >> u;
    cin >> v;
    tS.addEdge(u, v);
  }
  tS.tSortAlg();
}