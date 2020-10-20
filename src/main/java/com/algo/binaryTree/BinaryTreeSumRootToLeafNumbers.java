package com.ebay.practice.binaryTree;


import com.algo.model.TreeNode;

/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

         An example is the root-to-leaf path 1->2->3 which represents the number 123.

         Find the total sum of all root-to-leaf numbers.*/
class BinaryTreeSumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);

    }
    public int sumNumbers(TreeNode root, int sum){
        if(root ==null){
            return 0;
        }
        if(root.left ==null && root.right == null){
            return sum*10+root.val;
        }
        int left = sumNumbers(root.left,sum*10+root.val);
        int right = sumNumbers(root.right,sum*10+root.val);
        return left+right;
    }
}
