import java.util.Arrays;

public class ShellSort {


    public static void main(String[] args) {
        Character [] abc = {'I', 'H', 'B','G','E','D','F','C','A'};
        int [] intAbc = new int[abc.length];

        for(int i = 0; i< abc.length; i++){
            int x = abc[i];
            intAbc[i] = x-64;
        }


        shellSort(intAbc, 0, intAbc.length - 1);
        System.out.println(Arrays.toString(intAbc));

        for(int i : intAbc){
            char b = (char)(i+64);
            System.out.print(b);
        }

        int[] q4arr = {5, 7, 4, 9, 8, 5, 6, 3};
        shell(q4arr);
        System.out.println(Arrays.toString(q4arr));
    }

    static void shell(int a[]) {
        int n = a.length;
        /* Rearrange the array elements at n/2, n/4, ..., 1 intervals */
        for (int interval = n/2; interval > 0; interval /= 2)
        {
            for (int i = interval; i < n; i += 1)
            {
                /* store a[i] to the variable temp and make the ith position empty */
                int temp = a[i];
                int j;
                for (j = i; j >= interval && a[j - interval] > temp; j -= interval)
                    a[j] = a[j - interval];

                // put temp (the original a[i]) in its correct position
                a[j] = temp;
            }
        }
    }
    public static void shellSort(int[] arr, int first, int last){
        int n = arr.length;
        int space = n / 2;

        while (space > 0)
        {
            for (int begin=first; begin<= first+space-1; begin++)
            {
                incrementalInsertionSort(arr, begin, last, space);
            }
            space = space / 2;
        }
    }


    public static void incrementalInsertionSort(int[] arr, int first, int last, int space) {
        // Sorts equally spaced array entries a[first] through a[last] into ascending order.
        // first >= 0 and < a.length; last >= first and < a.length;
        // space is the difference between the indices of the entries to sort.
        for (int unsorted = first + space; unsorted<= last; unsorted+=space)
        {
            int nextToInsert = arr[unsorted];
            int index = unsorted-space;
            while ((index >= first) && (nextToInsert < arr[index]) )
            {
                arr[index + space] = arr[index];
                index -= space;
            }
            arr[index + space] = nextToInsert;
        }
    }

}
