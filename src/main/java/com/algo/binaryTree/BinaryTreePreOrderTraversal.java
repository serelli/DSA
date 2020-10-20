package com.ebay.practice.binaryTree;

import com.algo.binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
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
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        BinaryTreeNode node12 = new BinaryTreeNode(12);

        node1.setLeft(node2);
        node1.setRight(node11);
        //node2.setLeft(node3);
        //node2.setRight(node4);
        /*node3.setRight(node5);
        node5.setLeft(node7);
        node7.setRight(node9);
        node4.setLeft(node10);
        node10.setRight(node12);
        node11.setLeft(node6);
        node6.setRight(node8);*/



        // System.out.println(preorderTraversalRecursion(node1));
        // list.clear();
       //  System.out.println(preorderTraversalIterative1(node1));
        //list.clear();
        // System.out.println(preorderTraversalIterative2(node1));
         System.out.println(heightBinaryTree(node1));

    }

    public static List<Integer> preorderTraversalRecursion(BinaryTreeNode root) {
        if(root !=null){
            preorderhelper(root);
        }

        return list;
    }

    public static void preorderhelper(BinaryTreeNode node){

        list.add(node.getValue());
        if(node.getLeft()!=null)
            preorderhelper(node.getLeft());

        if(node.getRight()!=null)
            preorderhelper(node.getRight());
    }

    // 1) iterative way of binary tree preorder traversal

    public static List<Integer> preorderTraversalIterative1(BinaryTreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        if(root ==null)
            return result;

            //use stack
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);
        while(!stack.empty()){
            BinaryTreeNode top = stack.pop();
            result.add(top.getValue());
            if(top.getRight()!=null){
                stack.push(top.getRight());
            }
            if(top.getLeft()!=null){
                stack.push(top.getLeft());
            }
        }

        return result;
    }

    // 2) iterative way of binary tree preorder traversal

    public static List<Integer> preorderTraversalIterative2(BinaryTreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        if(root ==null)
            return result;

        //use stack
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = root;
        while(!stack.empty() || node!=null){
            if(node!=null){
                stack.push(node);
                result.add(node.getValue());
                node = node.getLeft();
            }else{
                BinaryTreeNode temp = stack.pop();
                node = temp.getRight();
            }

        }

        return result;
    }


    // find height of a binaryTree

    public static int heightBinaryTree(BinaryTreeNode root){


        if(root==null)
            return 0;
        int left = heightBinaryTree(root.getLeft());
        int right = heightBinaryTree(root.getRight());

        return Math.max(left,right)+1;



    }


}
