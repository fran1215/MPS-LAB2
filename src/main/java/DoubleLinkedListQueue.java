import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{
    private DequeNode<T> root;
    private DequeNode<T> last;
    private int size;

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

    public DequeNode getFirst(){
        return root;
    }

    public DequeNode getLast(){
        return last;
    }

    DequeNode<T> getAt(int position){
        if(size == 0) throw new RuntimeException("Empty queue");
        if(position + 1 > size) throw new RuntimeException("Invalid position");

        DequeNode<T> temp = root;
        for(int i = 0; i<position; i++){
            temp = temp.getNext();
        }

        return temp;
    }

    DequeNode<T> find (DequeNode<T> item){
        if(size == 0) throw new RuntimeException("Empty queue");
        if(item == null) throw new RuntimeException("Item can't be null");

        DequeNode<T> temp = root;
        while(temp!=null && !temp.getItem().equals(item.getItem())){
            temp = temp.getNext();
        }

        if(temp == null) throw new RuntimeException("Item not in queue");

        return temp;
    }

    void delete(DequeNode<T> node){
        DequeNode<T> temp = find(node);

        if(temp.getPrevious() == null && temp.getNext() == null){ // Only element in queue
            root = last = null;
        } else if (temp.getPrevious() == null) { // First element in queue
            root = temp.getNext();
            root.setPrevious(null);
        } else if (temp.getNext() == null) { // Last element in queue
            last = temp.getPrevious();
            last.setNext(null);
        } else {
            temp.getPrevious().setNext(temp.getNext());
        }

        size--;

    }

    void sort(Comparator<T> comparator){
        DequeNode<T> tempNode = root;
        List<T> asList = new ArrayList<>();
        for (int i = 0; tempNode != null && i < size; i++) {
            asList.add(tempNode.getItem());
        }
        Collections.sort(asList, comparator);

        tempNode = new DequeNode<>(asList.get(0), null, null);
        for(int i = 1; i < size; i++){
            tempNode.setNext(getAt(1));
            tempNode = tempNode.getNext();
        }

        root = tempNode;
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
