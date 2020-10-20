package com.ebay.practice.binaryTree;

import com.algo.binaryTree.BinaryTreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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
        node2.setLeft(node3);
        node2.setRight(node4);
        node3.setRight(node5);
        node5.setLeft(node7);
        node7.setRight(node9);
        node4.setLeft(node10);
        node10.setRight(node12);
        node11.setLeft(node6);
        node6.setRight(node8);

        //               1
        //              / \
        //             2   11
        //            / \  / \
        //           3   4 6
        //         / \  /\ /\
        //           5 10    8
        //          /\ /\   / \
        //         7    12
        //        /\    /\
        //          9


        BinaryTreeLevelOrderTraversal tras = new BinaryTreeLevelOrderTraversal();
        System.out.println(tras.returnRightViewOfBinaryTree(node1));
         //System.out.println(levelorderTraversalRecursion(node1));
        // list.clear();
         //System.out.println(levelorderTraversalIterative1(node1));
        //list.clear();
        // System.out.println(preorderTraversalIterative2(node1));

    }

    // 1) iterative way of binary tree levelorder traversal

    public static List<List<Integer>> levelorderTraversalIterative1(BinaryTreeNode root){

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i=0; i<level; i++){
                BinaryTreeNode temp = queue.peek();
                if(temp.getLeft()!=null) queue.offer(temp.getLeft());
                if(temp.getRight()!=null) queue.offer(temp.getRight());
                subList.add(temp.getValue());
                queue.poll();
            }
            res.add(subList);
        }
        return res;

    }
//print only elements in level Order traversal using iterative way.
    public void printLevelOrder(BinaryTreeNode root)
    {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            BinaryTreeNode tempNode = queue.poll();
            System.out.print(tempNode.getValue() + " ");

            /*Enqueue left child */
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }

            /*Enqueue right child */
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
    }

    //recursively

    public void printLevelOrderRecur(BinaryTreeNode root){

        if(root ==null)
            return ;
        int h = depth(root);
        for(int i=1;i<=h;i++){
            printLevelOrderRecur(root,i);
        }
    }

    public void printLevelOrderRecur(BinaryTreeNode root, int i){
        if(root ==null){
            return;
        }
        if(i==1){
            System.out.println(root.getValue());

        }
        printLevelOrderRecur(root.getLeft(),i-1);
        printLevelOrderRecur(root.getRight(),i-1);

    }
    public  int depth(BinaryTreeNode node) {
        if (node == null) return 0;
        int L = depth(node.getLeft());
        int R = depth(node.getRight());
        return Math.max(L, R) + 1;
    }
   // improved level Order traversal using recursion solution.

    public List<List<Integer>> improvedLevelOrderTraversalRecur(BinaryTreeNode root){

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        improvedLevelOrderTraversalRecur(root,1,res);
        return res;
    }
    public void improvedLevelOrderTraversalRecur(BinaryTreeNode root, int level, List<List<Integer>> res){

        if(root == null){
            return;
        }
        if(res.size()<level){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(level-1).add(root.getValue());
        improvedLevelOrderTraversalRecur(root.getLeft(),level+1,res);
        improvedLevelOrderTraversalRecur(root.getRight(),level+1,res);
    }

   //right view of a binary tree using recursive way.
    public Collection<Integer> returnRightViewOfBinaryTree(BinaryTreeNode node){

        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        if(node == null)
            return res;
        returnRightViewOfBinaryTree(node,1,map);
        return map.values();

    }

    private void returnRightViewOfBinaryTree(BinaryTreeNode root, int i, Map<Integer, Integer> map) {
        if(root == null)
            return;
        /*if(map.size()<i){
            map.put(i,root.getValue());
        }*/
        map.put(i,root.getValue());
        returnRightViewOfBinaryTree(root.getLeft(),i+1,map);
        returnRightViewOfBinaryTree(root.getRight(),i+1,map);
    }


}
