package com.algo.string;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int MaximumPossibleValue(int N) {
        if (N == 0) {
            return 50;
        }
        List<Integer> list = new ArrayList<>();
        boolean isNeg = N < 0;
        if(isNeg)
            N = N *(-1);
        while (N > 0) {
            list.add(N % 10);
            N /= 10;
        }
        int k = 0;
        int isAppend = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (isNeg) {
                if (isAppend==0 && list.get(i) > 5) {
                    k = k * 10 + 5;
                    isAppend = 1;
                }

            } else {
                if (isAppend==0 && list.get(i) < 5) {
                    k = k * 10 + 5;
                    isAppend = 1;
                }
            }

            k = k * 10 + list.get(i);
        }
        if (isAppend==0) {
            k = k * 10 + 5;
        }
        return k * (isNeg ? -1 : 1);
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int i = sol.MaximumPossibleValue(670);
        System.out.println(i);
    }
}
