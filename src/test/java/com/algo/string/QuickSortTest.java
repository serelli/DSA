package com.algo.string;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] inArray = new int[]{2, 1, 3, 9, 4, 7};
        System.out.println(Arrays.toString(inArray));
        QuickSortTest sort = new QuickSortTest();
        sort.sort(inArray, 0, inArray.length - 1);
        System.out.println(Arrays.toString(inArray));

    }


    private void  sort(int[] input, int start, int end){

        if(start>=end){
            return;
        }

        int partition = partition(input,start,end);

        sort(input,start,partition-1);
        sort(input,partition,end);


    }

    private int partition(int[] input, int start, int end){
        int pivot = input[end];

        for(int i = start;i<end;i++){
            if(input[i]< pivot){
                swap(input,start,i);
                start++;
            }
        }
        swap(input,start,end);
        return start;
    }

    private void swap(int[] input, int start, int i) {

        int temp = input[start];
        input[start] = input[i];
        input[i] = temp;

    }


}
