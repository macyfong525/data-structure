public class LevelOrderQueue {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right  = null;
        }
    }
//    static void printLevelOrder(Node root) {
//        // Base Case
//        if (root == null) return;
//
//        // Create an empty queue for level order traversal
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (q.size() > 0) {
//            int nodeCount = q.size();
//            while (nodeCount > 0) {
//                Node node = q.peek();
//                System.out.print(node.data + " ");
//                q.remove();
//                if (node.left != null)
//                    q.add(node.left);
//                if (node.right != null)
//                    q.add(node.right);
//                nodeCount--;
//            }
//            System.out.println();
//        }
//    }

    static void printLevelOrder(Node root) {
        // Base Case
        if (root == null) return;

        // Create an empty queue for level order traversal
        QueueCircularArray<Node> q = new QueueCircularArray<>();
        q.enqueue(root);

        while (!q.isEmpty()) {
            int nodeCount = q.size;
            while (nodeCount > 0) {
                Node node = q.getFront();
                System.out.print(node.data + " ");
                q.dequeue();
                if (node.left != null)
                    q.enqueue(node.left);
                if (node.right != null)
                    q.enqueue(node.right);
                nodeCount--;
            }
        }
    }

    public static void main(String args[]) {
    /* Constructing below tree
                8
            / \
            4     12
        / \ / \
        2 6 10 14
    */

        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
//        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
//        root.right.right = new Node(14);

        printLevelOrder(root);
    }
}
