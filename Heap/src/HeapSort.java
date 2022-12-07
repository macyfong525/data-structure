import java.util.Arrays;

public class HeapSort<E extends Comparable<E>>{
    // index starting from 0
    public static <T extends Comparable<? super T>>
    void heapSort(T[] array, int n) {
        // Create first heap
        for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--)
            reheap(array, rootIndex, n - 1);

        swap(array, 0, n - 1);

        for (int lastIndex = n - 2; lastIndex > 0; lastIndex--) {
            reheap(array, 0, lastIndex);
            swap(array, 0, lastIndex);
        }
    }

    public static void swap(Object[] arr, int x, int y){
        Object temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static <T extends Comparable<? super T>>
    void reheap(T[] heap, int rootIndex, int lastIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex + 1;

        while (!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if ((rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex;
            } // end if

            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex + 1;
            } else
                done = true;
        }
        heap[rootIndex] = orphan;
    }

    public static void main(String[] args) {
        HeapSort<Integer> heap = new HeapSort<>();
        Integer[] arr = {3,8,2,0,7};
        heap.heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
