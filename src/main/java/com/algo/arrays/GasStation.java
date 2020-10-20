package com.algo.arrays;

public class GasStation {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            for(int i=0;i<gas.length;i++){
                int startIndex = i;
                int count =0;
                int sum=0;
                while(count<gas.length){
                    if((gas[startIndex]+sum)-cost[startIndex] <0) break;
                    else sum =  (gas[startIndex]+sum)-cost[startIndex];
                    count++;
                    startIndex++;
                    if(startIndex==gas.length) startIndex=0;
                }
                if(count==gas.length) return i;
            }
            return -1;
        }

        public static void main(String[] args){

            GasStation gs = new GasStation();
            int i = gs.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
            System.out.println(i);
        }
}
