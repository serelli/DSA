package com.algo.dynamicprogamming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestFibonocciSubSequence {

    public static void main(String [] args){
        LengthOfLongestFibonocciSubSequence obj = new LengthOfLongestFibonocciSubSequence();
        obj.lenLongestFibSubseqDP(new int[]{1,2,3,4,5,6,7,8});
    }

    //bruteForce
    //Time Complexity: O(N^2 log M) where N is the length of A, and M is the maximum value of A.
    //Space Complexity: O(N), the space used by the set S.
    public int lenLongestFibSubseq(int[] A) {
        int max= 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<A.length;i++){
            set.add(A[i]);
        }

        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                int x=A[j];
                int y = A[i]+A[j];
                int length =2;
                while(set.contains(y)){
                    int temp = y;
                    y = x+y;
                    x = temp;
                    max = Math.max(max,++length);
                }
            }
        }
        return A.length>=3?max:0;
    }
//Complexity Analysis
//Time Complexity: O(N^2) where N is the length of A.
//Space Complexity: O(NlogM), where M is the largest element of A. We can show that the number of elements in a subsequence is bounded by O(\log \frac{M}{a})O(log//a//M
// ) where aa is the minimum element in the subsequence.
        public int lenLongestFibSubseqDP(int[] A) {
            int N = A.length;
            Map<Integer, Integer> index = new HashMap();
            for (int i = 0; i < N; ++i)
                index.put(A[i], i);

            Map<Integer, Integer> longest = new HashMap();
            int ans = 0;

            for (int k = 0; k < N; ++k){
                for (int j = 0; j < k; ++j) {
                    System.out.println(k+"-"+j);
                }}
            for (int k = 0; k < N; ++k)
                for (int j = 0; j < k; ++j) {
                    int i = index.getOrDefault(A[k] - A[j], -1);
                    if (i >= 0 && i < j) {
                        // Encoding tuple (i, j) as integer (i * N + j)
                        int cand = longest.getOrDefault(i * N + j, 2) + 1;
                        longest.put(j * N + k, cand);
                        ans = Math.max(ans, cand);
                    }
                }

            return ans >= 3 ? ans : 0;
        }



}
