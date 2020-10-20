package com.algo.binaryTree;

public class TreeNode<T extends Comparable<T>> {

    TreeNode left;
    TreeNode right;
    T obj;

    public TreeNode(T obj) {
        this.obj = obj;
    }

    public TreeNode(TreeNode left, TreeNode right, T obj) {
        this.left = left;
        this.right = right;
        this.obj = obj;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
