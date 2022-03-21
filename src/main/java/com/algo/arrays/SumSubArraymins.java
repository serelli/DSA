package com.algo.arrays;

import java.util.Arrays;
import java.util.Stack;



class SumSubArraymins {

    public static void main(String[] args){
        SumSubArraymins obj = new SumSubArraymins();
        System.out.println(obj.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;

        Stack<RepInteger> stack = new Stack();
        int ans = 0, dot = 0;
        for (int j = 0; j < A.length; ++j) {
            // Add all answers for subarrays [i, j], i <= j
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= A[j]) {
                RepInteger node = stack.pop();
                count += node.count;
                dot -= node.val * node.count;
            }
            stack.push(new RepInteger(A[j], count));
            dot += A[j] * count;
            ans += dot;
            ans %= MOD;
        }

        return ans;
    }
    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int seq =1;
        int max = 0;
        for(int i =1;i<nums.length;i++){
            if(nums[i-1]==nums[i] || nums[i-1]==nums[i]-1){
                seq++;
            }else{
                max = Math.max(max, seq);
                seq =1;
            }
        }
        return Math.max(max, seq);

    }
}

class RepInteger {
    int val, count;
    RepInteger(int v, int c) {
        val = v;
        count = c;
    }
}
