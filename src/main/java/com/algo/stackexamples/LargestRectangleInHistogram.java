package com.algo.stackexamples;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int max_area = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i+1; j <= heights.length; j++) {
                int height = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    height = Math.min(height, heights[k]);
                }
                System.out.println(height * (j - i));

                max_area = Math.max(max_area, height * (j - i));
            }
        }
        return max_area;
    }

    public static void main(String[] args){
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        System.out.println(obj.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
