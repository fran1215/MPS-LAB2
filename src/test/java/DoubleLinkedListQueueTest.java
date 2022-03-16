import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {
    DoubleLinkedListQueue<Integer> lista;

    //Constructor
    @Test
    public void ConstructorIsNull() {
        assertThrows(RuntimeException.class,() -> new DoubleLinkedListQueue<Integer>(null));
    }

    @Test
    public void ConstructorIs4(){
        lista = new DoubleLinkedListQueue(4);
        assertEquals(lista.root.getItem(), 4);
    }
    /*
    DequeNode<Integer> next = new DequeNode(3, null,null);
        DequeNode<Integer> prev = new DequeNode(1, null,null);
        node = new DequeNode(2, next, prev);
        prev.setNext(node);
        next.setPrevious(node);
        assertEquals(node.getPrevious().getItem(), 1);
     */

    //append
    @Test
    public void Append3From_1_2_Return_1_2_3() {
        lista = new DoubleLinkedListQueue(1);
        lista.append(2);
        lista.append(3);
        assertEquals(lista.last.getItem(),3);
    }
    @Test
    public void Append2From_null_null_Return_2() {
        lista = new DoubleLinkedListQueue<>(1);
        lista.deleteFirst(); //No se puede crear una lista vacia
        lista.append(2);
        assertEquals(lista.root.getItem(),2);
    }
    @Test
    public void Append3FromEmpty_Return_3() {
        lista = new DoubleLinkedListQueue<>(1);
        lista.deleteFirst();
        lista.append(3);
        assertEquals(lista.root.getItem(),3);
    }

    @Test
    public void AppendnullThrowException() {
        assertThrows(RuntimeException.class, () -> lista.append(null));
    }

    //appendLeft
    @Test
    public void AppendLeft3From_1_2_Return_3_1_2() {
        lista = new DoubleLinkedListQueue(1);
        lista.append(2);
        lista.appendLeft(3);
        assertEquals(lista.root.getItem(),3);
    }
    @Test
    public void AppendLeft2From_null_null_Return_2() {
        lista = new DoubleLinkedListQueue<>(1);
        lista.deleteFirst(); //No se puede crear una lista vacia
        lista.appendLeft(2);
        assertEquals(lista.root.getItem(),2);
    }

    @Test
    public void AppendLeft3FromEmpty_Return_3() {
        lista = new DoubleLinkedListQueue<>(1);
        lista.deleteFirst();
        lista.appendLeft(3);
        assertEquals(lista.root.getItem(),3);
    }

    @Test
    public void AppendLeftnullThrowException() {
        assertThrows(RuntimeException.class, () -> lista.appendLeft(null));
    }

    //deleteFirst()
    @Test
    public void deleteFisrtFrom_1_2_3_Return_2_3() {
        lista = new DoubleLinkedListQueue(1);
        lista.append(2);
        lista.append(3);
        lista.deleteFirst();
        assertEquals(lista.root.getItem(),2);
    }
    @Test
    public void deleteFisrtFrom_1_Return_vacio() {
        lista = new DoubleLinkedListQueue<>(1);
        lista.deleteFirst();
        assertEquals(lista.size,0);
    }

    @Test
    public void deleteFirstFromEmptyThrowException() {
        lista = new  DoubleLinkedListQueue<>(1);
        lista.deleteFirst();
        assertThrows(RuntimeException.class, () -> lista.deleteFirst());
    }

    //deleteLast()
    @Test
    public void deleteLastFrom_1_2_3_Return_1_2() {
        lista = new DoubleLinkedListQueue(1);
        lista.append(2);
        lista.append(3);
        lista.deleteLast();
        assertEquals(lista.last.getItem(),2);
    }
    @Test
    public void deleteLastFrom_1_Return_vacio() {
        lista = new DoubleLinkedListQueue<>(1);
        lista.deleteLast();
        assertEquals(lista.size,0);
    }

    @Test
    public void deleteLastFromEmptyThrowException() {
        lista = new  DoubleLinkedListQueue<>(1);
        lista.deleteLast();
        assertThrows(RuntimeException.class, () -> lista.deleteLast());
    }

    //peekFirst()
    @Test
    public void peakFistFrom_1_2_3_Return_1() {
        lista = new DoubleLinkedListQueue(1);
        lista.append(2);
        lista.append(3);
        assertEquals(lista.peekFirst(),lista.root);
    }
    @Test
    public void peakFirstFrom_1_Return_1() {
        lista = new DoubleLinkedListQueue<>(1);
        assertEquals(lista.peekFirst(),lista.root);
    }

    @Test
    public void peakFistFromEmptyThrowException() {
        lista = new  DoubleLinkedListQueue<>(1);
        lista.deleteLast();
        assertThrows(RuntimeException.class, () -> lista.peekFirst());
    }

    //peekLast()
    @Test
    public void peakLastFrom_1_2_3_Return_3() {
        lista = new DoubleLinkedListQueue(1);
        lista.append(2);
        lista.append(3);
        assertEquals(lista.peekLast(),lista.last);
    }
    @Test
    public void peakLastFrom_1_Return_1() {
        lista = new DoubleLinkedListQueue<>(1);
        assertEquals(lista.peekFirst(),lista.last);
    }

    @Test
    public void peakLastFromEmptyThrowException() {
        lista = new  DoubleLinkedListQueue<>(1);
        lista.deleteLast();
        assertThrows(RuntimeException.class, () -> lista.peekLast());
    }

    //size()
    @Test
    public void sizeFrom_1_2_3_Return_3() {
        lista = new DoubleLinkedListQueue(1);
        lista.append(2);
        lista.append(3);
        assertEquals(lista.size(),3);
    }
    @Test
    public void sizeFromEmptyReturn_0() {
        lista = new  DoubleLinkedListQueue<>(1);
        lista.deleteLast();
        assertEquals(lista.size(),0);
    }

    //toString()
    @Test
    public void toStringFrom_1_2_3() {
        lista = new DoubleLinkedListQueue(1);
        lista.append(2);
        lista.append(3);
        assertEquals(lista.toString(),"[ 1 2 3 ]");
    }
    @Test
    public void toStringEmpty() {
        lista = new  DoubleLinkedListQueue<>(1);
        lista.deleteLast();
        assertEquals(lista.toString(),"[ ]");
    }
}