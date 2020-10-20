package com.algo.dynamicprogamming;

public class PaintHouseII {

    public static void main(String[] args) {
        PaintHouseII obj = new PaintHouseII();
        int[][] costs = new int[][]{{1, 5, 3}, {2, 9, 4}};
        int result = obj.minCost(costs, -1, -1);
        System.out.println(result);

    }

    public int minCost(int[][] costs, int i, int j) {

        if (i == costs.length) return 0;

        int mc = Integer.MAX_VALUE;

        for (int k = 0; k < costs[0].length; k++) {

            if (k != j) mc = Math.min(mc, minCost(costs, i + 1, k));
        }

        return i < 0 ? mc : mc + costs[i][j];

    }
}
