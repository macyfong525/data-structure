public interface DequeInterface<T> {
    /**
     * Adds a new entry to the front of the deque.
     * @param newEntry  An object to be added
     */
    public void addToFront(T newEntry);

    /**
     * Adds a new entry to the back of the deque.
     * @param newEntry  An object to be added
     */
    public void addToBack(T newEntry);

    /**
     * removes and returns the front entry of the deque.
     * @return The object at the front of the deque.
     * @throws Exception if the deque is empty before the operation.
     */
    public T removeFront() throws Exception;

    /**
     * removes and returns the back entry of the deque.
     * @return The object at the back of the deque.
     * @throws Exception if the deque is empty before the operation.
     */
    public T removeBack() throws Exception;

    /**
     * retrieves the front entry of the deque.
     * @return The object at the front of the deque.
     * @throws Exception if the deque is empty before the operation.
     */
    public T getFront() throws Exception;

    /**
     * retrieves the back entry of the deque.
     * @return The object at the back of the deque.
     * @throws Exception if the deque is empty before the operation.
     */
    public T getBack() throws Exception;

    /**
     * Sees whether the deque is empty.
     * @return  True if the deque is empty, or false otherwise
     */
    public boolean isEmpty();

    /**
     * removes all entries from the deque
     */
    public void Clear();

    /**
     * display all chain data
     */
    public void displayDeque();
}
