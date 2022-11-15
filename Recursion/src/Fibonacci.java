public class Fibonacci {
    // Time complexity: O(n)
    // Space complexity: O(1)
    // space is constant as we use only three variables to store the last 2 Fibonacci numbers to find the next and so on
    public int FiIteration(int num) {
        if (num == 1 || num == 0) {
            return num;
        }

        int first = 0;
        int second = 1;

        for (int i = 2; i <= num; i++) {
            int next = first + second;
            first = second;
            second = next;
        }

        return second;
    }

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    // Space looks constant but every time recursion is carried out there is a lot going on in the background as stack memory is used up for every call
    public int FiRecursion(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return FiRecursion(num - 1) + FiRecursion(num - 2);
    }

    public static void main(String[] args) {
        // F(0) = 0, F(1) = 1
        // F(n) = F(n - 1) + F(n - 2), for n > 1.
        Fibonacci ob = new Fibonacci();
        System.out.println(ob.FiRecursion(3));
        System.out.println(ob.FiIteration(3));
    }
}
