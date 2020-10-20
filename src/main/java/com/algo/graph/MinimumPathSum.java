package com.algo.graph;

/*
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes
the sum of all numbers along its path
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/
public class MinimumPathSum {
    public static void main(String[] args){
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minimumPathSum.minPathSumUsingRecursion(grid));
    }

    public int minPathSumUsingRecursion(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    public int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length)
            return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];

        int down = calculate(grid, i + 1, j);
        int right = calculate(grid, i, j + 1);
        int minimumDownRight = Math.min(down,right);

        return grid[i][j] + minimumDownRight;
    }


        public int minPathSumUsingDP(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            for (int i = grid.length - 1; i >= 0; i--) {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if(i == grid.length - 1 && j != grid[0].length - 1)
                        dp[i][j] = grid[i][j] +  dp[i][j + 1];
                    else if(j == grid[0].length - 1 && i != grid.length - 1)
                        dp[i][j] = grid[i][j] + dp[i + 1][j];
                    else if(j != grid[0].length - 1 && i != grid.length - 1)
                        dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                    else
                        dp[i][j] = grid[i][j];
                }
            }
            return dp[0][0];
        }

        public int minPathSumUsingDPOptimized(int[][] grid) {
            for (int i = grid.length - 1; i >= 0; i--) {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if(i == grid.length - 1 && j != grid[0].length - 1)
                        grid[i][j] = grid[i][j] +  grid[i][j + 1];
                    else if(j == grid[0].length - 1 && i != grid.length - 1)
                        grid[i][j] = grid[i][j] + grid[i + 1][j];
                    else if(j != grid[0].length - 1 && i != grid.length - 1)
                        grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j],grid[i][j + 1]);
                }
            }
            return grid[0][0];
        }
}
