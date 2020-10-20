package com.algo.binarysearchexamples;

public class MedianOfTwoSortedArrays {

    //Time Complexity : O(log(min(n, m))), where n and m are the sizes of given sorted array
    public double medianOfSortedArrays(int[] input1, int[] input2) {

        if (input1.length > input2.length)
            return medianOfSortedArrays(input2, input1);

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionx = (low + high) / 2;
            int partiiony = (x + y + 1) / 2 - partitionx;

            //if partitionx is 0 it means nothing is there on the left side, use -infinity for maxleftx
            int maxleftx = partitionx == 0 ? Integer.MIN_VALUE : input1[partitionx - 1];
            // if partitionx is length of the inputx then there is nothing on the right side,
            // use +infinity for minrightx.
            int minrightx = partitionx == x ? Integer.MAX_VALUE : input1[partitionx];

            int maxlefty = partiiony == 0 ? Integer.MIN_VALUE : input2[partiiony - 1];
            int minrighty = partiiony == y ? Integer.MAX_VALUE : input2[partiiony];

            if (maxleftx <= minrighty && maxlefty <= minrightx) {
                // now we have partitioned arrays at correct place
                // now we get max of left elements and min of right elements to get the median in case of even length
                // of combined array size or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxleftx, maxlefty) + Math.min(minrightx, minrighty)) / 2.0;
                } else {
                    return (double) Math.max(maxleftx, maxlefty);
                }
            } else if (maxleftx > minrighty) {   // we are too far on the right side of partitionx, go on left side.
                high = partitionx - 1;

            } else {  // we are too far on the left side of partitionx, go on right side.
                low = partitionx + 1 ;
            }

        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int []a = new int[]{900};
        int []b = new int[]{10, 13, 14};

        System.out.println(medianOfTwoSortedArrays.medianOfSortedArrays(a,b));
        System.out.println("Median should be "+ (13+14)/2.0);
    }
}
