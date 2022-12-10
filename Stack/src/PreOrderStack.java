import java.util.Stack;

public class PreOrderStack {
    /* Class containing left and right child of
    current node and key value*/
    Node root;

    void preorder() {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        s.push(root);

        while (!s.isEmpty()) {
            curr = s.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }

    }

    public static void main(String args[]) {

    /* creating a binary tree and entering
    the nodes */
        PreOrderStack tree = new PreOrderStack();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.preorder();
    }
}
