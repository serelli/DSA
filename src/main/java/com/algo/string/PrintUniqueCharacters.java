package com.algo.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PrintUniqueCharacters {

    public static void main(String[] args) {
        String s = "abdadfv";
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);

        }
        System.out.println(map);
        for (Map.Entry<Character, Integer> kvSet : map.entrySet()) {
            if (kvSet.getValue() == 1)
          System.out.println(kvSet.getKey());

        }

    }


    public void getUniqueString(char[] arr) {

        int[] intArray = new int[256];

        for (int j = 0; j < 256; j++) {
            intArray[j] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            intArray[ch] = 1;
        }

    }
}
