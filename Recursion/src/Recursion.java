import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        int[] arr = {-10,-20,-30,-15,-70};
        System.out.println(multipation(1,7));
        System.out.println(displayRowOfCharacters("%", 5));
        System.out.println(Arrays.toString(reverseArr(arr, 0, arr.length-1)));
        displayString("MACY",0);
        System.out.println(f(16));
        displayArray(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(Fi(7)));

        int n = 4;
        towerOfHanoi(n,'A','C', 'B');
    }

    static void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod)
    {
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }




    public static int[] Fi(int num){ // number is index

        int[] arr = new int[num+1];   // num+1 is the length

        arr[0] = 0;
        arr[1] = 1;

        for(int i=2;i<=num;i++){      // as i-1,i-2 are declare the base case
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr;

    }


    public static void displayArray(int array[], int first, int last)
    {
        if (first == last)
            System.out.print(array[first] + " ");
        else
        {
            int mid = (first + last)  / 2;
            displayArray(array, first, mid);
            displayArray(array, mid + 1, last);
        } // end if
    }

    public static int multipation(int x, int y){
        if(x==0 || y==0){
            return 0;
        }
        return y + multipation(x-1, y);
    }
    public static int largest(int[] arr, int index, int largeNum){
        if(arr.length == 1){
            return arr[0];
        }
        if(index==arr.length){
            return largeNum;
        }

        return largest(arr, index+1, (arr[index] > largeNum)?arr[index]:largeNum);
    }

    public static String displayRowOfCharacters(String ch, int num){
        // base case
        if(num==1)
            return ch;
        return displayRowOfCharacters(ch, num-1) + ch;
    }

    public static void enterData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number between 1 to 10");
        int userInput = sc.nextInt();
        if(userInput > 10 || userInput < 1){
            enterData();
        }
    }

    public static int[] reverseArr(int[] arr, int first, int last){
        if(first < last) {
            int tmp = arr[first];
            arr[first] = arr[last];
            arr[last] = tmp;
            reverseArr(arr, first+1, last-1);
        }
        return arr;
    }

    public static void displayString(String s, int i){
        if(i<s.length()) {
            displayString(s, i + 1);
            System.out.print(s.charAt(i));
        }
    }

    public static int f(int n)
    {
        int result = 0;
        if (n <= 4)
            result = 1;
         else
            result = f(n / 2) + f(n / 4);
        return result;
    }


}