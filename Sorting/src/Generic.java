import java.util.ArrayList;
import java.util.Arrays;

public class Generic {

    ArrayList<Integer> arrayList = new ArrayList<>();
    public static <T> void displayArray(T[] anArray){
        for ( T item : anArray){
            System.out.printf("%s ", item);
        }
        System.out.println();
    }

    public static <T extends Comparable<? super T>> void arrayMin(T[] anArray){
        T min = anArray[0];
        for (T i: anArray){
            if(i.compareTo(min)<0){ // i is less than min
                min = i;
            }
        }
        System.out.println(min);

    }


    public static void main(String[] args) {
        String[] stringArray = {"apple", "banana", "carrot", "pear"};
        displayArray(stringArray);

        Character[] charArray = {'a', 'b', 'c', 'd'};
        displayArray(charArray);

        Integer[] intArray = {15, 8, 10, 2, 5};
        arrayMin(intArray);

        // selection Sort in Generic
        Integer[] intArray1 = {15, 8, 10, 2, 5, 8 ,0, -1};
        Integer[] intArray2 = {15, 8, 10, 2, 5, 8 ,0, -1};

        selectionSort(intArray1, intArray1.length); // iterative
        recurSelectionSort(intArray2, 0); // recursion
        System.out.println(Arrays.toString(intArray1));
        System.out.println(Arrays.toString(intArray2));

    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n)
    {
        for (int index = 0; index < n - 1; index++)
        {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1); // n-1 => last index
            swap(a, index, indexOfNextSmallest);
        }
    }
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last)
    {
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++)
        {
            if (a[index].compareTo(min) < 0)
            {
                min = a[index];
                indexOfMin = index;
            }
        }

        return indexOfMin;
    }
    public static <T> void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> T[] recurSelectionSort(T[] arr, int index){
        if(index == arr.length-1){
            return arr;
        }
        swap(arr, index, findMin(arr, index, arr.length-1));
//        swap(arr, index, findMin(arr, index, index+1));
        return recurSelectionSort(arr, index+1);

    }

    public static <T extends Comparable<T>> int findMin(T[] arr, int index, int minIndex) {
        // base case
        if(index== arr.length){
            return minIndex;
        }

        if(arr[index].compareTo(arr[minIndex])<0){
            minIndex = index;
        }

        return findMin(arr, index+1, minIndex);
    }
}
