public class EvaluateInfix {

    public static int Prec(char ch) {
        switch (ch) {
            case '-':
            case '+':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static int infix(String exp) {
        int result;
        StackInterface<Character> operatorStack = new StackList<>();
        StackInterface<Integer> numStack = new StackList<>();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                numStack.push((int) (c - 48));
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (operatorStack.peek() != '(') {
                    result = performOperation(numStack, operatorStack);
                    numStack.push(result);
                }
                operatorStack.pop();
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && Prec(c) <= Prec(operatorStack.peek())) {
                    result = performOperation(numStack, operatorStack);
                    numStack.push(result);
                }
                operatorStack.push(c);
            }
        }
        while (!operatorStack.isEmpty()) {
            result = performOperation(numStack, operatorStack);
            numStack.push(result);
        }
        result = numStack.pop();
        return result;
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*' || c == '^';
    }

    public static int performOperation(StackInterface<Integer> numStack, StackInterface<Character> operatorStack) {
        int temp = numStack.pop();
        int temp2 = numStack.pop();
        char operator = operatorStack.pop();
        int result = 0;
        if (operator == '+') {
            result = (temp + temp2);
        } else if (operator == '-') {
            result = (temp2 - temp);

        } else if (operator == '*') {
            result = (temp2 * temp);

        } else if (operator == '/') {
            result = (temp2 / temp);

        } else if (operator == '^') {
            result = (int) Math.pow(temp2, temp);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(infix("(2+3)*4-9^2"));
    }
}
