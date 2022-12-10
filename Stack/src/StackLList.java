public class StackLList<T> implements StackInterface<T> {
    private Node<T> firstNode;

    public StackLList() {
        this.firstNode = null;
    }

    public void push(T newEntry) {
        Node<T> newNode = new Node<T>(newEntry, firstNode);
        firstNode = newNode;
    }

    public T pop() {
        T popData = peek();
        firstNode = firstNode.next;
        return popData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return firstNode.data;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void clear() {
        firstNode = null;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
