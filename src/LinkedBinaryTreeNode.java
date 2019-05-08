import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedBinaryTreeNode<E> implements MutableTreeNode {
    private E element;
    private MutableTreeNode parent;
    private MutableTreeNode leftChild;
    private MutableTreeNode rightChild;

    public LinkedBinaryTreeNode() {
        this(null);
    }

    public LinkedBinaryTreeNode(E element) {
        super();
        this.element = element;
        parent = null;
        leftChild = null;
        rightChild = null;
    }

    @Override
    public void insert(MutableTreeNode child, int index) throws IllegalArgumentException {
        if (getAllowsChildren()) {
            if (child == null)
                throw new IllegalArgumentException();
            else {
                if (index == 0)
                    leftChild = child;
                else if (index == 1)
                    rightChild = child;
                else {
                    System.out.println("This is a binary tree and only accepts two nodes.");
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    @Override
    public void remove(int index) throws IllegalArgumentException {
        if (index == 0)
            leftChild = null;
        else if (index == 1)
            rightChild = null;
        else {
            System.out.println("This is a binary tree and only accepts two nodes.");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void remove(MutableTreeNode node) {
        if (node == null)
            throw new IllegalArgumentException();
        else if (node == leftChild)
            leftChild = null;
        else if (node == rightChild)
            rightChild = null;
    }

    @Override
    public void setUserObject(Object object) {
        element = (E) object;
    }

    @Override
    public void removeFromParent() {
        if (parent == null)
            System.out.println("This node has no parent to remove.");
        else
            parent = null;
    }

    @Override
    public void setParent(MutableTreeNode newParent) {
        parent = newParent;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        if (childIndex == 0)
            return leftChild;
        else if (childIndex == 1)
            return rightChild;
        else return null;
    }

    @Override
    public int getChildCount() throws IllegalArgumentException {
        if (leftChild == null && rightChild == null)
            return 0;
        else if ((leftChild != null && rightChild == null) || (leftChild == null && rightChild != null))
            return 1;
        else if (leftChild != null && rightChild != null)
            return 2;
        else throw new IllegalArgumentException();
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode node) throws IllegalArgumentException {
        //TODO
        if (node == leftChild)
            return 0;
        else if (node == rightChild)
            return 1;
        else throw new IllegalArgumentException();
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return (getChildCount() == 0);
    }

    @Override
    public Enumeration children() {
        return null;
    }

    private class Enumerator<E> implements Enumeration {
        private Iterator<E> iterator;

        public Enumerator(Iterator<E> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasMoreElements() {
            return iterator.hasNext();
        }

        @Override
        public Object nextElement() {
            return iterator.next();
        }
    }
}
