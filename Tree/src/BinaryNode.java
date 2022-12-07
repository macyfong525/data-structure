public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;  // Reference to left child
    private BinaryNode<T> rightChild; // Reference to right child

    public BinaryNode() {
        this(null);
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public BinaryNode(T data, BinaryNode<T> newLeftChild,
                      BinaryNode<T> newRightChild) {
        this.data = data;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    }

    /**
     * Retrieves the data portion of this node.
     *
     * @return The object in the data portion of the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data portion of this node.
     *
     * @param newData The data object.
     */
    public void setData(T newData) {
        data = newData;
    }

    /**
     * Retrieves the right child of this node.
     *
     * @return A reference to this node's right child.
     */
    public BinaryNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * Sets this node’s right child to a given node.
     *
     * @param newRightChild A node that will be the right child.
     */
    public void setRightChild(BinaryNode<T> newRightChild) {
        rightChild = newRightChild;
    }

    /**
     * Detects whether this node has a right child.
     *
     * @return True if the node has a right child.
     */
    public boolean hasRightChild() {
        return rightChild != null;
    }

    /**
     * Retrieves the left child of this node.
     *
     * @return A reference to this node's left child.
     */
    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Sets this node’s left child to a given node.
     *
     * @param newLeftChild A node that will be the left child.
     */
    public void setLeftChild(BinaryNode<T> newLeftChild) {
        leftChild = newLeftChild;
    }

    /**
     * Detects whether this node has a left child.
     *
     * @return True if the node has a left child.
     */
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    /**
     * Detects whether this node is a leaf.
     *
     * @return True if the node is a leaf.
     */
    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }

    /**
     * Counts the nodes in the subtree rooted at this node.
     *
     * @return The number of nodes in the subtree rooted at this node.
     */
    public int getNumberOfNodes() {
        int leftNumber = 0;
        int rightNumber = 0;
        if (leftChild != null) {
            leftNumber = leftChild.getNumberOfNodes();
        }
        if (rightChild != null) {
            rightNumber = rightChild.getNumberOfNodes();
        }
        return 1 + leftNumber + rightNumber;
    }

    /**
     * Computes the height of the subtree rooted at this node.
     *
     * @return The height of the subtree rooted at this node.
     */
    public int getHeight() {
        int height = 0;
        if (!(leftChild ==null) && !(rightChild == null)) {
            height = 1 + Math.max(leftChild.getHeight(), rightChild.getHeight());
        }
        return height;
    }

    /**
     * Copies the subtree rooted at this node.
     *
     * @return The root of a copy of the subtree rooted at this node.
     */
    public BinaryNode<T> copy() {
        BinaryNode<T> newNode = new BinaryNode<>(data);
        if (leftChild != null) {
            newNode.setLeftChild(leftChild);
        }
        if (rightChild != null) {
            newNode.setRightChild(rightChild);
        }
        return newNode;
    }
}
