public class StackLList<T> implements StackInterface<T> {
    private Node<T> firstNode;
    private int numberOfEntries;

    public StackLList() {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }

    public void push(T newEntry) {
        Node<T> newNode = new Node<T>(newEntry);

        if (!isEmpty()) {
            newNode.setNext(firstNode);
        }
        firstNode = newNode;
        numberOfEntries++;
    }

    public T pop() {
        T popData = peek();
        firstNode = firstNode.getNext();
        numberOfEntries--;
        return popData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return firstNode.getData();
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
