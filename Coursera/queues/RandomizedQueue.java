import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int n;
    private int last;

    // construct an empty randomized queue
    public RandomizedQueue() {
        n = 0;
        queue = (Item[]) new Object[1];
        last = -1;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        n++;
        if (size() == queue.length)
            resize(queue.length * 2);
        queue[++last] = item;
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (queue[i] != null)
                copy[j++] = queue[i];
        }
        queue = copy;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        /* if (size() == 1) {
            Item returnItem = queue[last];
            queue[last] = (Item) new Object();
            last--;
            n--;
            return returnItem;
        } */
        int index = StdRandom.uniform(n);
        Item returnItem = queue[index];
        queue[index] = queue[last];
        queue[last] = null;
        last--;
        n--;
        if (size() == queue.length / 4 && queue.length > 0)
            resize(queue.length / 2);
        return returnItem;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        int index = StdRandom.uniform(n);
        return queue[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private Item[] iteratorItem;
        private int iteratorSize;
        private int lastIndex;

        public RandomIterator() {
            iteratorItem = (Item[]) new Object[n];
            iteratorSize = n;
            lastIndex = iteratorSize - 1;
            for (int i = 0; i < iteratorSize; i++) {
                iteratorItem[i] = queue[i];
            }
        }

        @Override
        public boolean hasNext() {
            return iteratorSize > 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int randomIndex = StdRandom.uniform(iteratorSize);
            Item returnItem = iteratorItem[randomIndex];
            iteratorItem[randomIndex] = iteratorItem[lastIndex];
            iteratorItem[lastIndex] = null;
            lastIndex--;
            iteratorSize--;
            return returnItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(10);
        StdOut.println(rq.dequeue()); //     ==> 10
        StdOut.println(rq.isEmpty()); //    ==> true
        StdOut.println(rq.size()); //        ==> 0
        StdOut.println(rq.isEmpty()); //     ==> true
        rq.enqueue(30);

        RandomizedQueue<Integer> myQueue = new RandomizedQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        StdOut.println("Item(s) left on the queue " + myQueue.size());

        StdOut.println(myQueue.dequeue());
        StdOut.println(myQueue.dequeue());
        StdOut.println(myQueue.dequeue());

        StdOut.println("Item(s) left on the queue " + myQueue.size());

        StdOut.println(myQueue.sample());
        StdOut.println(myQueue.sample());
        StdOut.println(myQueue.dequeue());
        StdOut.println(myQueue.dequeue());

        StdOut.println("Item(s) left on the queue " + myQueue.size());
        StdOut.println("Adding new items");
        for (int i = 0; i < 100; i++)
            myQueue.enqueue(i);
        StdOut.println(myQueue.dequeue());
        StdOut.println("Item(s) left on the queue " + myQueue.size());
        for (Integer integer : myQueue) {
            for (int f : myQueue)
                StdOut.println(integer + "-" + f);
        }
    }
}
