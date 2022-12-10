public class MyLinkedDeque<T> implements DequeInterface<T> {

    Node<T> firstNode;

    public void initState(){
        this.firstNode = null;
    }

    public MyLinkedDeque() {
        initState();
    }


    public void addToFront(T newEntry) {

        Node<T> newNode = new Node<>(newEntry, null, null);
        if (isEmpty()) {
            newNode.pre = newNode;
            newNode.next = newNode;
        } else {
            Node<T> lastNode = firstNode.getPre();
            newNode = new Node<>(newEntry, lastNode, firstNode);
            firstNode.setPre(newNode);
            lastNode.setNext(newNode);
        }

        firstNode = newNode;

    }

    public void addToBack(T newEntry) {
        Node<T> newNode = new Node<>(newEntry, null, null);
        if (isEmpty()) {
            newNode.pre = newNode;
            newNode.next = newNode;
            firstNode = newNode;
        } else {
            Node<T> lastNode = firstNode.getPre();
            newNode = new Node<>(newEntry, lastNode, firstNode);
            firstNode.setPre(newNode);
            lastNode.setNext(newNode);
        }
    }

    public T removeFront() throws Exception {
        T removeData = getFront();
        Node<T> lastNode = firstNode.getPre();
        if (firstNode != lastNode) {
            firstNode = firstNode.getNext();
            // set chain for first and last node
            firstNode.setPre(lastNode);
            lastNode.setNext(firstNode);
        } else {
            initState();
        }
        return removeData;
    }

    public T removeBack() throws Exception {
        T removeData = getBack();
        Node<T> lastNode = firstNode.getPre();
        if(lastNode != firstNode) {
            lastNode = lastNode.getPre();
            // set chain for first and last node
            firstNode.setPre(lastNode);
            lastNode.setNext(firstNode);
        }else{
            initState();
        }
        return removeData;
    }

    public T getFront() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty deque");
        }
        return firstNode.data;
    }

    public T getBack() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty deque");
        }
        return firstNode.getPre().data;
    }

    public boolean isEmpty() {
        return (firstNode == null);
    }

    public void Clear() {
        initState();
    }

    public void displayDeque(){

        if(isEmpty()){
            System.out.println("Deque is empty");
        }else {
            System.out.println("********* Linked Deque [forward] *********");
            System.out.println(firstNode.data);
            for (Node<T> node = firstNode.next; node != firstNode; node = node.next) {
                System.out.println(node.data);
            }
            System.out.println("********* Linked Deque [backward] ********");
            for (Node<T> node = firstNode.pre; node != firstNode; node = node.pre) {
                System.out.println(node.data);
            }
            System.out.println(firstNode.data);
        }

        System.out.println("******************************************");
    }

    private static class Node<T> {
        T data;
        Node<T> pre;
        Node<T> next;

        public Node(T data, Node<T> pre, Node<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Node<T> getPre() {
            return pre;
        }

        public void setPre(Node<T> pre) {
            this.pre = pre;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public boolean hasNext(){
            return this.next!=null;
        }

        public boolean hasPre(){
            return this.pre!=null;
        }
    }
}
