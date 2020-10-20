package com.algo.binaryTree;

public class BinaryTreeNode {

    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int value;

    public BinaryTreeNode(int value){
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int value) {
        this.left =left;
        this.right = right;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
