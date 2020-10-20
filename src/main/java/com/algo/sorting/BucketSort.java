package com.algo.sorting;

/*
Bucket Sort
Bucket sort is mainly useful when input is uniformly distributed over a range. For example, consider the following problem.
Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed across the range. How do we sort the numbers efficiently?

A simple way is to apply a comparison based sorting algorithm. The lower bound for Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(n Log n), i.e., they cannot do better than nLogn.
Can we sort the array in linear time? Counting sort can not be applied here as we use keys as index in counting sort. Here keys are floating point numbers.
The idea is to use bucket sort. Following is bucket algorithm.

bucketSort(arr[], n)
1) Create n empty buckets (Or lists).
2) Do following for every array element arr[i].
.......a) Insert arr[i] into bucket[n*array[i]]
3) Sort individual buckets using insertion sort.
4) Concatenate all sorted buckets.

Time Complexity = O(n+k) where n = num of elements and k is range
Space Complexity = O(n+k)

Bucket Sort - Important points to remember
Here are some important points about bucket sort you should remember, this is useful from both interview and understanding point of view and Interviewer expects that you know about them when you say that you know bucket sort.

1) Bucket Sort is also known as bin sort because you create bins or buckets to sort inputs.

2) Bucket sort is only useful when the input is uniformly distributed over a range like coins, numbers 1 to 100 etc.

3) You can use a linked list or array as a bucket. The choice of data structure will affect the insertion time e.g. if you use linked list then adding on the head could take O(1) time. You can also use hash tables as buckets.

4) The bucket sort is one of the rare O(n) sorting algorithm i.e. time complexity of Bucket sort is the liner in best and average case and not NLogN like Quicksort or Mergesort.

5) Bucket sort is not a stable sorting algorithm because in a stable algorithm if two input is same they retain their place in sorted order and in the bucket it depends upon how you sort the individual bucket. Though, bucket sort can be made stable, known as radix sort, which we'll see in future articles.

6) You can sort the elements inside individual buckets either by recursively calling the bucket sort or using a separate sorting algorithm like insertion sort, bubble sort, or quicksort.

7) Is bucket sort an in-place sorting algorithm? No, it's not an in-place sorting algorithm. The whole idea is that input sorts themselves as they are moved to the buckets. In the worst of the good cases (sequential values, but no repetition) the additional space needed is as big as the original array.

8) The worst case complexity of bucket sort, when all elements will end up in the same bucket is O(n^2) because then it has to be sorted by a different sorting algorithm.

9) The space complexity of bucket sort is O(n) because even to sort sequential values, without repetition, you need an array as big as the original array.


That's all about bucket sort in Java. It's one of the interesting sorting algorithms which gives you O(n) performance in the best and average case. Bucket sort should only be used when the input is uniformly distributed over a range e.g. numbers up to 1 to 1000.

You should also remember that Bucket sort is not a stable algorithm hence it's not guaranteed that equal keys on input array will retain their places.

It is also not an in-place algorithm, as it will require additional space as big as the original array in the worst case. You can also refer following resources for more details on bucket sort and other O(n) sorting algorithms like Counting sort, Radix sort etc.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* *
 * Java Program sort an integer array using radix sort algorithm.
 *  input: [80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50]
 *  output: [0, 10, 20, 30, 40, 50, 50, 60, 70, 80, 90]
 *  Time Complexity of Solution:
 *  Best Case O(n); Average Case O(n);
 * Worst Case O(n^2).
 * */

public class BucketSort {
    public static void main(String[] args) {
        System.out.println("Bucket sort in Java");
        int[] input = {80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50};
        System.out.println("integer array before sorting");
        System.out.println(Arrays.toString(input));
        // sorting array using radix Sort Algorithm
        bucketSort(input);
        System.out.println("integer array after sorting using bucket sort algorithm");
        System.out.println(Arrays.toString(input));
    }

    /**
     * * @param input
     */
    public static void bucketSort(int[] input) {
        // get hash codes
        final int[] code = hash(input);
        // create and initialize buckets to ArrayList: O(n)
        List<Integer>[] buckets = new List[code[1]];
        for (int i = 0; i < code[1]; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        // distribute data into buckets: O(n)
        for (int i : input) {
            int hash = hash(i, code);
            System.out.println(i+" hash value "+hash);
            buckets[hash].add(i);
        }

        // sort each bucket O(n)
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }
        int ndx = 0;
        // merge the buckets: O(n)
        for (int b = 0; b < buckets.length; b++) {
            for (int v : buckets[b]) {
                input[ndx++] = v;
            }
        }
    }

    /**
     * * @param input * @return an array containing hash of input
     */
    private static int[] hash(int[] input) {
        int m = input[0];
        for (int i = 1; i < input.length; i++) {
            if (m < input[i]) {
                m = input[i];
            }
        }
        return new int[]{m, (int) Math.sqrt(input.length)};
    }

    /**
     * * @param i * @param code * @return
     */
    private static int hash(int i, int[] code) {
        return (int) ((double) i / code[0] * (code[1] - 1));
    }

}


/*

Bucket Sort vs Counting Sort
If you keep these prerequisites aside, bucket sort is actually very good considering that counting sort is reasonably equal to its upper bound and counting sort is also super fast.

The particular distinction for bucket sort is that it uses a hash function to partition the keys of the input array, so that multiple keys may hash to the same bucket.  Hence each bucket must effectively be a growable list; similar to Radix sort, another O(n) sorting algorithms.

Many programmers get confused between Counting Sort and Bucket sort as they work quite similar, but the most important difference between them is that Bucket sort uses a hash function to distribute keys while Counting sort creates a bucket for each key.

In our example, I have used JDK's Collections.sort() method to sort each bucket. This is to indicate that the bucket sort algorithm does not specify which sorting algorithm should be used to sort individual buckets.

A programmer may choose to recursively use bucket sort on each bucket until the input array is sorted, similar to radix sort. Anyway, whichever sorting method you use to sort individual buckets, the time complexity of bucket sort will still tend towards O(n).

I think there are perhaps greater similarities between radix sort and bucket sort than there are between counting sort and bucket sort. You can also read Introduction to Algorithm by Thomas H. Cormen to learn more about the difference between these two constant time sorting algorithms.

 */
