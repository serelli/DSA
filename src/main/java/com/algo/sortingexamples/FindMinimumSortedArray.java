package com.algo.sortingexamples;

public class FindMinimumSortedArray {
    public int findMin(int[] nums) {

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] > nums[hi]) {
                lo = mi + 1;
            }
            else if (nums[mi] < nums[lo]) {
                hi = mi;
                lo++;
            }
            else { // nums[lo] <= nums[mi] <= nums[hi]
                hi--;
            }
        }

        return nums[lo];
    }
    public static void main(String[] args){
        FindMinimumSortedArray findMinimumSortedArray = new FindMinimumSortedArray();
        System.out.println(findMinimumSortedArray.findMin(new int[]{5,6,0,1,2,3,4}));

    }
}
