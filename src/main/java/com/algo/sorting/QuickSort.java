package com.algo.sorting;

import java.util.Arrays;


/*
1) Divide and Conquer algorithm. 
2) use of Recursion.
3) Not a stable by default in nature
4) Time Complexity best or average case: O(nlogn), worst case: O(n^2)
5) but the worst case can almost always be avoided by using what we call randomized version of quicksort.
6) in place algorithm, don't need any space unlike merge sort that is why quiet popular of sorting algorithm
   space complexity O(1).


Pick a “pivot” element.
“Partition” the array into 3 parts:
First part: all elements in this part should be less than the pivot.
Second part: the pivot itself (only one element!)
Third part: all elements in this part must be greater than or equal to the pivot.
Then, apply the quicksort algorithm to the first and the third part. (recursively)

Some sorting algorithms are stable by nature like Insertion sort, Merge Sort, Bubble Sort, etc. And some sorting algorithms are not, like Heap Sort, Quick Sort, etc.
QuickSort is an unstable algorithm because we do swapping of elements according to pivot’s position (without considering their original positions).
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] inArray = new int[]{2, 1, 3, 9, 4, 7};
        System.out.println(Arrays.toString(inArray));
        QuickSort sort = new QuickSort();
        sort.sort(inArray, 0, inArray.length - 1);
        System.out.println(Arrays.toString(inArray));

    }

    private void sort(int[] input, int low, int high) {

        if (low >= high)
            return;
        int partitionIndex = partition(input, low, high);

        sort(input, low, partitionIndex - 1);
        sort(input, partitionIndex + 1, high);

    }

    private int partition(int[] input, int start, int end) {
        //pick a pivot in input array
        int pivot = input[end];

        for (int i = start; i < end; i++) {
            if (input[i] < pivot) {
                swap(input, i, start);
                start++;
            }

        }

        swap(input, start, end);

        return start;
    }

    private void swap(int[] array, int firstIndex, int lastIndex) {

        if (firstIndex == lastIndex)
            return;
        int temp = array[firstIndex];
        array[firstIndex] = array[lastIndex];
        array[lastIndex] = temp;
    }
}
