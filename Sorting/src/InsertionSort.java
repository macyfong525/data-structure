import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] q4arr = {5, 4, 4, 9, 8, 5, 6, 3};
        insertSort(q4arr);
        System.out.println(Arrays.toString(q4arr));

        int[] arr = {5, 7, 4, 9, 8, 5, 6, 3};
        insertionSortRecursion(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr){
        for(int i=1; i<arr.length;i++){
            int insertValue = arr[i];
            int last;
            for(last=i-1;last>=0 && insertValue<arr[last]; last=last-1){
                arr[last+1] = arr[last]; // Make room
//                last--;
            }
            arr[last+1] = insertValue; // Insert
        }
    }

    public static void insertionSortRecursion(int[] a, int first, int last)
    {
        if (first < last) {
            // Sort all but the last entry
            insertionSortRecursion(a, first, last - 1);

            // Insert the last entry in sorted order
            insertInOrderRecursion(a[last], a, first, last - 1);
        }
    }


    public static void insertInOrderRecursion(int anEntry, int[] a, int begin, int end) {
        // Inserts anEntry into the sorted array entries a[begin] through a[end].
        if(begin <= end && anEntry < a[end]){
            a[end + 1] = a[end];
            insertInOrderRecursion(anEntry, a, begin, end-1);
        } else {
            a[end + 1] = anEntry;
        }
    }
}
