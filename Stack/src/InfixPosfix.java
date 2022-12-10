import java.util.Stack;

public class InfixPosfix {
    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts
// given infix expression
// to postfix expression.
    static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (c == '(' || c == '^')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); // pop (
            } else if (Character.isLetterOrDigit(c))
                result += c;

            else {
                // pop checking, as ( return -1
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // Driver's code
    public static void main(String[] args) {
        // ( a ^ b * c − d ) ^ e + f ^ g ^ h
        // (a – b * c) / (d * e * f + g)
//        String s = "(a^b*c-d)^e+f^g^h";
        String s = "(a-b*c)/(d*e*f+g)";
        System.out.println(infixToPostfix(s));
    }
}
