package com.algo.binaryTree;

import com.algo.model.TreeNode;

public class BinaryTreeImpl {


    int ans;
//diameter of a binaryTree is diameter for a node is the sums of left depth-1 and right depth-1
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return ans;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }

   /* class Solution {
        int diameter=0;
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            dfs(root);
            return diameter-2;

        }

        public int dfs(TreeNode root){
            if(root == null) return 0;
            int left=dfs(root.left)+1;
            int right=dfs(root.right)+1;
            if(left+right>diameter) diameter=left+right;
            return left>=right? left: right;
        }*/
   // end of diameter of a binary tree.

    //min depth of a binaryTree.
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }

}


