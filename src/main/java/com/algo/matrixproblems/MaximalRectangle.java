package com.algo.matrixproblems;

import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args){
        MaximalRectangle mr = new MaximalRectangle();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        mr.maximalRectangle(matrix);
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea =0;
        int[] heights = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            heights = getHeights(matrix,i,heights);
            maxArea = Math.max(maxArea,getMaxArea(heights));
        }
        return maxArea;
    }

    private int[] getHeights(char[][] matrix, int row, int[] heights){
        for(int i=0;i<matrix[0].length;i++){
            heights[i] = matrix[row][i]=='1'?1+heights[i]:0;
        }
        return heights;
    }

    private int getMaxArea(int[] heights){

        Stack<Integer> stack = new Stack<>();
        int low=0, high= heights.length-1;
        int maxArea = 0;

        while(low<=high){
            if(stack.isEmpty() || heights[stack.peek()]<=heights[low]){
                stack.push(low++);
            }else{
                int index = stack.peek();
                stack.pop();
                maxArea = Math.max(maxArea,heights[index]*(stack.isEmpty()?low:low-stack.peek()-1));
            }
        }
        while(!stack.isEmpty()){
            int index = stack.peek();
            stack.pop();
            maxArea = Math.max(maxArea,heights[index]*(stack.isEmpty()?low:low-stack.peek()-1));
        }
        return maxArea;
    }
}
