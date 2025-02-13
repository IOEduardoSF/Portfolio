#include <cstdlib>
#include <iostream>
#include <algorithm>

using namespace std;

typedef struct NODO{
  NODO *pnLeftChild;
  NODO *pnRightChild;
  pair <int, int> iData;
} nodo;

typedef nodo *Root;

class MIS{
public:
  void iInsert(Root &root, int key){
    if (root == NULL) {
      nodo *pnRoot = new nodo();
      pnRoot->iData.first = key;
      pnRoot->iData.second = 0;
      pnRoot->pnLeftChild = pnRoot->pnRightChild;
      pnRoot->pnRightChild = NULL;
      root = pnRoot;
    } else if (root->iData.first < key) iInsert(root->pnRightChild, key);
      else iInsert(root->pnLeftChild, key);
  }

  int mis(Root &root){
    if (root == NULL) {
      return 0;
    }

    int negativePos = mis(root->pnLeftChild) + mis(root->pnRightChild);
    int positivePos = 1;

    if (root->pnLeftChild != NULL) positivePos += mis(root->pnLeftChild->pnLeftChild) + mis(root->pnLeftChild->pnRightChild);

    if (root->pnRightChild != NULL) positivePos += mis(root->pnRightChild->pnRightChild) + mis(root->pnRightChild->pnLeftChild);

    if (max(positivePos, negativePos) == negativePos) root->iData.second = 0;
    else if (max(positivePos, negativePos) == positivePos) root->iData.second = 1;

    return max(positivePos, negativePos);
  }

  void printMIS(Root root){
    if (root != NULL) {
      printMIS(root->pnLeftChild);
      cout << root->iData.first << "(" << root->iData.second << ")" << " ";
      printMIS(root->pnRightChild);
    }
  }
};

int main(){
  MIS m;
  Root root;
  root = NULL;
  int n, key;
  char op;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> op;
    cin >> key;
    if (op == 'i') {
      m.iInsert(root, key);
    }
  }
  cout << m.mis(root) << ":";
  m.printMIS(root);
}