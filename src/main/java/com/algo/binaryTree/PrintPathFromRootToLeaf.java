package com.ebay.practice.binaryTree;

import com.algo.binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


//scalastyle:off
public class PrintPathFromRootToLeaf {


    public static void main(String[] args) {
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


        PrintPathFromRootToLeaf tras = new PrintPathFromRootToLeaf();
        StringBuilder sb = new StringBuilder();
        //System.out.println(tras.sumOfAllRootToLeafValues(node1).parallelStream().reduce((a,b) -> a+b).get());
        /*int sum =0;
        for(Integer i : tras.sumOfAllRootToLeafValues(node1)){
            sum+=i;
        }
        System.out.println(sum);
        System.out.println(tras.binaryTreePaths(node1));*/
        System.out.println(tras.sumOfAllRootToLeafValues(node1));
    }


    public List<String> printPathRootToLeaf(BinaryTreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) printPathRootToLeaf(root, "", answer);
        return answer;
    }
    private void printPathRootToLeaf(BinaryTreeNode root, String path, List<String> answer) {
        if (root.getLeft() == null && root.getRight() == null) answer.add(path + root.getValue());
        if (root.getLeft() != null) printPathRootToLeaf(root.getLeft(), path + root.getValue() + "->", answer);
        if (root.getRight() != null) printPathRootToLeaf(root.getRight(), path + root.getValue() + "->", answer);
    }

    public List<Integer> sumOfAllRootToLeafValues(BinaryTreeNode root){
        List<Integer> answer = new ArrayList<>();
        if(root == null)
            return answer;
        sumOfAllRootToLeafValues(root,"",answer);
        return answer;
    }

    private void sumOfAllRootToLeafValues(BinaryTreeNode root, String i, List<Integer> answer) {

        if(root.getLeft()==null && root.getRight() == null){
            answer.add(Integer.valueOf(i+root.getValue()));
        }
        if(root.getLeft()!=null){
            sumOfAllRootToLeafValues(root.getLeft(),i+root.getValue(),answer);
        }
        if(root.getRight()!=null){
            sumOfAllRootToLeafValues(root.getRight(),i+root.getValue(),answer);
        }
    }


    public List<String> binaryTreePaths(BinaryTreeNode root) {

        List<String> paths = new LinkedList<>();

        if(root == null) return paths;

        if(root.getLeft() == null && root.getRight() == null){
            paths.add(root.getValue()+"");
            return paths;
        }

        for (String path : binaryTreePaths(root.getLeft())) {
            paths.add(root.getValue() + "->" + path);
        }

        for (String path : binaryTreePaths(root.getRight())) {
            paths.add(root.getValue() + "->" + path);
        }

        return paths;

    }

    private List<String> printPathRootToLeafIterative(BinaryTreeNode root) {
        List<String>  res = new LinkedList<String>();
        if(root == null)
            return  res;
        Stack<CustomNode> stack = new Stack<>();
        stack.push(new CustomNode(root,""));
        while(!stack.isEmpty()){
            CustomNode tempCustom = stack.pop();
            BinaryTreeNode tempNode = tempCustom.node;
            String tempVal = tempCustom.val;

            if(tempNode.getLeft() == null && tempNode.getRight() == null){
                res.add(tempVal+tempNode.getValue());
            }else{
                if(tempNode.getRight()!=null){
                    stack.push(new CustomNode(tempNode.getRight(),tempVal+tempNode.getValue()+"->"));
                }
                if(tempNode.getLeft()!=null){
                    stack.push(new CustomNode(tempNode.getLeft(),tempVal+tempNode.getValue()+"->"));
                }
            }
        }
        return res;

    }
}
