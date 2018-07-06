package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<type> extends Iterable<type> {
    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently in the buffer
    void enqueue(type x);  // add item x to the end
    type dequeue();        // delete and return item from the front
    type peek();           // return (but do not delete) item from the front
    // is the buffer empty (fillCount equals zero)?
    default boolean isEmpty() {
        return fillCount() == 0;
    }
    // is the buffer full (fillCount is same as capacity)?
    default boolean isFull() {
        return fillCount() == capacity();
    }
    Iterator<type> iterator();
}
