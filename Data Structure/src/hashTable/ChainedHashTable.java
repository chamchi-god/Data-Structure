package hashTable;
import list.LinkedList;
import list.Node;
import BST.IndexInterface;

public class ChainedHashTable implements IndexInterface<Node>{
    private LinkedList<Integer>[] table;
    int numItems = 0;

    public ChainedHashTable(int n){
        table = (LinkedList<Integer>[]) new LinkedList[n];
        for (int i=0; i<n; i++){
            table[i] = new LinkedList<>();
        }
        numItems = 0;
    }

    private int hash(Integer x){
        return x% table.length;
    }


    public Node search(Integer x) {
        int slot = hash(x);
        if (table[slot].isEmpty()){
            return null;
        } else{
            int i= table[slot].indexOf(x);
            if (i == -12345){
                return null;
            } else {
                return table[slot].getNode(i);
            }
        }
    }

    public void insert(Integer x) {
        int slot = hash(x);
        table[slot].add(0,x);
        numItems++;
    }

    public void delete(Integer x) {
        if (isEmpty()){

        } else{
            int slot = hash(x);
            table[slot].removeItem(x);
            numItems--;
        }
    }

    @Override
    public Node search(Comparable x) {
        return null;
    }

    @Override
    public void insert(Comparable x) {

    }

    @Override
    public void delete(Comparable x) {

    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        for (int i=0; i<table.length; i++){
            table[i] = new LinkedList<>();
        }
        numItems = 0;

    }
}
