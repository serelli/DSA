package com.ebay.practice.binaryTree;

import com.algo.binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {

        // create a binary tree
        /*BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node1.setLeft(node2);
        node1.setRight(node3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node2.setLeft(node4);
        node2.setRight(node5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        node3.setLeft(node6);
        node3.setRight(node7);*/

        // create a binary tree
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        BinaryTreeNode node12 = new BinaryTreeNode(12);

        node1.setLeft(node2);
        node1.setRight(node11);
        node2.setLeft(node3);
        node2.setRight(node4);
        node3.setRight(node5);
        node5.setLeft(node7);
        node7.setRight(node9);
        node4.setLeft(node10);
        node10.setRight(node12);
        node11.setLeft(node6);
        node6.setRight(node8);

        BinaryTreePostOrderTraversal traversal = new BinaryTreePostOrderTraversal();
        System.out.println(traversal.postorderTraversalRecursion(node1));
        System.out.println(traversal.postorderTraversalIterative1(node1));
        System.out.println(traversal.postorderTraversalIterative2(node1));
        System.out.println(traversal.postorderTraversalIterative3(node1));
    }

    public  List<Integer> postorderTraversalRecursion(BinaryTreeNode root) {
        if (root != null) {
            postorderhelper(root);
        }

        return list;
    }

    public  void postorderhelper(BinaryTreeNode node) {
        if (node.getLeft() != null)
            postorderhelper(node.getLeft());

        if (node.getRight() != null)
            postorderhelper(node.getRight());

        list.add(node.getValue());
    }

    // 1) iterative way of binary tree postorder traversal

    public  List<Integer> postorderTraversalIterative1(BinaryTreeNode root) {

        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.getValue());  // Reverse the process of preorder
                p = p.getRight();             // Reverse the process of preorder
            } else {
                BinaryTreeNode node = stack.pop();
                p = node.getLeft();           // Reverse the process of preorder
            }
        }
        return result;
    }

    // 2) iterative way of binary tree postorder traversal

    public  List<Integer> postorderTraversalIterative2(BinaryTreeNode root) {

        LinkedList<Integer> ans = new LinkedList<Integer>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode cur = stack.pop();
            ans.addFirst(cur.getValue());
            if (cur.getLeft() != null) {
                stack.push(cur.getLeft());
            }
            if (cur.getRight() != null) {
                stack.push(cur.getRight());
            }
        }
        return ans;
    }
    // 3) iterative way of binary tree postorder traversal

    public  List<Integer> postorderTraversalIterative3(BinaryTreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        //use stack
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode localNode = root;
        stack.push(localNode);

        while (!stack.empty()) {
            BinaryTreeNode temp = stack.peek();

            if (temp.getLeft() == null && temp.getRight() == null) {
                BinaryTreeNode node = stack.pop();
                result.add(node.getValue());
            } else {
                if (temp.getRight() != null) {
                    stack.push(temp.getRight());
                    temp.setRight(null);
                }
                if (temp.getLeft() != null) {
                    stack.push(temp.getLeft());
                    temp.setLeft(null);
                }
            }

        }
        return result;
    }
}
