package com.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumAlgo {

    public static void main(String[] args){
        ThreeSumAlgo threeSumAlgo = new ThreeSumAlgo();
        List<List<Integer>> lists = threeSumAlgo.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println(lists);

    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if(nums.length < 3) return result;

        Arrays.sort(nums);

        for(int i =0;i<=nums.length-3;i++){
            if(nums[0] > 0){
                 break;
            }
            if(i==0 || nums[i] != nums[i-1]){
                int start = i+1, end = nums.length-1, target = -nums[i];
                while(start<end){
                    if(nums[start]+nums[end] > target){
                        end--;
                    }else if(nums[start]+ nums[end]<target){
                        start++;
                    }else{
                        result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        while(start<end && nums[start]==nums[start+1]) start++;
                        while(start<end && nums[end] == nums[end-1]) end--;
                        start++;
                        end--;
                    }
                }

            }

        }
        return result;
    }
}
