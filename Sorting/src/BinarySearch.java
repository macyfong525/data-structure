public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 8, 10, 13, 15, 20, 22, 26, 30, 31, 34, 40};

        int searchValue = 6;
        int searchValue2 = 34;
        int result = binarySearch(arr, 0, arr.length - 1, searchValue);
        int result2 = binarySearch(arr, 0, arr.length - 1, searchValue2);

        System.out.println(searchValue + " Index is " + ((result == -1) ? "not found" : result));
        System.out.println(searchValue2 + " Index is " + ((result2 == -1) ? "not found" : result2));
    }

    public static int binarySearch(int[] arr, int first, int last, int value) {
        // return index as -1 as not found
        if (first > last) return -1;

        int mid = (first + last) / 2;

        if (value == arr[mid]) {
            return mid;
        }

        if (value > arr[mid]) {
            return binarySearch(arr, mid + 1, last, value);
        }
        return binarySearch(arr, first, mid - 1, value);
    }

    public static int binarySearchIteration(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == value) {
                return mid;
            }

            if (arr[mid] < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
