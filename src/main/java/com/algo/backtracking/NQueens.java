package com.algo.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NQueens {


    public static void main(String[] args){
        NQueens q = new NQueens();
        List<List<String>> lists = q.solveNQueens(4);
        System.out.println(lists);

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int[] cols = new int[n];
        Map<Integer, Integer> diagnol = new HashMap<>();
        Map<Integer, Integer> antidiagnol = new HashMap<>();

        if (n > 0) {
            recursion(0, n, cols, diagnol, antidiagnol, res, result);

        }
        return result;


    }

    public void recursion(int row, int n, int[] cols, Map<Integer, Integer> diagnol, Map<Integer, Integer> antidiagnol, List<String> res, List<List<String>> result) {

        if (row == n) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, cols, diagnol, antidiagnol)) {
                String str = placeQueen(row, col, cols, diagnol, antidiagnol);
                res.add(str);
                recursion(row + 1, n, cols, diagnol, antidiagnol, res, result);
                removeQueen(row, col, cols, diagnol, antidiagnol);
                res.remove(res.size() - 1);
            }

        }


    }

    private void removeQueen(int row, int col, int[] cols, Map<Integer, Integer> diagnol, Map<Integer, Integer> antidiagnol) {

        cols[col]--;
        diagnol.remove(row+col);
        antidiagnol.remove(row-col);

    }


    private String placeQueen(int row, int col, int[] cols, Map<Integer, Integer> diagnol, Map<Integer, Integer> antidiagnol) {

        cols[col] = 1;
        diagnol.put(row + col, 1);
        antidiagnol.put(row - col,1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            if (i == col)
                sb.append("Q");
            else
            sb.append(".");
        }
        return sb.toString();

    }

    private boolean isValid(int row, int col, int[] cols, Map<Integer, Integer> diagnol, Map<Integer, Integer> antidiagnol) {

        if (cols[col]==1 || diagnol.containsKey(row+col) || antidiagnol.containsKey(row-col) )
            return false;
        return true;
    }
}
