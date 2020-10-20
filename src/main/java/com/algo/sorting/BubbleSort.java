package com.algo.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){


        int[] inArray = new int[]{4, 1, 3, 2, 9, 7};
        System.out.println(Arrays.toString(inArray));
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(inArray);
        System.out.println(Arrays.toString(inArray));

    }

    private void sort(int[] input){
        System.out.println("------enter-----------");


        for(int i= 0 ;i<input.length;i++){
            boolean  swapped= false;
            for(int j = i; j<input.length-1;j++){
                if(input[j]> input[j+1])        {
                    swap(input,j,j+1);
                    swapped = true;
                }

            }
            if(!swapped){
                break;
            }
            System.out.println(Arrays.toString(input));
        }

        System.out.println("------exit-----------");

    }

    private void swap(int[] array, int firstIndex, int lastIndex) {

        if (firstIndex == lastIndex)
            return;
        int temp = array[firstIndex];
        array[firstIndex] = array[lastIndex];
        array[lastIndex] = temp;
    }
}
