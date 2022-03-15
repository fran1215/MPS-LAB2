import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {
    private DequeNode node;

    @Test
    public void shouldGetItemFromNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.getItem());
    }

    @Test
    public void shouldGetItemFrom_2_3_1_Return_2() {
        DequeNode<Integer> next = new DequeNode(3, null,null);
        DequeNode<Integer> prev = new DequeNode(1, null,null);
        node = new DequeNode(2, next, prev);
        prev.setNext(node);
        next.setPrevious(node);
        assertEquals(node.getItem(), 2);
    }


    @Test
    public void shouldGetPreviousFrom_2_3_1_Return_1() {
        DequeNode<Integer> next = new DequeNode(3, null,null);
        DequeNode<Integer> prev = new DequeNode(1, null,null);
        node = new DequeNode(2, next, prev);
        prev.setNext(node);
        next.setPrevious(node);
        assertEquals(node.getPrevious().getItem(), 1);
    }

    @Test
    public void shouldGetPreviousFromNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.getPrevious());
    }

    @Test
    public void shouldGetPreviousFrom_1_null_3_ReturnNull() {
        DequeNode<Integer> next = new DequeNode(2, null,null);
        node = new DequeNode(1, next,null);
        next.setPrevious(node);
        assertEquals(node.getPrevious(), null);
    }

    @Test
    public void shouldConstructor_4_5_3_CreateDEQueue_3_4_5(){
        DequeNode<Integer> next = new DequeNode(5, null,null);
        DequeNode<Integer> prev = new DequeNode(3, null,null);
        node = new DequeNode(4, next, prev);
        prev.setNext(node);
        next.setPrevious(node);
        assertEquals(node.getItem(), 4);
        assertEquals(node.getPrevious().getItem(), 3);
        assertEquals(node.getNext().getItem(), 5);
    }

    @Test
    public void shouldConstructor_4_null_3_CreateDEQueue_3_4(){
        DequeNode<Integer> prev = new DequeNode(3, null,null);
        node = new DequeNode(4, null, prev);
        prev.setNext(node);
        assertEquals(node.getItem(), 4);
        assertEquals(node.getPrevious().getItem(), 3);
        assertEquals(node.getNext(), null);
    }

    @Test
    public void shouldConstructor_4_5_null_CreateDEQueue_4_5(){
        DequeNode<Integer> next = new DequeNode(5, null,null);
        node = new DequeNode(4, next, null);
        next.setPrevious(node);
        assertEquals(node.getItem(), 4);
        assertEquals(node.getPrevious(), null);
        assertEquals(node.getNext().getItem(), 5);
    }

    @Test
    public void shouldConstructor_4_null_null_CreateDEQueue_4(){
        node = new DequeNode(4, null, null);
        assertEquals(node.getItem(), 4);
        assertEquals(node.getPrevious(), null);
        assertEquals(node.getNext(), null);
    }

    @Test
    public void shouldConstructor_null_5_3_ThrowException(){
        DequeNode<Integer> next = new DequeNode(5, null,null);
        DequeNode<Integer> prev = new DequeNode(3, null,null);
        assertThrows(RuntimeException.class, () -> node = new DequeNode(null, prev, next));
    }

    @Test
    public void shouldConstructor_null_null_3_ThrowException(){
        DequeNode<Integer> prev = new DequeNode(3, null,null);
        assertThrows(RuntimeException.class, () -> new DequeNode(null, null, prev));
    }

    @Test
    public void shouldConstructor_null_5_null_ThrowException(){
        DequeNode<Integer> next = new DequeNode(5, null,null);
        assertThrows(RuntimeException.class, () -> new DequeNode(null, next, null));
    }

    @Test
    public void shouldConstructor_null_null_null_ThrowException(){
        assertThrows(RuntimeException.class, () -> new DequeNode(null, null, null));
    }

    @Test
    public void shouldGetNextFrom_2_3_1_Return_3() {
        DequeNode<Integer> next = new DequeNode(3, null,null);
        DequeNode<Integer> prev = new DequeNode(1, null,null);
        node = new DequeNode(2, next, prev);
        prev.setNext(node);
        next.setPrevious(node);
        assertEquals(node.getNext().getItem(), 3);
    }

    @Test
    public void shouldGetNextFromNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.getNext());
    }

    @Test
    public void shouldGetNextFrom_1_null_3_ReturnNull() {
        DequeNode<Integer> prev = new DequeNode(3, null,null);
        node = new DequeNode(1,null, prev);
        prev.setNext(node);
        assertEquals(node.getNext(), null);
    }

    //isFirstNode()
    @Test
    public void shouldisFirstNodeFrom_1_null_null_Return_TRUE() {
        node = new DequeNode(1,null,null);
        assertEquals(node.isFirstNode(), true);
    }

    @Test
    public void shouldisFirstNodeFrom_1_3_null_Return_TRUE() {
        DequeNode<Integer> next = new DequeNode(3, null,null);
        node = new DequeNode(1, next,null);
        next.setPrevious(node);
        assertEquals(node.isFirstNode(), true);
    }

    @Test
    public void shouldisFirstNodeFrom_1_3_2_Return_TRUE() {
        DequeNode<Integer> next = new DequeNode(3, null,null);
        DequeNode<Integer> prev = new DequeNode(1, null,null);
        node = new DequeNode(2, next, prev);
        prev.setNext(node);
        next.setPrevious(node);
        assertEquals(node.isFirstNode(), false);
    }

    @Test
    public void shouldisFirstNodeNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.isFirstNode());
    }
    //isLastNode()
    @Test
    public void shouldisLastNodeFrom_1_null_null_Return_TRUE() {
        node = new DequeNode(1,null,null);
        assertEquals(node.isLastNode(), true);
    }

    @Test
    public void shouldisLastNodeFrom_4_null_3_Return_TRUE() {
        DequeNode<Integer> prev = new DequeNode(3, null,null);
        node = new DequeNode(4,null,prev);
        prev.setNext(node);

        assertEquals(node.isLastNode(), true);
    }

    @Test
    public void shouldisLastNodeFrom_1_3_2_Return_FALSE() {
        DequeNode<Integer> next = new DequeNode(2, null,null);
        DequeNode<Integer> prev = new DequeNode(3, null,null);
        node = new DequeNode(1, next, prev);
        next.setPrevious(node);
        prev.setNext(node);
        assertEquals(node.isLastNode(), false);
    }

    @Test
    public void shouldisLastNodeFromNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.isLastNode());
    }

    //isNotATerminalNode
    @Test
    public void shouldisNotATerminalNodeFrom_2_3_1_Return_TRUE() {
        DequeNode<Integer> next = new DequeNode(3, null,null);
        DequeNode<Integer> prev = new DequeNode(1, null,null);
        node = new DequeNode(2, next, prev);
        prev.setNext(node);
        next.setPrevious(node);
        assertEquals(node.isNotATerminalNode(), true);
    }

    @Test
    public void shouldisNotATerminalNodeFrom_1_null_null_Return_FALSE() {
        node = new DequeNode(1,null,null);
        assertEquals(node.isNotATerminalNode(), false);
    }

    @Test
    public void shouldisNotATerminalNodeFrom_1_2_null_Return_FALSE() {
        DequeNode<Integer> next = new DequeNode(2, null,null);
        node = new DequeNode(1, next, null);
        next.setPrevious(node);
        assertEquals(node.isNotATerminalNode(), false);
    }

    @Test
    public void shouldisNotATerminalNodeFrom_1_null_0_Return_FALSE() {
        DequeNode<Integer> prev = new DequeNode(0, null,null);
        node = new DequeNode(1, null, prev);
        prev.setNext(node);
        assertEquals(node.isNotATerminalNode(), false);
    }

    @Test
    public void shouldisNotATerminalNodeFromNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.isNotATerminalNode());
    }




}
