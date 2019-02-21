package binaryTreeSwapNodes;

public class BinaryTreeNode {
    private BinaryTreeNode head;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int value;
    private int level;

    public BinaryTreeNode(int value, int level) {
        this.value = value;
        this.level = level;
    }

    public BinaryTreeNode getHead() {
        return head;
    }

    public void setHead(BinaryTreeNode head) {
        this.head = head;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
