public class MyLinkedQueue<T> implements QueueInterface<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;

    public MyLinkedQueue() {
        this.firstNode = null;
        this.lastNode = null;
    }

    @Override
    public void enqueue(T newEntry) {
        Node<T> newNode = new Node<>(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        T removeData = firstNode.data;
        firstNode = firstNode.next;
        if (firstNode == null)
            lastNode = null;
        return removeData;
    }

    @Override
    public T getFront() {
        return firstNode.data;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null && lastNode == null);
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    private static class Node<T> {
        private Node<T> next;
        private final T data;

        public Node(T data, Node<T> next) {
            this.next = next;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        QueueInterface<Integer> test = new MyLinkedQueue<>();
        test.enqueue(0);
        System.out.println(test.isEmpty());
        test.enqueue(1);
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        test.clear();
        System.out.println(test.isEmpty());
    }
}
