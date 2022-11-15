import java.util.EmptyStackException;
import java.util.Vector;

public class StackVector<T> implements StackInterface<T> {

    private Vector<T> stack;

    public StackVector() {
        this.stack = new Vector<>();
    }

    public void push(T newEntry) {
        stack.add(newEntry);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack.lastElement();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clear() {
        stack.clear();
    }
}
