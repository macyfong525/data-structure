public class AVLTree<T extends Comparable<? super T>> extends BinarySearchTree<T> implements SearchTreeInterface<T> {

    private BinaryNode<T> rotateRight(BinaryNode<T> nodeN) {
        BinaryNode<T> nodeC = nodeN.getLeftChild();
        nodeN.setLeftChild(nodeC.getRightChild());
        nodeC.setRightChild(nodeN);
        return nodeC;
    } // end rotateRight

    // Corrects an imbalance at the node closest to a structural
    // change in the left subtree of the node's right child.
    // nodeN is a node, closest to the newly added leaf, at which
    // an imbalance occurs and that has a right child.
    private BinaryNode<T> rotateRightLeft(BinaryNode<T> nodeN) {
        BinaryNode<T> nodeC = nodeN.getRightChild();
        nodeN.setRightChild(rotateRight(nodeC));
        return rotateLeft(nodeN);
    } // end rotateRightLeft

    private BinaryNode<T> rebalance(BinaryNode<T> nodeN) {
        int heightDifference = getHeightDifference(nodeN);

        if (heightDifference > 1) {
            // Left subtree is taller by more than 1,
            // so addition was in left subtree
            if (getHeightDifference(nodeN.getLeftChild()) > 0)
                // Addition was in left subtree of left child
                nodeN = rotateRight(nodeN);
            else
                // Addition was in right subtree of left child
                nodeN = rotateLeftRight(nodeN);
        } else if (heightDifference < -1) {
            // Right subtree is taller by more than 1,
            // so addition was in right subtree
            if (getHeightDifference(nodeN.getRightChild()) < 0)
                // Addition was in right subtree of right child
                nodeN = rotateLeft(nodeN);
            else
                // Addition was in left subtree of right child
                nodeN = rotateRightLeft(nodeN);
        } // end if
        // Else nodeN is balanced

        return nodeN;
    }

    public T add(T newEntry) {
        T result = null;

        if (isEmpty())
            setRootNode(new BinaryNode<>(newEntry));
        else {
            BinaryNode<T> rootNode = getRootNode();
            result = addEntry(rootNode, newEntry);
            setRootNode(rebalance(rootNode));
        } // end if

        return result;
    } // end add

    private T addEntry(BinaryNode<T> rootNode, T newEntry) {
        // Assertion: rootNode != null
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());

        if (comparison == 0) {
            result = rootNode.getData();
            rootNode.setData(newEntry);
        } else if (comparison < 0) {
            if (rootNode.hasLeftChild()) {
                BinaryNode<T> leftChild = rootNode.getLeftChild();
                result = addEntry(leftChild, newEntry);
                rootNode.setLeftChild(rebalance(leftChild));
            } else
                rootNode.setLeftChild(new BinaryNode<>(newEntry));
        } else {
            // Assertion: comparison > 0

            if (rootNode.hasRightChild()) {
                BinaryNode<T> rightChild = rootNode.getRightChild();
                result = addEntry(rightChild, newEntry);
                rootNode.setRightChild(rebalance(rightChild));
            } else
                rootNode.setRightChild(new BinaryNode<>(newEntry));
        }

        return result;
    }
}
