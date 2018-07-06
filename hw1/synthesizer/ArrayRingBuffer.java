// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<type> extends AbstractBoundedQueue<type> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private type[] rb;

    @Override
    public Iterator<type> iterator() {
        return new QueueIterator();
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (type[]) new Object[capacity];
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(type x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (this.isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }

        rb[last] = x;
        last += 1;
        fillCount += 1;
        if (last == capacity) {
            last = 0;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public type dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (this.isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        type removedItem = rb[first];
        rb[first] = null;
        first += 1;
        if (first == capacity) {
            first = 0;
        }
        fillCount -= 1;
        return removedItem;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public type peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class QueueIterator<type> implements Iterator<type> {
        private int ptr;
        public QueueIterator() {
            ptr = 0;
        }

        public boolean hasNext() {
            return (ptr != capacity);
        }

        public type next() {
            type returnItem = (type) rb[ptr];
            ptr = ptr + 1;
            return returnItem;
        }
    }
}
