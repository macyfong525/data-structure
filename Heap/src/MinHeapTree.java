import java.util.LinkedList;
import java.util.Queue;

public class MinHeapTree {
    static class Node {
        int data;
        Node left, right;
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return node;
    }

    static void printLevelOrder(Node root) {
        // Base Case
        if (root == null) return;

        // Create an empty queue for level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            int nodeCount = q.size();
            while (nodeCount > 0) {
                Node node = q.peek();
                System.out.print(node.data + " ");
                q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    // A simple recursive function to convert a given
    // Binary Search tree to Sorted Linked List
    // root     -. Root of Binary Search Tree
    // head_ref -. Pointer to head node of created
    //             linked list
    static Node BinarySearchTreeSorted(Node root, Node head_ref) {
        // Base cases
        if (root == null)
            return head_ref;
        head_ref = BinarySearchTreeSorted(root.right, head_ref);
        root.right = head_ref;
        if (head_ref != null)
            (head_ref).left = null;
        head_ref = root;
        head_ref = BinarySearchTreeSorted(root.left, head_ref);
        return head_ref;
    }

    // Function to convert a sorted Linked
    // List to Min-Heap.
    // root -. Root of Min-Heap
    // head -. Pointer to head node of sorted
    //             linked list
    static Node SortedLLToMinHeap(Node root, Node head) {
        // Base Case
        if (head == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        root = head;
        head = head.right;
        root.right = null;
        q.add(root);
        while (head != null) {
            Node parent = q.peek();
            q.remove();
            Node leftChild = head;
            head = head.right;
            leftChild.right = null;
            q.add(leftChild);
            parent.left = leftChild;
            if (head != null) {
                Node rightChild = head;
                head = head.right;
                rightChild.right = null;
                q.add(rightChild);
                parent.right = rightChild;
            }
        }
        return root;
    }

    // Function to convert BST into a Min-Heap
    // without using any extra space
    static Node BSTMinHeap(Node root) {
        Node head = null;
        head = BinarySearchTreeSorted(root, head);
        root = null;
        root = SortedLLToMinHeap(root, head);
        return root;
    }

    // Driver code
    public static void main(String args[]) {
    /* Constructing below tree
                8
            / \
            4     12
        / \ / \
        2 6 10 14
    */

        Node root = newNode(8);
        root.left = newNode(4);
        root.right = newNode(12);
        root.left.left = newNode(2);
        root.left.right = newNode(6);
        root.right.left = newNode(10);
        root.right.right = newNode(14);

        Node root1 = newNode(3);
        root1.left = newNode(8);
        root1.right = newNode(2);
        root1.left.left = newNode(1);
        root1.left.right = newNode(7);
        root1.right.left = newNode(9);
        root1.right.right = newNode(4);
//        root.left.left.left = newNode(6);
//        root.left.left.right = newNode(5);

        printLevelOrder(root);
        printLevelOrder(root1);

        root = BSTMinHeap(root);
        root1 = BSTMinHeap(root1);

    /* Output - Min Heap
                2
            / \
            4     6
        / \ / \
        8 10 12 14
    */

        printLevelOrder(root);
        printLevelOrder(root1);
    }
}

