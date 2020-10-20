package com.algo.sorting;


import java.util.Arrays;

/**
 * 1) Merge sort is a based on a divide and conquer algorithm.
 * 2) use Recursion to implement.
 * 3) it's a stable sorting algorithm.(in stable sorting, the relative order of elements/records with the same key is preserved.
 * 4) Not an in-place algorithm, space complexity is O(n).
 * 5) Time Complexity worst case is O(n log n).
 *
 */
public class MergeSort {

    public static void main(String[] args){
        int[] inArray = new int[]{2,1,3,9,4,7};
        System.out.println(Arrays.toString(inArray));
        MergeSort sort = new MergeSort();
        sort.sort(inArray, 0, inArray.length-1);
        System.out.println(Arrays.toString(inArray));
    }


    /*
    * MergeSort(arr[], l,  r)
    If l >= r
      return;

     1. Find the middle point to divide the array into two halves:
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
     */
    private void sort(int[] input, int low, int high){

        if(low>= high){
            return;
        }

        int middle = low+ (high-low)/2;
        
        sort(input, low, middle );
        sort(input, middle+1, high);
        sortMerge(input, low, middle, high);

    }

    private void sortMerge(int[] input, int low, int middle, int high){


        int i= low;
        int j= middle+1;
        int[] temp = new int[high-low+1];
        int r =0;

        while(i<= middle && j<= high){

            if(input[i]<=input[j]){    // if remove '=' in the if condition, then this becomes not a stable sorting algorithm
                temp[r++]= input[i++];
            }else{
                temp[r++] = input[j++];
            }

        }
        while(i<=middle){
            temp[r++] = input[i++];
        }
        while(j<=high){
            temp[r++] = input[j++];
        }
        for(int k=0; k<temp.length; k++){
            input[low++]= temp[k];
        }
    }

}
