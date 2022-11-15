import java.util.Arrays;

public class QuickSort {
//    int partition;
//    int pivot;

    public void quickSort(int[] arr, int low, int high){
        if(low<high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition-1);
            quickSort(arr, partition+1, high);
        }
    }
    public int partition(int[] arr, int first , int last) {
        int mid = (first + last) / 2;
        sortFirstMiddleLast(arr, first, mid, last);
        swap(arr, mid, last-1);
        int pivotIndex = last-1;
        int pivot = arr[pivotIndex];

        int indexFromleft = first +  1;
        int indexFromRight = last - 2;
        boolean done = false;
        while (!done) {
            while (arr[indexFromleft] < pivot) {
                indexFromleft++;
            }
            while (arr[indexFromRight] > pivot) {
                indexFromRight--;
            }
            if (indexFromleft < indexFromRight) {
                swap(arr, indexFromleft, indexFromRight);
                indexFromleft++;
                indexFromRight--;
            } else {
                done = true;
            }
        }
        swap(arr, pivotIndex, indexFromleft);
        return indexFromleft;
    }

    public void sortFirstMiddleLast(int[] arr, int first, int mid, int last){
            if(arr[first]>arr[mid]){
                swap(arr, first, mid);
            }
            if(arr[mid]>arr[last]){
                swap(arr, last, mid);
                if(arr[first]>arr[mid]){
                    swap(arr, first, mid);
                }
            }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {7, 27, 43, 3, 9, 82, 10};
        QuickSort obj = new QuickSort();
        obj.quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
