package com.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class LongestSubStringSolution {
    public static void main(String[] args) {

        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        main1(args);
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        int len = 0;
        for (int i = 0, j = 0; i < arr.length; ) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
                len = Math.max(i - j + 1, len);
                i++;
            } else {
                j = Math.max(j, map.get(arr[i]) + 1);
                map.remove(arr[i]);
            }

        }
        return len;

    }



    public static void main1(String[] args){
        System.out.println("sandeep erelli");
    }
}
