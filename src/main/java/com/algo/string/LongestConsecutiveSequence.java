package com.algo.string;

public class LongestConsecutiveSequence {

    public static void main(String[] args){

    }
    private int longestConsecutiveSequence(int[] nums){
        int len = nums.length;
        int max = 0;

        for(int i = 0;i<len;i++){

            int current = nums[i];
            int local_count = 1;

            while(containsElement(nums,current+1)){

                current = current+1;
                local_count = local_count+1;
            }
            max = Math.max(max,local_count);
        }
        return max;
    }

    private boolean containsElement(int[] nums, int n){
        for(int i = 0; i <nums.length; i++){
            if(nums[i]==n)
                return true;
        }
        return false;

    }
}
