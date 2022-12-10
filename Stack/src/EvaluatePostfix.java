import java.util.Stack;

public class EvaluatePostfix {
    static int posfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                stack.push((int) (c - '0'));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                    case '^':
                        stack.push((int) Math.pow(num2, num1));
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(posfix("23*42-/56*+"));
    }
}
