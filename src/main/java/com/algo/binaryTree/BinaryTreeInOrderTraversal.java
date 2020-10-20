package com.ebay.practice.binaryTree;

import com.algo.binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.ebay.practice.binaryTree.BinaryTreePreOrderTraversal.preorderTraversalIterative1;
import static com.ebay.practice.binaryTree.BinaryTreePreOrderTraversal.preorderTraversalRecursion;

public class BinaryTreeInOrderTraversal {
    static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args){

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
       /* BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        BinaryTreeNode node12 = new BinaryTreeNode(12);*/

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node7);
        node3.setLeft(node6);
        /*node7.setRight(node9);
        node4.setLeft(node10);
        node10.setRight(node12);
        node11.setLeft(node6);
        node6.setRight(node8);*/



         //System.out.println(inorderTraversalRecursion(node1));
         //list.clear();
        BinaryTreePreOrderTraversal pre = new BinaryTreePreOrderTraversal();
         System.out.println(preorderTraversalRecursion(node1));
        //list.clear();
        BinaryTreeInOrderTraversal trv = new BinaryTreeInOrderTraversal();
        System.out.println(trv.inOrderNodesInBT(node1));

    }

    public static List<Integer> inorderTraversalRecursion(BinaryTreeNode root) {
        if(root !=null){
            inorderhelper(root);
        }

        return list;
    }

    public static void inorderhelper(BinaryTreeNode node){
        if(node.getLeft()!=null)
            inorderhelper(node.getLeft());

        list.add(node.getValue());

        if(node.getRight()!=null)
            inorderhelper(node.getRight());
    }

    // 1) iterative way of binary tree inorder traversal

    public static List<Integer> inorderTraversalIterative1(BinaryTreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        if(root ==null)
            return result;

            //use stack
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = root;

        while(!stack.empty() || node !=null){

            if(node!=null){
                stack.push(node);
                node = node.getLeft();
            }else{
                BinaryTreeNode cur = stack.pop();
                result.add(cur.getValue());
                node = cur.getRight();
            }
        }
        return result;
    }

    // 2) iterative way of binary tree inorder traversal

    public static List<Integer> inorderTraversalIterative2(BinaryTreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        if(root ==null)
            return result;

        //use stack
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);

        while(!stack.empty()){
            BinaryTreeNode top = stack.peek();
            if(top.getLeft()!=null){
                stack.push(top.getLeft());
                top.setLeft(null);
            }else{
                result.add(top.getValue());
                stack.pop();
                if(top.getRight()!=null) {
                    stack.push(top.getRight());
                }
            }
        }
        return result;
    }

    //find each node in binary tree and replace with the sum of its inorder predecessor and successor.

    public List<Integer> inOrderNodesInBT(BinaryTreeNode root){

        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.add(0);
        inOrderNodesInBT(root,res);
        res.add(0);
        replaceInOrderNodesInBT(root,res,1);
        return preorderTraversalIterative1(root);
    }

    private void replaceInOrderNodesInBT(BinaryTreeNode root, List<Integer> res, int i) {
        if(root ==null)
            return;
        replaceInOrderNodesInBT(root.getLeft(),res,i);
        root.setValue(res.get(i-1)+res.get(i+1));
        i++;
        replaceInOrderNodesInBT(root.getRight(),res,i);
    }

    private void inOrderNodesInBT(BinaryTreeNode root, List<Integer> res) {
        if(root ==null)
            return;
        inOrderNodesInBT(root.getLeft(),res);
        res.add(root.getValue());
        inOrderNodesInBT(root.getRight(),res);
    }
}
