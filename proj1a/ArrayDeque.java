public class ArrayDeque <type> {
    private type[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int endIndex;
    private int startIndex;
    private double usageFactor = 0.25;
    private int resizeFactor = 2;
    private double currUsage;

    public ArrayDeque() {
        items = (type [])new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        endIndex = 7;
        startIndex = 0;

    }

    private boolean checkUsage() {
        currUsage = (double) size/items.length;
        return (currUsage < usageFactor);
    }

    private void decrease() {
        if (checkUsage()) {
            type[] a = (type[]) new Object[items.length/2];
            endIndex = items.length/2 - 1;
            System.arraycopy(items,0,a,0,items.length/2);
            items = a;

        }
    }

    private void resize (int capacity) {
        type[] a = (type[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
        endIndex = capacity - 1;
    }

    private int calculateLastIndex (int index) {
        if (index > endIndex) {
            index = startIndex;
        }
        return index;
    }

    private int calculateFirstIndex (int index) {
        if (index < 0) {
            index = endIndex + 1 + index;
        }
        return index;
    }


    public void addFirst(type item) {
        if (size == items.length) {
            resize(size*resizeFactor);
        }
        nextFirst = calculateFirstIndex (nextFirst);
        items[nextFirst] = item;
        nextFirst -= 1;
        size += 1;
        decrease();

    }

    public void addLast(type item) {
        if (size == items.length) {
            resize(size*resizeFactor);
        }
        nextLast = calculateLastIndex(nextLast);
        items[nextLast] = item;
        nextLast += 1;
        size += 1;
        decrease();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    private int calculateLastIndex2 (int index) {
        if (index == startIndex) {
            index = endIndex;
            return index;
        }
        else {
            index -= 1;
            return index;
        }

    }

    private int calculateFirstIndex2 (int index) {
        if (index == endIndex) {
            index = startIndex;
            return index;
        }
        else{
            index += 1;
            return index;
        }
    }

    public type removeFirst() {
        if (this.size == 0) {
            return null;
        }
        nextFirst = calculateFirstIndex2(nextFirst);
        type removedItem = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        decrease();
        return removedItem;
    }

    public type removeLast() {
        if (this.size == 0) {
            return null;
        }
        nextLast = calculateLastIndex2(nextLast);
        type removedItem = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        decrease();
        return removedItem;
    }

    public void printDeque() {
        int head = calculateFirstIndex2(nextFirst);
        for (int i = 0; i < this.size; i++) {
            System.out.print(items[head]+" ");
            head = calculateFirstIndex2(head);
        }
    }

    public type get(int index) {
        if (this.size == 0) {
            return null;
        }
        int head = calculateFirstIndex2(nextFirst);
        while (index > 0) {
            head = calculateFirstIndex2(head);
            index -= 1;
        }
        return items[head];
    }


    public static void main (String[] args) {
        ArrayDeque A = new ArrayDeque();
        A.addLast(1);
        A.addLast(1);
        A.addLast(1);
        A.addLast(1);
        A.addLast(1);
        A.addFirst(2);
        A.addFirst(2);
        A.addFirst(2);
        A.addLast(1);
        A.addFirst(3);
        A.removeLast();
        A.printDeque();
        System.out.println(A.get(0));
    }


}
