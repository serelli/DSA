package com.ebay.practice.binaryTree;

import com.algo.model.TreeNode;

class MinimumDepthOfBT {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

    /*public int minDepthIterative(TreeNode root) {
            LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            if (root == null) {
                return 0;
            }
            else {
                stack.add(new Pair(root, 1));
            }

            int min_depth = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> current = stack.pollLast();
                root = current.fst;
                int current_depth = current.snd;
                if ((root.left == null) && (root.right == null)) {
                    min_depth = Math.min(min_depth, current_depth);
                }
                if (root.left != null) {
                    stack.add(new Pair(root.left, current_depth + 1));
                }
                if (root.right != null) {
                    stack.add(new Pair(root.right, current_depth + 1));
                }
            }
            return min_depth;
        }*/
}
