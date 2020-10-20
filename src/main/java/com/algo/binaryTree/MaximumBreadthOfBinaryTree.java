package com.ebay.practice.binaryTree;


import com.algo.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;



class MaximumBreadthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<Pair>();
        if (root == null)
            return 0;
        q.offer(new Pair(root, 0));
        int i, size, count;
        int max_size = 0;
        Pair curr;
        while (!q.isEmpty()) {
            i = 0;
            size = q.size();
            int first = 0;
            while (i < size) {
                curr = q.poll();
                /* if this is the first node in this level, mark this as the first node */
                if (i == 0)
                    first = curr.index;
                /* the width for each node at current level will be 'current nodes index - first node index'
                   Iterate over all the nodes at current level and calcualting max width.
                   */
                count = curr.index - first + 1;
                max_size = Math.max(count, max_size);

                /* insert nodes with thier appropriate index */
                if (curr.root.left != null)
                    q.offer(new Pair(curr.root.left, (2 * curr.index) + 1));
                if (curr.root.right != null)
                    q.offer(new Pair(curr.root.right, (2 * curr.index) + 2));
                i++;
            }
        }
        return max_size;
    }
    class Pair {
        TreeNode root;
        int index;
        public Pair(TreeNode t, int count) {
            root=t;
            index=count;
        }
    }
}
