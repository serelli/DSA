package com.algo.arrays;

import java.util.ArrayList;
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
    public static void main(String[] args){
        GeneratePascalsTriangle gps = new GeneratePascalsTriangle();
        gps.generate(5);
    }
}
