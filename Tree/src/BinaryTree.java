import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

    private BinaryNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        initializeTree(rootData, leftTree, rightTree);
    }

    private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        // < FIRST DRAFT - See Segments 25.4 - 25.7 for improvements. >
        root = new BinaryNode<T>(rootData);

        if (leftTree != null)
            root.setLeftChild(leftTree.root);

        if (rightTree != null)
            root.setRightChild(rightTree.root);
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        initializeTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
    }

    @Override
    public T getRootData() {
        return root.getData();
    }

    @Override
    public void setRootData(T rootData) {
        root.setData(rootData);
    }

    protected void setRootNode(BinaryNode<T> rootNode) {
        root = rootNode;
    }

    protected BinaryNode<T> getRootNode() {
        return root;
    }


    @Override
    public int getHeight() {
        return root.getHeight();
    }

    @Override
    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getLevelOrderIterator() {
        return null;
    }
}
