#include <iostream>
using namespace std;

typedef struct NODO nodo;
struct NODO{
  int iHeight;
  int iData;
  nodo *pnLeftChild;
  nodo *pnRightChild;
};

class AVLTREE{
public:

  int max(int a, int b){
    return (a > b)? a : b;
  }

  int height(nodo *root){
    if (root == 0) return 0;
    return root->iHeight;
  }

  int getBalance(nodo *root){
    int bal;
    if (root == 0) return 0;
    bal = height(root->pnLeftChild) - height(root->pnRightChild);
    return bal;
  }

  void inorder(nodo *root){
    if (root == 0) return;
    inorder(root->pnLeftChild);
    int val = getBalance(root);
    cout<<root->iData<<"("<<val<<")"<<" ";
    inorder(root->pnRightChild);
  }

  void postorder(nodo *root){
    if(root == 0) return;
    postorder(root->pnLeftChild);
    postorder(root->pnRightChild);
    int val = getBalance(root);
    cout<<root->iData<<"("<<val<<")"<<" ";
  }

  void preorder(nodo *root){
    if (root == 0) return;
    int val = getBalance(root);
    cout << root->iData <<"("<<val<<")"<<" ";
    preorder(root->pnLeftChild);
    preorder(root->pnRightChild);
  }

  void inorderLeaves(nodo *root){
    if (root == 0) return;
    inorderLeaves(root->pnLeftChild);
    if(root->pnLeftChild == 0 && root->pnRightChild == 0){
      cout<<root->iData<<" ";
    }
    inorderLeaves(root->pnRightChild);
  }

  nodo *pnCrearNodo(int iData){
    nodo *pnAux;
    pnAux = new nodo;
    pnAux->iData = iData;
    pnAux->pnLeftChild = 0;
    pnAux->pnRightChild = 0;
    pnAux->iHeight = 1;
    return pnAux;
  }

  nodo *rightRotation(nodo *root){
    nodo *x = root->pnLeftChild;
    nodo *z = x->pnRightChild;

    x->pnRightChild = root;
    root->pnLeftChild = z;

    root->iHeight = max(height(root->pnLeftChild), height(root->pnRightChild))+ 1;
    x->iHeight = max(height(x->pnLeftChild), height(x->pnRightChild))+ 1;
    return x;
  }

  nodo *leftRotation(nodo *root){
    nodo *y = root->pnRightChild;
    NODO *z = y->pnLeftChild;

    y->pnLeftChild = root;
    root->pnRightChild = z;

    root->iHeight = max(height(root->pnLeftChild), height(root->pnRightChild))+ 1;
    y->iHeight = max(height(y->pnLeftChild), height(y->pnRightChild))+ 1;
    return y;
  }

  nodo *valMin(nodo *root){
    nodo *pnAux = root;
    while (pnAux->pnLeftChild != 0) {
      pnAux = pnAux->pnLeftChild;
    }
    return pnAux;
  }

  nodo *valMax(nodo *root){
  	nodo *pnAux = root;
  	while (pnAux->pnRightChild != 0) {
  		pnAux = pnAux->pnRightChild;
  	}
  	return pnAux;
  }

  nodo *iInsert(nodo *root, int key){
    if(root == 0){
      return (pnCrearNodo(key));
    }

    if (key < root->iData) {
      root->pnLeftChild = iInsert(root->pnLeftChild, key);
    } else if (key > root->iData) {
      root->pnRightChild = iInsert(root->pnRightChild, key);
    } else if (key == root->iData){
      cout <<"e";
      cout <<"\n";
    } else {
      return root;
    }

    root->iHeight = 1 + max(height(root->pnLeftChild), height(root->pnRightChild));

    int balance = getBalance(root);
    if (balance > 1 && key < root->pnLeftChild->iData){
      return rightRotation(root);
    }
    if (balance < -1 && key > root->pnRightChild->iData){
      return leftRotation(root);
    }
    if (balance > 1 && key > root->pnLeftChild->iData) {
      root->pnLeftChild = leftRotation(root->pnLeftChild);
      return rightRotation(root);
    }

    if (balance < -1 && key < root->pnRightChild->iData) {
      root->pnRightChild = rightRotation(root->pnRightChild);
      return leftRotation(root);
    }
    return root;
  }

  nodo *iDelete(nodo *root, int key){
    if (root == 0){
      cout <<"e";
      cout <<"\n";
      return root;
    }else if (key < root->iData) {
      root->pnLeftChild = iDelete(root->pnLeftChild, key);
    } else if (key > root->iData) {
      root->pnRightChild = iDelete(root->pnRightChild, key);
    } else {
      if ((root->pnLeftChild == 0) || (root->pnRightChild == 0)) {
        //if (raiz->izq) raiz->izq else raiz->der
        nodo *pnAux = root->pnLeftChild ? root->pnLeftChild: root->pnRightChild;
        if(pnAux == 0){
          pnAux = root;
          root = 0;
        } else
          *root = *pnAux;
        delete pnAux;
      } else {
        nodo *pnAux = valMax(root->pnLeftChild);
        root->iData = pnAux->iData;
        root->pnLeftChild = iDelete(root->pnLeftChild, pnAux->iData);
      }
    }

    if (root == 0) return root;

    root->iHeight = 1 + max(height(root->pnLeftChild), height(root->pnRightChild));
    int balance = getBalance(root);

    if (balance > 1 && getBalance(root->pnLeftChild) >= 0) return rightRotation(root);

    if (balance > 1 && getBalance(root->pnLeftChild) < 0) {
      root->pnLeftChild = leftRotation(root->pnLeftChild);
      return rightRotation(root);
    }

    if (balance < -1 && getBalance(root->pnRightChild) <= 0) return leftRotation(root);

    if (balance < -1 && getBalance(root->pnRightChild) > 0) {
      root->pnRightChild = rightRotation(root->pnRightChild);
      return leftRotation(root);
    }
    return root;
  }
};

int main() {
  AVLTREE arbol, avl;
  nodo *root, *pnAux;
  int n, key;
  char op;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> op;
    cin >> key;

    if (op == 'i') {
      root = avl.iInsert(root, key);
    }
    if (op == 'r' && root != 0){
      root = avl.iDelete(root, key);
    }
    if (op == 'h' && key == 0 && root != 0) {
      avl.inorderLeaves(root);
      cout << "\n";
    }
    if (op == 'm' && key == -1 && root != 0) {
      avl.preorder(root);
      cout << "\n";
    }
    if (op == 'm' && key == 0 && root != 0) {
      avl.inorder(root);
      cout << "\n";
    }
    if (op == 'm' && key == 1 && root != 0){
      avl.postorder(root);
      cout << "\n";
    }
  }
  return 0;
}