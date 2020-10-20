package com.algo.matrixproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix m = new SpiralMatrix();
        int[][] input = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for(int[] in: input)
        System.out.println(Arrays.toString(in));
        System.out.println("-----------------------------");
        m.transpose(input);

        for(int[] in: input)
            System.out.println(Arrays.toString(in));

    }

    public List<Integer> spiral(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;

        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0, c = 0, di = 0;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        for (int i = 0; i < rows * cols; i++) {
            result.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];

            if (0 <= cr && cr < rows && 0 <= cc && cc < cols && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }

        }
        return result;
    }

    public void transpose(int[][] matrix){

        for(int i=0;i<matrix.length;i++) {
            for (int j = i+1; j < matrix[0].length; j++) {

                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
            }
        }
    }
}
