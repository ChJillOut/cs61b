package synthesizer;

public abstract class AbstractBoundedQueue<type> implements BoundedQueue<type> {
    protected int fillCount;
    protected int capacity;
    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    @Override
    public boolean isEmpty() {
        return fillCount() == 0;
    }

    @Override
    public boolean isFull() {
        return fillCount() == capacity();
    }

    public abstract type peek();

    public abstract type dequeue();

    public abstract void enqueue(type x);
}
