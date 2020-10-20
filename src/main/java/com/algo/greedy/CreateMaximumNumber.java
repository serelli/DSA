package com.algo.greedy;

import java.util.Arrays;
import java.util.Stack;


/*Solution
        To solve this problem, first let’s look at simpler version:

        Easy Version No. 1
        Given one array of length n, create the maximum number of length k.

        The solution to this problem is Greedy with the help of stack. The recipe is as following

        Initialize a empty stack
        Loop through the array nums
        pop the top of stack if it is smaller than nums[i] until
        stack is empty
        the digits left is not enough to fill the stack to size k
        if stack size < k push nums[i]
        Return stack
        Since the stack length is known to be k, it is very easy to use an array to simulate the stack.
        The time complexity is O(n) since each element is at most been pushed and popped once.

        Java

public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
        while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
        if (j < k) ans[j++] = nums[i];
        }
        return ans;
        }

public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
        while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
        if (j < k) ans[j++] = nums[i];
        }
        return ans;
        }
        Easy Version No. 2
        Given two array of length m and n, create maximum number of length k = m + n.

        OK, this version is a lot closer to our original problem with the exception that we will use all the digits we have.

        Still, for this version, Greedy is the first thing come to mind. We have k decisions to make, each time will just need to decide ans[i] is from which of the two. It seems obvious, we should always choose the larger one right? This is correct, but the problem is what should we do if they are equal?

        This is not so obvious. The correct answer is we need to see what behind the two to decide. For example,

        nums1 = [6, 7]
        nums2 = [6, 0, 4]
        k = 5
        ans = [6, 7, 6, 0, 4]

        We decide to choose the 6 from nums1 at step 1, because 7 > 0. What if they are equal again? We continue to look the next digit until they are not equal. If all digits are equal then choose any one is ok. The procedure is like the merge in a merge sort. However due to the “look next until not equal”, the time complexity is O(nm).

        As @lixx2100 mentioned that it is possible to have a linear time merge algorithm based on suffix array. See here and here. But there isn’t a short implementation for suffix array construction in linear time.

        Java

private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
        ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
        }
public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
        i++;
        j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
        }

private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
        ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
        }
public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
        i++;
        j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
        }
        Final Solution
        Now let’s go back to the real problem. First, we divide the k digits required into two parts, i and k-i. We then find the maximum number of length i in one array and the maximum number of length k-i in the other array using the algorithm in section 1. Now we combine the two results in to one array using the algorithm in section 2. After that we compare the result with the result we have and keep the larger one as final answer.

        Java

public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
        int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
        if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
        }

public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
        int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
        if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
        }*/
public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args){
        //nums1 = [3, 4, 6, 5]
        //nums2 = [9, 1, 2, 5, 8, 3]
        //k = 5

        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        //int[] ans = createMaximumNumber.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        //System.out.println(Arrays.toString(ans));

        createMaximumNumber.maxNumber(new int[]{3, 4, 6, 5},3);

    }


    //select a maximum number from a array with k digits

    private void maxNumber(int[] nums, int k){
        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<nums.length;i++){
            while(stack.size()+nums.length-i > k && !stack.isEmpty() && stack.peek()<nums[i]) stack.pop();
            if(stack.size()<k)stack.push(nums[i]);
        }
        System.out.println(stack);
    }
}
