package heap;

public class Heap <E extends Comparable> implements PQInterface<E> {
    private E[] A;
    private int numItems;

    public Heap(int arraySize){
        A = (E[]) new Comparable[arraySize];
        numItems = 0;
    }
    public Heap(E[] B, int numElements){
        A = B;
        numItems = numElements;
    }

    @Override
    public void insert(E newItem) throws Exception {
        if (numItems< A.length){
            A[numItems] = newItem;
            percolateUp(numItems);
            numItems++;
        } else{
            throw  new Exception("HeapErr: Insert()-Overflow!");
        }

    }

    private void percolateUp(int i){
        int parent = (i-1)/2;
        if (parent>=0 && A[i].compareTo(A[parent])>0){
            E tmp = A[i];
            A[i] = A[parent];
            A[parent] = tmp;
            percolateUp(parent);
        }
    }

    @Override
    public E deleteMax() throws Exception {
       if (!isEmpty()){
           E max = A[0];
           A[0] = A[numItems-1];
           numItems--;
           percolateDown(0);
           return max;
       } else throw  new Exception("HeapErr: deleteMax()-Underflow!");
    }

    private void percolateDown(int i){
        int child = 2*i+1;
        int rightChild = 2*i +2;
        if (child<=numItems-1){
            if (rightChild<= numItems-1 && A[child].compareTo(A[rightChild])<0){
                child = rightChild;
            }
            if (A[i].compareTo(A[child])<0){
                E tmp = A[i];
                A[i] = A[child];
                A[child] = tmp;
                percolateDown(child);
            }
        }
    }
    @Override
    public E max() throws Exception {
        if (!isEmpty()){
            return A[0];
        }else throw  new Exception("HeapErr: Max()-Empty!");
    }

    @Override
    public boolean isEmpty() {
        return numItems ==0;
    }

    @Override
    public void clear() {
        A = (E[]) new Object[A.length];
        numItems = 0;
    }

    public void buildHeap(){
        if (numItems>=2){
            for (int i=(numItems-2)/2;i>=0;i--){
                percolateDown(i);
            }
        }
    }
}
