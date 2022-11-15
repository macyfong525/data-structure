public interface StackInterface<T> {
    /**
     * Adds a new entry to the top of this stack
     *
     * @param newEntry an object to be added to the stack
     */
    public void push(T newEntry);

    /**
     * Removes and returns the stacks top entry
     *
     * @return the object at the top of stack
     * @throws java.util.EmptyStackException is the stack is empty before the operation.
     */
    public T pop();

    /**
     * Retrieves this stacks top entry
     *
     * @return the object at the top of the stack
     * @throws
     */
    public T peek();

    /**
     * Whether the stack is empty
     *
     * @return true if the list is empty, false if not
     */
    public boolean isEmpty();

    /**
     * removes all the entry from the stack
     */
    public void clear();
}
