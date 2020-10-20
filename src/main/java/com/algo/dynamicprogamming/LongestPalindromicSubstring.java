/*
package com.algo.dynamicprogamming;

public class LongestPalindromicSubstring {

    private String longestPalindromicSubstring(String str){
        int n = str.length();
        if(n==0)
            return str;
        String result = null;
        boolean[][] dp = new boolean[n][n];

        for(int i = n-1;i>=0;i++){
            for(int j = i;j<n;j++){
                dp[i][j] = str.charAt(j)==str.charAt(i) && (i-j<3 || dp[i+1][j-1]);

            }
        }
    }
}
*/
