package com.algo.mathematical;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthsmallestSums {

    public static void main(String[] args ){
        KthsmallestSums num = new KthsmallestSums();
        System.out.println(num.kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3));

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                pq.offer(new Node(nums1[i]+nums2[j],nums1[i],nums2[j]));
            }
        }
        int p = 0;
        while(!pq.isEmpty() && p<k){
            result.add(pq.poll().res);
            p++;
        }
        return result;
    }


    class Node implements Comparable<Node>{
        int sum;
        List<Integer> res;
        public Node(int sum,int a, int b){
            this.sum=sum;
            res  = new ArrayList<>();
            res.add(a);
            res.add(b);
        }
        public int compareTo(Node node){
            return  this.sum - node.sum;
        }
    }
}
