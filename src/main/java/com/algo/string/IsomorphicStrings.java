package com.algo.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {

        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isomorphicString("egg","add"));
        System.out.println(isomorphicStrings.isomorphicString("bbbaaaba",
                "aaabbbba"));


    }

    private boolean isomorphicString(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> s1 = new HashMap<>();
        Map<Character, Integer> s2 = new HashMap<>();

        for (int i = 0; i <= s.length() - 1; i++) {
            if (s1.getOrDefault(s.charAt(i), 0) != s2.getOrDefault(t.charAt(i), 0)) return false;
            s1.put(s.charAt(i), s1.getOrDefault(s.charAt(i), 0) + i + 1);
            s2.put(t.charAt(i), s2.getOrDefault(t.charAt(i), 0) + i + 1);
        }
        return true;

    }

    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;

    }
}
