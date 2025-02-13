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

void iInsert(Root &root, int key){
  if (root == NULL) {
    nodo *pnAux = new nodo;
    pnAux->iData.first = key;
    pnAux->iData.second = 0;
    pnAux->pnLeftChild = pnAux->pnRightChild;
    pnAux->pnRightChild = NULL;
    root = pnAux;
  } else if (root->iData.first < key) {
    iInsert(root->pnRightChild, key);
  } else {
    iInsert(root->pnLeftChild, key);
  }
}

int MIS(Root &root){
  if(root == NULL){
    return 0;
  }

  int pos_Neg = MIS(root->pnLeftChild) + MIS(root->pnRightChild);
  int pos_Pos = 1;

  if (root->pnLeftChild != NULL) {
    pos_Pos += MIS(root->pnLeftChild->pnLeftChild) + MIS(root->pnLeftChild->pnRightChild);
  }

  if (root->pnRightChild != NULL) {
    pos_Pos += MIS(root->pnRightChild->pnRightChild) + MIS(root->pnRightChild->pnLeftChild);
  }

  if (max(pos_Pos, pos_Neg) == pos_Neg) {
    root->iData.second = 0;
  } else if (max(pos_Pos, pos_Neg) == pos_Pos) {
    root->iData.second = 1;
  }

  return max(pos_Pos, pos_Neg);
}

void printTree(Root root){
  if (root != NULL) {
    printTree(root->pnLeftChild);
    cout << root->iData.first << "(" << root->iData.second << ")" << " ";
    printTree(root->pnRightChild);
  }
}

int main(){
  Root root;
  root = NULL;
  int length, key;
  char op;

  cin >> length;
  for (int i = 0; i < length; i++) {
    cin >> op;
    cin >> key;

    if (op == 'i')
      iInsert(root, key);
  }
  cout << MIS(root) << ":";
  printTree(root);
  return 0;
}