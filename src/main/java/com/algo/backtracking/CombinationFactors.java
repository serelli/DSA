package com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationFactors {
    

    public static void main(String[] args){
        CombinationFactors combinationFactors = new CombinationFactors();
        List<List<Integer>> factors = combinationFactors.getFactors(12);
        System.out.println(factors);
    }
    public List<List<Integer>> getFactors(int n) {

        List<List<Integer>> result = new ArrayList<>();
        if (n == 1)
            return result;
        recursion(result, new ArrayList<>(), n, 0,2);
        return result;
    }

    private void recursion(List<List<Integer>> result, List<Integer> tempList, int num, int remainder,int start) {
        if (remainder != 0)
            return;
        if (num>=1 && num<=3 && remainder == 0) {
            if(num!=1)
                tempList.add(num);
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i * i <= num; i++) {
                tempList.add(i);
                recursion(result, tempList, num / i, num % i,i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
