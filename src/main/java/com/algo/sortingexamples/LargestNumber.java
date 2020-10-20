package com.algo.sortingexamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

    public static void main(String[] args){
        LargestNumber largestNumber = new LargestNumber();
        String largestNumber1 = largestNumber.getLargestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(largestNumber1);
    }
    private String getLargestNumber(int[] nums){
        List<String> strList = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());

        strList.sort((String x, String y) -> {
                                            String yy =  y+x;
                                            String xx = x+y;
                                            return yy.compareTo(xx);});

        StringBuilder sb = new StringBuilder();

        for(String str : strList){
            sb.append(str);
        }

          return sb.toString();
    }
}
