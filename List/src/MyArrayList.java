import java.util.Arrays;

public class MyArrayList<T> implements ListInterface<T> {
    private int size; // size of array
    private T[] list; // Array of list entries
    private static final int DEFAULT_CAPACITY = 25;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        // check capacity
        initialCapacity = Math.max(initialCapacity, DEFAULT_CAPACITY);

        list = (T[]) new Object[initialCapacity + 1];
        size = 0;
    }

    private void ensureCapacity() {
        int capacity = list.length - 1;
        if (size >= capacity) {
            int newCapacity = 2 * capacity;
            list = Arrays.copyOf(list, newCapacity + 1);
        }
    }

    @Override
    public void add(T newEntry) {
        add(size, newEntry);
    }

    @Override
    public void add(int newIndex, T newEntry) {
        if (newIndex < 0 || newIndex > size) throw new IndexOutOfBoundsException("Index out of range");

        for (int i = size; i > newIndex; i--) {
            list[i] = list[i - 1];
        }

        list[newIndex] = newEntry;
        size++;

        ensureCapacity();
    }

    @Override
    public T remove(int givenIndex) {
        if (givenIndex < 0 || givenIndex >= size) throw new IndexOutOfBoundsException("Index out of range");

        T removeData = list[givenIndex];

        for (int i = givenIndex; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;

        return removeData;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public T replace(int givenIndex, T newEntry) {
        if (givenIndex < 0 || givenIndex >= size) throw new IndexOutOfBoundsException("Index out of range");

        list[givenIndex] = newEntry;
        return newEntry;
    }

    @Override
    public T getEntry(int givenIndex) {
        if (givenIndex < 0 || givenIndex >= size) throw new IndexOutOfBoundsException("Index out of range");

        return list[givenIndex];
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(list, size);
    }

    public boolean contains(T anEntry) {
        for (T i : list) {
            if (anEntry.equals(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getLength() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ListInterface<String> test = new MyArrayList<>();
        System.out.println(test.isEmpty());
        test.add("ABC");
        test.add("GHI");
        test.add(1, "DEF");
        test.add("JKL");
        System.out.println(test.getEntry(1));
        System.out.println(test.contains("ABC"));
        test.remove(2);
        System.out.println(test.getLength());
        System.out.println(Arrays.toString(test.toArray()));
        test.clear();
        System.out.println(test.getLength());
        System.out.println(Arrays.toString(test.toArray()));
    }

}
