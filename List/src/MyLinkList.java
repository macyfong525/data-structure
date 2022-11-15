import java.util.Arrays;

public class MyLinkList<T> implements ListInterface<T> {
    private Node firstNode;
    private Node lastNode;
    private int size;

    public MyLinkList() {
        initState();
    }

    public void initState() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);

        lastNode = newNode;
        size++;
    }

    public void add(int newIndex, T newEntry) {
        if ((newIndex >= 0) && (newIndex <= size)) {
            Node newNode = new Node(newEntry);
            if (isEmpty()) {
                firstNode = newNode;
                lastNode = newNode;
            } else if (newIndex == 0) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else if (newIndex == size) {
                lastNode.setNextNode(newNode);
                lastNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(newIndex - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            } // end if
            size++;
        } else
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
    }

    public T remove(int givenIndex) {
        T result = null;
        if ((givenIndex >= 0) && (givenIndex <= size - 1)) {
            if (givenIndex == 0) {
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
            } else {
                Node nodeBefore = getNodeAt(givenIndex - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();
                nodeBefore.setNextNode(nodeToRemove.getNextNode());
                if (givenIndex == size - 1) {
                    lastNode = nodeBefore;
                }
            }
            size--;
        } else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        return result;
    }

    public void clear() {
        initState();
    }

    public T replace(int givenIndex, T newEntry) {
        if ((givenIndex >= 0) && (givenIndex <= size - 1)) {
            Node desiredNode = getNodeAt(givenIndex);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        } else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    }

    public T getEntry(int givenIndex) {
        if ((givenIndex >= 0) && (givenIndex <= size - 1)) {
            return getNodeAt(givenIndex).getData();
        } else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[size];

        int index = 0;
        for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.nextNode) {
            result[index++] = currentNode.getData();
        }
        return result;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        for (Node curr = firstNode; curr != null; curr = curr.getNextNode()) {
            if (anEntry.equals(curr.getData())) {
                found = true;
                break;
            }
        }
        return found;
    }

    public int getLength() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNodeAt(int givenIndex) {
        Node currentNode = firstNode;
        for (int counter = 0; counter < givenIndex; counter++)
            currentNode = currentNode.getNextNode();
        return currentNode;
    }

    private class Node {
        T newEntry;
        Node nextNode;

        public Node(T newEntry) {
            this.newEntry = newEntry;
            this.nextNode = null;
        }

        public void setData(T entry) {
            this.newEntry = entry;
        }

        public T getData() {
            return newEntry;
        }

        public void setNextNode(Node node) {
            nextNode = node;
        }

        public Node getNextNode() {
            return nextNode;
        }
    }

    public static void main(String[] args) {
        ListInterface<Integer> test = new MyLinkList<>();
        test.add(0);
        test.add(2);
        test.add(1, 1);
        test.add(4);
        test.replace(3, 3);
        test.remove(2);
        System.out.println(test.isEmpty());
        System.out.println(test.contains(4));
        System.out.println(test.getEntry(1));
        System.out.println(Arrays.toString(test.toArray()));
        System.out.println(test.getLength());
        test.clear();
        System.out.println(test.isEmpty());
    }
}
