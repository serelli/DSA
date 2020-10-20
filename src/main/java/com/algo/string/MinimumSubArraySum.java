package com.algo.string;

public class MinimumSubArraySum {

    public static void main(String[] args){
        MinimumSubArraySum minimumSubArraySum = new MinimumSubArraySum();
        int minimum_len = minimumSubArraySum.minimumSubArraySumN3(new int[]{2,3,1,2,4,3},7);
        System.out.println(minimum_len);
    }
    public int minimumSubArraySumN3(int[] nums, int sum){
        int len = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length;i++){
            for(int j = i+1; j<=nums.length;j++){
                int num =0;                                  
                for(int k = i; k<j;k++){
                   num +=nums[k];
                }
                if(num>=sum){
                    len = Math.min(len,j-i);
                    break;
                }

            }
        }
        return (len != Integer.MAX_VALUE) ? len : 0;
    }

    public int minimumSubArraySumN2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++)
            sums[i] = sums[i - 1] + nums[i];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sums[j] - sums[i] + nums[i];
                if (sum >= s) {
                    ans = Math.min(ans, (j - i + 1));
                    break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    
}
