package com.algo.TwoDimensionalPlane;

import java.util.*;

public class KClosestPointsToOrigin {


    public static void main(String[] args) {

        int[][] input = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        for (int[] i : input) {
            System.out.println(Arrays.toString(i));
        }

        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] result = kClosestPointsToOrigin.kClosest2(input, 2);

        System.out.println("----------------------------Output;--------------------------");
        for (int[] i : result) {
            System.out.println(Arrays.toString(i));
        }
    }

    public int[][] kClosest1(int[][] points, int k) {

        Arrays.sort(points, Comparator.comparingInt(this::squaredDistance));

        int[][] result = Arrays.copyOf(points, k);

        return result;
    }

    private int squaredDistance(int[] x) {

        return x[0] * x[0] + x[1] * x[1];
    }




    public int[][] kClosest2(int[][] points, int k){

        Queue<int[]> queue = new PriorityQueue<>(k, Comparator.comparingInt(this::squaredDistance).reversed());

        Arrays.stream(points).forEach(x ->
        {queue.offer(x);
        if(queue.size()>k) queue.poll();});
        int[][] result = new int[queue.size()][2];

        int i=0;
        while(queue.size()>0){
             result[i++] = queue.poll();
        }
        return result;
    }

}
