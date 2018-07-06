package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

    ArrayRingBuffer arb = new ArrayRingBuffer(5);


    @Test
    public void testEnqueueDequeue() {
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        for (int i = 1; i < arb.capacity + 1; i += 1) {
            assertEquals(i, arb.dequeue());
        }

    }

    @Test
    public void testPeek() {
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        assertEquals(1,arb.peek());
    }

        /** Calls tests for ArrayRingBuffer. */
        public static void main (String[] args) {
            jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
        }

}
