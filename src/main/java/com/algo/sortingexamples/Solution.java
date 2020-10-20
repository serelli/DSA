package com.algo.sortingexamples;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals,Comparator.comparing(x -> x[0]));
        for (int[] arr: intervals
        ) {
            System.out.println(Arrays.toString(arr));

        }

        List<int[]> result = new ArrayList<>();

        int len = intervals.length;
        int[] firstInterval = intervals[0];
        result.add(firstInterval);
        for(int i = 1; i<len; i++){
            int[] temp = intervals[i];
            if(temp[0]<=firstInterval[1]){
                firstInterval[1] = Math.max(temp[1],firstInterval[1]);
            }else{
                firstInterval = temp;
                result.add(temp);
            }
        }
        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] merge = solution.merge(new int[][]{{8, 10}, {1, 3}, {15, 18}, {2, 6}});
        for (int[] arr: merge
        ) {
            System.out.println(Arrays.toString(arr));

        }
    }
}
