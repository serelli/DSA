package com.algo.dynamicprogamming;

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

public class CoinChangeProblem {

    //You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.


    /*Coin Exchange Problem:
    Coin exchange problem is nothing but finding the minimum number of coins (of certain denominations) that add up to a given amount of money. It is a knapsack type problem.
    The interesting fact is that it has 2 variations:
    Greedy Algorithm:
    For some type of coin system (canonical coin systems — like the one used in the India, US and many other countries) a greedy approach works. The valued coins will be like { 1, 2, 5, 10, 20, 50, 100, 500, 1000}. i.e. In our algorithm we always choose the biggest denomination, subtract the all possible values and going to the next denomination.
# Denominations of Indian Currency
    deno = [1, 2, 5, 10, 20, 50, 100, 500, 1000]
    n = len(deno)

    def findMin(V)
    ans = []
    i = n-1
            while (i>=0):
            while (V >= deno[i]):
    V = V - deno[i]
            ans.append(deno[i])
    i -= 1
            for coin in ans:
    print coin
    V = 93
    findMin(V)
    Dynamic programming:
    The above solution wont work good for any arbitrary coin systems.
    For example: if the coin denominations were 1, 3 and 4. To make 6, the greedy algorithm would choose three coins (4,1,1), whereas the optimal solution is two coins (3,3)
    Hence, we need to check all possible combinations. But this problem has 2 property of the Dynamic Programming.
    Optimal Substructure To count total number solutions, we can divide all set solutions in two sets. a) Solutions that do not contain mth coin (or Sm). b) Solutions that contain at least one Sm. Let count(S[], m, n) be the function to count the number of solutions, then it can be written as sum of count(S[], m-1, n) and count(S[], m, n-Sm).
    count( S, m, n ) =
    Base condition:
            if (n = 0)           => 1
            if (n < 0)           => 0
            if (m <=0 && n >= 1) => 0

    Recurrence relation:
    count( S, m - 1, n ) + count( S, m, n-S[m-1] )
    Overlapping Subproblems If we go for a naive recursive implementation of the above, We repreatedly calculate same subproblems.
            Hence, a suitable candidate for the DP. Following is the DP implementation*/

        public int[][] coinChange(int[] coins, int amount) {
            int dp[][] = new int[coins.length+1][amount + 1];
            for(int i =0;i<amount+1;i++){
                dp[0][i]=Integer.MAX_VALUE;
            }
            dp[0][0]= 0;
            for (int i = 1; i <coins.length+1; i++) {
                dp[i][0]=0;
                for (int j = 1; j < amount+1 ; j++) {
                    if (j >= coins[i-1] && dp[i][j - coins[i-1]] !=Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j - coins[i-1]]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            System.out.println(dp[coins.length][amount]==Integer.MAX_VALUE? -1: dp[coins.length][amount]);
            return dp;
        }

        public static void main(String[] args){
            CoinChangeProblem coinChangeProblem = new CoinChangeProblem();
            int[] coins = new int[]{1,2,5};
            System.out.println(coinChangeProblem.coinChangerec(coins,11));
            /*int dp [][] = coinChangeProblem.coinChange(coins, 11);
            List<Integer> res = new ArrayList<>();
              int i=dp.length-1, j =dp[0].length-1;
            while(i>=1 && j>0){
                if(dp[i][j] == dp[i-1][j]){
                  i = i-1;
                }else{
                    if(j>=coins[i-1]){
                        res.add(coins[i-1]);
                    }
                    j = j-coins[i-1];
                }

            }
            System.out.println(res);*/
        }




        //recursion brute-force

    public int coinChangerec(int[] coins, int amount) {
        return coinChangerecursion(0, coins, amount);
    }

    private int coinChangerecursion(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount/coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChangerecursion(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }


    // Java program to find minimum number of denominations


        // All denominations of Indian Currency
        static int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        static int n = deno.length;

        static void findMin(int V)
        {
            // Initialize result
            Vector<Integer> ans = new Vector<>();

            // Traverse through all denomination
            for (int i = n - 1; i >= 0; i--)
            {
                // Find denominations
                while (V >= deno[i])
                {
                    V -= deno[i];
                    ans.add(deno[i]);
                }
            }

            // Print result
            for (int i = 0; i < ans.size(); i++)
            {
                System.out.print(" " + ans.elementAt(i));
            }
        }

        // Driver code
        /*public static void main(String[] args)
        {
            int n = 93;
            System.out.print("Following is minimal number of change for " + n + ": ");
            findMin(n);

        }*/


}
