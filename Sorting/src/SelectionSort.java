import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] q4arr = {5, 7, 4, 9, 8, 5, 6, 3};
        selectionSort(q4arr);
        System.out.println(Arrays.toString(q4arr));
    }

    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int min = getMinIndex(arr, i);
            swap(arr, min, i);
        }
    }

    public static int getMinIndex(int[] arr, int begin){
        int min=begin;
        for(int i=begin+1; i<arr.length; i++){
            if(arr[i]<arr[min]){
                min = i;
            }
        }
        return min;
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
