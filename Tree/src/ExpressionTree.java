public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface {
    public double evaluate() {
        return evaluate(getRootNode());
    }

    private double compute(String operator, double firstOperand, double secondOperand) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
            case "^":
                result = Math.pow(firstOperand, secondOperand);
                break;
        }
        return result;
    }

    private double evaluate(BinaryNode<String> rootNode) {
        double result;
        if (rootNode == null)
            result = 0;
        else if (rootNode.isLeaf()) {
            String variable = rootNode.getData();
            result = Integer.parseInt(variable);
        } else {
            double firstOperand = evaluate(rootNode.getLeftChild());
            double secondOperand = evaluate(rootNode.getRightChild());
            String operator = rootNode.getData();
            result = compute(operator, firstOperand, secondOperand);
        }

        return result;
    }
}