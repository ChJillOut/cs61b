public class LinkedListDeque<type> {

    private class Node <type> {
        public type item;
        public Node prev;
        public Node next;

        public Node (type i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>(1, sentinel, sentinel);
        size = 0;
    }

    public LinkedListDeque (type x) {
        sentinel = new Node<>(1,null, null);
        sentinel.next = new Node(x,sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }


    public void addFirst(type item) {
        if (sentinel.next == null) {
            sentinel.next = new Node(item,sentinel, sentinel);
            sentinel.prev = sentinel.next;
            size += 1;
        }
        else {
            sentinel.next = new Node (item, sentinel, sentinel.next);
            sentinel.next.next.prev =  sentinel.next;
            size += 1;
        }

    }

    public void addLast(type item) {
        if (sentinel.prev == null) {
            sentinel.prev = new Node(item,sentinel, sentinel);
            sentinel.next = sentinel.prev;
            size += 1;
        }
        else {
            sentinel.prev.next = new Node(item, sentinel.prev, sentinel);
            sentinel.prev = sentinel.prev.next;
            size += 1;
        }
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            type i = (type) p.next.item;
            System.out.print(i + " ");
            p = p.next;
        }
    }
    public type removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        Node remove = new Node (sentinel.next.item, sentinel, sentinel.next.next);
        sentinel.next.next = null;
        sentinel.next.prev = null;
        sentinel.next.item = null;
        sentinel.next = remove.next;
        remove.next.prev = sentinel;
        size -= 1;
        return (type) remove.item;

    }

    public type removeLast() {
        Node remove = new Node(sentinel.prev.prev.item, sentinel.prev.prev, sentinel);
        sentinel.prev.item = null;
        sentinel.prev = remove.prev;
        remove.prev.next = sentinel;
        size -= 1;
        return (type) remove.item;

    }

    public type get(int index) {
        if (index >= this.size) {
            return null;
        }
        Node p = sentinel.next;
        int count = 0;
        type it = null;
        while (count < index) {
            it = (type) p.item;
            p = p.next;
            count += 1;
        }
        return it;

    }

    public type getRecursiveHelper(Node p, int index) {
        if (index == 0) {
            return (type) p.item;
        } else {
            return getRecursiveHelper(p.next, index - 1);
        }
    }

    public type getRecursive(int index) {
        if (index >= this.size) {
            return null;
        }
        else {
            Node p = sentinel.next;
            return getRecursiveHelper(p,index);
        }

    }

    public static void main (String[] args) {
        LinkedListDeque L = new LinkedListDeque(10);
        L.addFirst(2);
        L.addLast(3);
        L.printDeque();
    }
}
