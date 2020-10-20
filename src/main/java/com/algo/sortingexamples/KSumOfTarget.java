package com.algo.sortingexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSumOfTarget {


    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
            int i = index, j = len - 1;
            while(i < j) {
                //find a pair
                if(target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target-nums[i]);
                    res.add(temp);
                    //skip duplication
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    //move right bound
                } else {
                    j--;
                }
            }
        } else{
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }
}
/*
    public static void main(String[] args){
        KSumOfTarget kSumOfTarget = new KSumOfTarget();
        int A[] = {1, 4, 45, 6, 10, -8};
        System.out.println(kSumOfTarget.twoSumTarget(A,16));
    }
    private List<List<Integer>> twoSumTarget(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<2)
            return result;
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            if(target == nums[low]+nums[high]){
                result.add(Arrays.asList(nums[low],nums[high]));
                low++;
                high--;
                while(low<high && nums[low]==nums[low+1]) low++;
                while(low<high && nums[high]== nums[high-1]) high--;
            }else if (target< nums[low]+nums[high]){
                high--;
            }else{
                low++;
            }
        }
        return result;

    }*/


