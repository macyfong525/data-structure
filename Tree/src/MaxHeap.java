import java.util.Arrays;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
    // reheap index starting from 1
    private T[] heap;      // Array of heap entries; ignore heap[0]
    private int lastIndex; // Index of last entry and number of entries
    private static final int DEFAULT_CAPACITY = 25;

    public MaxHeap(T[] entries) {
        this(entries.length);
        lastIndex = entries.length;
        // Copy given array to data field
        for (int index = 0; index < entries.length; index++)
            heap[index + 1] = entries[index];
        // Create heap
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
            reheap(rootIndex);
    }

    public MaxHeap(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
    }

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }


    @Override
    public void add(T newEntry) {
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while (parentIndex > 0 && newEntry.compareTo(heap[parentIndex]) > 0) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex /= 2;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    private void ensureCapacity() {
        int capacity = heap.length;
        if (lastIndex >= capacity) {
            int newCapacity = 2 * capacity;
            heap = Arrays.copyOf(heap, newCapacity);
        }
    }


    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while (!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex; // Assume larger
            int rightChildIndex = leftChildIndex + 1;

            if ((rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            } else
                done = true;
        }
        heap[rootIndex] = orphan;
    }


    @Override
    public T removeMax() {
        T root = null;

        if (!isEmpty()) {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }

        return root;

    }

    @Override
    public T getMax() {
        T root = null;
        if (!isEmpty())
            root = heap[1];
        return root;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex < 1;
    }

    @Override
    public int getSize() {
        return lastIndex;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= lastIndex; i++) {
            heap[i] = null;
        }
        lastIndex = 0;
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
        for (int i = 1; i <= lastIndex; i++) {
            System.out.println("Parent: " + heap[i] + " Leftchild: " + heap[i * 2] + " RightChild " + heap[i * 2 + 1]);
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {3, 8, 2, 1, 7, 9, 4, 6, 5};
        MaxHeap<Integer> obj = new MaxHeap<>(arr);
        obj.print();
    }
}
