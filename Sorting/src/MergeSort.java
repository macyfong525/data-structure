import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int[] tempArr,int first, int last){
        if(first<last){
            int mid = (first+last)/2;
            mergeSort(arr, tempArr, first, mid);
            mergeSort(arr, tempArr, mid+1, last);
            merge(arr, tempArr, first, mid, last);
        }
    }

    public static void merge(int[] arr, int[] tempArr,int first, int mid,  int last){
        int[] firstHalf = {first, mid};
        int[] secondHalf = {mid+1, last};

        int index = first;
        while((firstHalf[0]<=firstHalf[1])&&(secondHalf[0]<=secondHalf[1])){
            if(arr[firstHalf[0]]>=arr[secondHalf[0]]){
                tempArr[index] = arr[firstHalf[0]];
                firstHalf[0]++;
            }else{
                tempArr[index] = arr[secondHalf[0]];
                secondHalf[0]++;
            }
            index++;
        }

        while((firstHalf[0]<=firstHalf[1])){
            tempArr[index] = arr[firstHalf[0]];
            firstHalf[0]++;
            index++;
        }

        while((secondHalf[0]<=secondHalf[1])){
            tempArr[index] = arr[secondHalf[0]];
            secondHalf[0]++;
            index++;
        }

        for(int i=0; i<index;i++){
            arr[i] = tempArr[i];
        }
    }

    // code from GeeksforGeeks
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }



    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        int[] tempArr = new int[array.length];
        mergeSort(array, tempArr, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        int[] array2 = {7,5,9,3,6,0,2,4};
        MergeSort ob = new MergeSort();
        ob.sort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }
}
