package com.ebay.practice.binaryTree;


import com.algo.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class FlattenBTTOLinkedList {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList();
        populateQueue(q, root);

        TreeNode curr = q.poll();
        while (q.size() > 0){
            curr.right = q.poll();
            curr.left = null;
            curr = curr.right;
        }
    }

    private void populateQueue(Queue q, TreeNode node){
        if (node == null)
            return;

        q.add(node);
        populateQueue(q, node.left);
        populateQueue(q, node.right);
    }


}
