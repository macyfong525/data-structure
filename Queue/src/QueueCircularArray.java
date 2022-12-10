public class QueueCircularArray<T> implements QueueInterface<T> {

    public int frontIndex;
    public int backIndex;
    public T[] cirularList;
    public static final int capacity = 6;
    public int size;

    public QueueCircularArray() {
        this(capacity);
    }

    @SuppressWarnings("unchecked")
    public QueueCircularArray(int initCap) {
        frontIndex = 0;
        backIndex = capacity;
        cirularList = (T[]) new Object[initCap + 1];
    }


    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % cirularList.length)) {
            T[] oldQueue = cirularList;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;

            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            cirularList = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                cirularList[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }

            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }


    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % cirularList.length;
        cirularList[backIndex] = newEntry;
        size++;
    }

    @Override
    public T dequeue() {
        T front = cirularList[frontIndex];
        cirularList[frontIndex] = null;
        frontIndex = (frontIndex + 1) % cirularList.length;
        size--;
        return front;
    }

    @Override
    public T getFront() {
        return cirularList[frontIndex];
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % cirularList.length);
    }

    @Override
    public void clear() {
        size = 0;
        frontIndex = 0;
        backIndex = 6;
        cirularList = (T[]) new Object[capacity + 1];
    }

    public static void main(String[] args) {
        QueueCircularArray<String> test = new QueueCircularArray<>();
        test.enqueue("A");
        test.enqueue("B");
        test.enqueue("C");
        test.enqueue("D");
        test.enqueue("E");
        test.enqueue("F");
        test.enqueue("G");
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
    }
}
