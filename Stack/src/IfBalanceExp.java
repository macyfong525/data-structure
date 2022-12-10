import java.util.Scanner;

public class IfBalanceExp {

    public static boolean checkBalance(String exp) throws Exception {
        StackLList<Character> stack = new StackLList<>();
        char[] output = exp.strip().toCharArray();
        for (char c : output) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            // ignore operator and letter
            if (!(c == '}' || c == ']' || c == ')')) {
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (!isPaired(stack.pop(), c)) {
                return false;
            }
        }
        return (stack.isEmpty());
    }

    public static boolean isPaired(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }


    public static String userInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the expression {[()]} to check if balanced or 0 to exit: ");
        // assume user only input char in {[()]}
        return input.nextLine();
    }

    public static void main(String[] args) {
        try {
            String exp = userInput();
            while (!exp.equals("0")) {
                if (checkBalance(exp)) {
                    System.out.println(exp + " is balanced");
                } else {
                    System.out.println(exp + " is not balanced");
                }
                exp = userInput();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
