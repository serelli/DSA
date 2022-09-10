package com.algo.arrays;

public class ConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int i =0,sum=0,maxSum = 0;

        while(i<nums.length){
            if(nums[i]==0){
                maxSum = Math.max(maxSum,sum);
                sum = 0;
                i++;
                continue;
            }
                sum +=nums[i++];

        }
        return Math.max(maxSum,sum);

    }

    public int findMaxConsecutiveOnesII(int[] nums) {

        int left =0, right=0;
        int countZero =0,max = 0;
        while(right<nums.length){
            if(nums[right]==0){
                countZero++;
            }
            while(countZero==2){
                max = Math.max(max,right-left);
                if(left<nums.length){
                    if(nums[left]==0){
                        countZero--;
                    }
                }
                left++;
            }
            right++;
        }
        return Math.max(right-left+1,max);

    }

    public static void main(String[] args){
        ConsecutiveOnes consecutiveOnes = new ConsecutiveOnes();
        int maxConsecutiveOnes = consecutiveOnes.findMaxConsecutiveOnesII(new int[]{1, 0, 1,1,0,1});
        System.out.println(maxConsecutiveOnes);

    }
}
