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
        if (initialCapacity < DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        }

        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity + 1];
        list = tempList;
        size = 0;
    }

    private void ensureCapacity() {
        int capacity = list.length - 1;
        if (size >= capacity) {
            int newCapacity = 2 * capacity;
            list = Arrays.copyOf(list, newCapacity + 1);
        }
    }

    private void makeRoom(int givenIndex) {
        for (int i = size; i > givenIndex; i--) {
            list[i] = list[i - 1];
        }
    }


    public void add(T newEntry) {
        add(size, newEntry);
    }

    public void add(int newIndex, T newEntry) {
        if ((newIndex >= 0) && (newIndex <= size)) {
            for (int i = size; i > newIndex; i--) {
                list[i] = list[i - 1];
            }
            list[newIndex] = newEntry;
            size++;
            ensureCapacity();
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }

    }

    public T remove(int givenIndex) {
        if ((givenIndex >= 0) && givenIndex <= size - 1) {
            T removeData = list[givenIndex];
            for (int i = givenIndex; i < size; i++) {
                list[i] = list[i + 1];
            }
            size--;
            return removeData;
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }

    }

    public void clear() {
        for (int to = size, i = size = 0; i < to; i++) {
            list[i] = null;
        }
    }

    public T replace(int givenIndex, T newEntry) {
        if (givenIndex >= 0 && givenIndex <= size - 1) {
            list[givenIndex] = newEntry;
            return newEntry;
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public T getEntry(int givenIndex) {
        if (givenIndex >= 0 && givenIndex <= size - 1) {
            return list[givenIndex];
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public T[] toArray() {
        return Arrays.copyOf(list, size);
    }

    public boolean contains(T anEntry) {
        for (T i : list) {
            return anEntry.equals(i);
        }
        return false;
    }

    public int getLength() {
        return size;
    }

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
