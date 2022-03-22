import java.util.Comparator;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{
    DequeNode<T> root;
    DequeNode<T> last;
    int size;

    public DoubleLinkedListQueue(){
        this.root = this.last = null;
        size = 0;
    }

    public DoubleLinkedListQueue(T root){
        if(root == null) throw new RuntimeException("Root is Null");
        DequeNode<T> nodo = new DequeNode(root, null, null);
        this.root = nodo;
        this.last = nodo;
        size = 1;
    }

    public void append(T data) {
        DequeNode<T> node = new DequeNode<>(data, null, null);

        if (last == null)
            root = last = node;
        else {
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        }

        size++;
    }

    public void appendLeft(T data) {
        DequeNode<T> node = new DequeNode<>(data, null, null);

        if (root == null)
            last = root = node;
        else {
            node.setNext(root);
            root.setPrevious(node);
            root = node;
        }

        size++;
    }

    public void deleteFirst() {
        if(size == 0) throw new RuntimeException("Empty queue");

        root = root.getNext();

        if (root == null){
            last = null;
        } else {
            root.setPrevious(null);
        }

        size--;
    }

    public void deleteLast() {
        if(size == 0) throw new RuntimeException("Empty queue");

        last = last.getPrevious();

        if (last == null){
            root = null;
        } else {
            last.setNext(null);
        }

        size--;
    }

    public DequeNode peekFirst() {
        if (root == null) throw new RuntimeException("Root is null");
        return root;
    }

    public DequeNode peekLast() {
        if (root == null) throw new RuntimeException("Root is null");
        return last;
    }

    DequeNode<T> getAt(int position){
        if(size == 0 || position + 1 > size) throw new RuntimeException("Invalid position");

        DequeNode<T> temp = root;
        for(int i = 0; i<position; i++){
            temp = temp.getNext();
        }

        return temp;
    }

    DequeNode<T> find (T item){
        return null;
    }

    void delete(DequeNode<T> node){

    }
    void sort(Comparator<?> comparator){

    }

    public int size() {
        return size;
    }

    public String toString(){
        String res = "[ ";
        DequeNode<T> temp = root;

        while(temp != null){
            res+=temp.getItem().toString() + " ";
            temp = temp.getNext();
        }

        res+="]";

        return res;
    }
}
