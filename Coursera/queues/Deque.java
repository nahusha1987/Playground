import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    private int n;
    private Node front;
    private Node back;

    // construct an empty deque
    public Deque() {
        front = null;
        back = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return front == null;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (isEmpty()) {
            Node firstItem = new Node();
            firstItem.item = item;
            firstItem.next = null;
            firstItem.prev = null;
            front = firstItem;
            back = firstItem;
            n++;
            return;
        }
        Node newItem = new Node();
        newItem.item = item;
        newItem.next = front;
        newItem.prev = null;
        front.prev = newItem;
        front = newItem;
        n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (isEmpty()) {
            Node firstItem = new Node();
            firstItem.item = item;
            firstItem.next = null;
            firstItem.prev = null;
            front = firstItem;
            back = firstItem;
            n++;
            return;
        }
        Node newItem = new Node();
        newItem.item = item;
        newItem.next = null;
        newItem.prev = back;
        back.next = newItem;
        back = newItem;
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (n == 1) {
            Node removedItem = front;
            front = null;
            back = null;
            n--;
            return removedItem.item;
        }
        Node removedItem = front;
        front = front.next;
        front.prev = null;
        n--;
        return removedItem.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (n == 1) {
            Node removedItem = front;
            front = null;
            back = null;
            n--;
            return removedItem.item;
        }
        Node removedItem = back;
        back = back.prev;
        back.next = null;
        n--;
        return removedItem.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<>();
        queue.addFirst(10);
        queue.addFirst(20);
        queue.addFirst(30);
        queue.addLast(40);
        StdOut.println(queue.removeFirst());
        StdOut.println(queue.removeLast());
        StdOut.println(queue.removeLast());
        StdOut.println(queue.removeLast());

        StdOut.println("(" + queue.size() + " item(s) left on queue)");
        StdOut.println();
        StdOut.println("Enter Number of Items");
        int t = StdIn.readInt();
        for (int i = 0; i < t; i++)
            queue.addFirst(i);
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }
        StdOut.println("(" + queue.size() + " item(s) left on queue)");
        /*
        Deque<String> deque = new Deque<>();
        In in = new In("/home/xaos/Downloads/queues/mediumTale.txt");
        String[] strings = in.readAllStrings();
        for (String string : strings)
            deque.addLast(string);
        while (!deque.isEmpty())
            StdOut.print(deque.removeLast() + " ");
         */
    }
}
