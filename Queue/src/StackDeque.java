public class StackDeque<T> {

    DequeInterface<T> mystack;

    public StackDeque() {
        mystack = new MyLinkedDeque<>();
    }

    // adds a new entry to the top of the stack
    public void push(T newEntry) {
        mystack.addToFront(newEntry);
    }
    // Removes and returns the stack’s top entry
    public T pop () throws Exception {
        return mystack.removeFront();
    }
    // Retrieves the stack’s top entry without changing the stack in any way.
    public T peek () throws Exception {
        return mystack.getFront();
    }
    // Detects whether the stack is empty.
    public boolean isEmpty() {
        return mystack.isEmpty();
    }

    // Removes all entries from the stack.
    public void clear(){
        mystack.Clear();
    }
}
