package com.algo.graph;


import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {
    public int orangesRotting(int[][] grid) {

        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int rows = grid.length;
        int cols = grid[0].length;
        int count_fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }
                if(grid[i][j]==1)
                    count_fresh++;
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            ans = temp[2];
            for(int[] d: dir){
                int nr = temp[0]+d[0];
                int nc = temp[1]+d[1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                    q.offer(new int[]{nr,nc,temp[2]+1});
                    count_fresh--;
                }
            }

        }
        return count_fresh==0? ans: -1;
    }

    public static void main(String[] args){
        RottenOranges rottenOranges = new RottenOranges();
        int[][] grid= new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        int i = rottenOranges.orangesRotting(grid);
        System.out.println(i);
    }
}
