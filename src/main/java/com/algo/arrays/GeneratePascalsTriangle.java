package com.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratePascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(j,1);
                }else{
                    row.add(j,result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(new Integer[]{1});
        result.add(row1);
        for(int i =1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j =0;j<=i;j++){

                if(j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }

            }
            result.add(row);

        }
        return result;
    }
    public static void main(String[] args){
        GeneratePascalsTriangle gps = new GeneratePascalsTriangle();
        gps.generate1(5);
    }
}
