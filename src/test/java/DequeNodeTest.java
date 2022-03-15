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
        node = new DequeNode(2,3,1);
        assertEquals(node.getItem(), 2);
    }


    @Test
    public void shouldGetPreviousFrom_2_3_1_Return_1() {
        node = new DequeNode(2,3,1);
        assertEquals(node.getPrevious(), 1);
    }

    @Test
    public void shouldGetPreviousFromNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.getPrevious());
    }

    @Test
    public void shouldGetPreviousFrom_1_null_3_ReturnNull() {
        node = new DequeNode(1,2,null);
        assertEquals(node.getPrevious(), null);
    }

    @Test
    public void shouldConstructor_4_5_3_CreateDEQueue_3_4_5(){
        node = new DequeNode(4, 5, 3);
        assertEquals(node.getItem(), 4);
        assertEquals(node.getPrevious(), 3);
        assertEquals(node.getNext(), 5);
    }

    @Test
    public void shouldConstructor_4_null_3_CreateDEQueue_3_4(){
        node = new DequeNode(4, null, 3);
        assertEquals(node.getItem(), 4);
        assertEquals(node.getPrevious(), 3);
        assertEquals(node.getNext(), null);
    }

    @Test
    public void shouldConstructor_4_5_null_CreateDEQueue_4_5(){
        node = new DequeNode(4, 5, null);
        assertEquals(node.getItem(), 4);
        assertEquals(node.getPrevious(), null);
        assertEquals(node.getNext(), 5);
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
        assertThrows(RuntimeException.class, () -> new DequeNode(null, 5, 3));
    }

    @Test
    public void shouldConstructor_null_null_3_ThrowException(){
        assertThrows(RuntimeException.class, () -> new DequeNode(null, null, 3));
    }

    @Test
    public void shouldConstructor_null_5_null_ThrowException(){
        assertThrows(RuntimeException.class, () -> new DequeNode(null, 5, null));
    }

    @Test
    public void shouldConstructor_null_null_null_ThrowException(){
        assertThrows(RuntimeException.class, () -> new DequeNode(null, null, null));
    }


    @Test
    public void shouldGetNextFrom_2_3_1_Return_3() {
        node = new DequeNode(2,3,1);
        assertEquals(node.getNext(), 3);
    }

    @Test
    public void shouldGetNextFromNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.getNext());
    }

    @Test
    public void shouldGetNextFrom_1_null_3_ReturnNull() {
        node = new DequeNode(1,null,3);
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
        node = new DequeNode(1,3,null);
        assertEquals(node.isFirstNode(), true);
    }

    @Test
    public void shouldisFirstNodeFrom_1_3_2_Return_TRUE() {
        node = new DequeNode(1,3,2);
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
    public void shouldisLastNodeFrom_1_null_3_Return_TRUE() {
        node = new DequeNode(1,null,3);
        assertEquals(node.isLastNode(), true);
    }

    @Test
    public void shouldisLastNodeFrom_1_3_2_Return_FALSE() {
        node = new DequeNode(1,3,2);
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
        node = new DequeNode(2,3,1);
        assertEquals(node.isNotATerminalNode(), true);
    }

    @Test
    public void shouldisNotATerminalNodeFrom_1_null_null_Return_FALSE() {
        node = new DequeNode(1,null,null);
        assertEquals(node.isNotATerminalNode(), false);
    }

    @Test
    public void shouldisNotATerminalNodeFrom_1_2_null_Return_FALSE() {
        node = new DequeNode(1,2,null);
        assertEquals(node.isNotATerminalNode(), false);
    }

    @Test
    public void shouldisNotATerminalNodeFrom_1_null_2_Return_FALSE() {
        node = new DequeNode(1,null,2);
        assertEquals(node.isNotATerminalNode(), false);
    }

    @Test
    public void shouldisNotATerminalNodeFromNullThrowException() {
        node = null;
        assertThrows(RuntimeException.class,() -> node.isNotATerminalNode());
    }




}
