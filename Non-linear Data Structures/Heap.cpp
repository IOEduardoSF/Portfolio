#include <iostream>
#include <cstdlib>
#include <vector>
#include <iterator>

using namespace std;

class BinaryHeap{
private:
  vector <int> heap;
  int left(int parent);
  int right(int parent);
  int parent(int child);
  void heapifyup(int index);
  void heapifydown(int index);

public:
  BinaryHeap(){}
  void Insert(int element);
  void DeleteMin();
  int ExtractMin();
  void DisplayHeap();
  int Size();
};

int BinaryHeap::Size(){
  return heap.size();
}

void BinaryHeap::Insert(int element){
    heap.push_back(element);
    heapifyup(heap.size() -1);
}

void BinaryHeap::DeleteMin(){
  if (heap.size() == 0){
    return;
  }

  heap[0] = heap.at(heap.size() - 1);
  heap.pop_back();
  heapifydown(0);
}

int BinaryHeap::ExtractMin(){
  if (heap.size() == 0){
    return -1;
  } else {
    return heap.front();
  }
}

void BinaryHeap::DisplayHeap(){
  vector <int>::iterator pos = heap.begin();
  while (pos != heap.end()){
    cout<<*pos<<" ";
    pos++;
  }
  cout<<endl;
}

int BinaryHeap::left(int parent)
{
  int l = 2 * parent + 1;
  if (l < heap.size()) return l;
  else return -1;
}

int BinaryHeap::right(int parent){
  int r = 2 * parent + 2;
  if (r < heap.size())
  return r;
  else
  return -1;
}

int BinaryHeap::parent(int child){
  int p = (child - 1)/2;
  if (child == 0)
  return -1;
  else
  return p;
}

void BinaryHeap::heapifyup(int in){
  if (in >= 0 && parent(in) >= 0 && heap[parent(in)] > heap[in]){
    int temp = heap[in];
    heap[in] = heap[parent(in)];
    heap[parent(in)] = temp;
    heapifyup(parent(in));
  }
}

void BinaryHeap::heapifydown(int in){
  int child = left(in);
  int child1 = right(in);
  if (child >= 0 && child1 >= 0 && heap[child] > heap[child1]){
    child = child1;
  }

  if (child > 0 && heap[in] > heap[child]){
    int temp = heap[in];
    heap[in] = heap[child];
    heap[child] = temp;
    heapifydown(child);
  }

}

int main() {
  BinaryHeap bH;

  int n, data;
  int cont = 0;
  char op;
  cin >> n;
  int arr[1];
  for (int i = 0; i < n; i++){
    cin >> op;
    cin >> data;
    if (op == 'i') {
      bH.Insert(data);
    }

    if (op == 'r' && data == 0) {
      bH.DeleteMin();
    }

    if (op == 'm' && data == 0) {
      bH.DisplayHeap();
    }
  }
  return 0;
}