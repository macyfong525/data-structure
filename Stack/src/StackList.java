import java.util.Arrays;

// TODO add capacity and check grow shrink
public class StackList<T> implements StackInterface<T> {
    private T[] arrayList;
    int size;


//    public void checkCapacity(){
//        if(size+1>=capacity){
//            capacity*=2;
//            cirularList = Arrays.copyOf(cirularList, capacity);
//        }
//    }

    @SuppressWarnings("unchecked")
    public StackList() {
        this.size = 0;
        this.arrayList = (T[]) new Object[0];
    }

    private T[] grow() {
        int newCapacity = size + 1;
        return Arrays.copyOf(arrayList, newCapacity);
    }

    private T[] shrink() {
        int newCapacity = size - 1;
        return Arrays.copyOf(arrayList, newCapacity);
    }

    public void push(T newEntry) {
        arrayList = grow();
        arrayList[size] = newEntry;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        T popData = arrayList[size - 1];
        arrayList = shrink();
        size--;
        return popData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return arrayList[size - 1];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        size = 0;
        arrayList = (T[]) new Object[0];
        ;
    }
}
