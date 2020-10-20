package com.algo.sortingexamples;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementN3 {
    public List<Integer> majorityElement(int[] nums) {
        //A Linear Time Majority Vote Algorithm
        List<Integer> result = new ArrayList<>();
        if (nums.length < 1) {
            return result;
        }
        int i = 0, num1 = 0, count1 = 0, num2 = 0, count2 = 0;
        while (i < nums.length) {
            if (num1 == nums[i]) {
                count1++;
            } else if (num2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
            i++;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;
        }
        if (count1 > nums.length / 3)
            result.add(num1);
        if (count2 > nums.length / 3)
            result.add(num2);

        return result;
    }

    public static void main(String[] args) {
        MajorityElementN3 obj = new MajorityElementN3();
        System.out.println(obj.majorityElement(new int[]{8, 8, 7, 7, 7}));
    }
}
