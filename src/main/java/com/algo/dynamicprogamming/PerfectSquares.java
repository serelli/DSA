package com.algo.dynamicprogamming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

    public static void main(String[] args){
        PerfectSquares perfectSquares = new PerfectSquares();
        int i = perfectSquares.numSquares(12);
        System.out.println(i);

    }

    public int numSquares(int n) {
        return recur(n, getSquares(n));
    }

    public int recur(int k, List<Integer> set) {

        if (set.contains(k))
            return 1;
        int min = Integer.MAX_VALUE;

        for (int square : set) {
            if (k < square)
                break;
            min = Math.min(recur(k - square, set) + 1, min);
        }
        return min;
    }


    public List<Integer> getSquares(int num) {
        List<Integer> set = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(num) + 1; i++) {
            set.add(i * i);
        }
        return set;
    }



    //dp solution for the same problem

    public int numSquaresDP(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }


        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }
}
