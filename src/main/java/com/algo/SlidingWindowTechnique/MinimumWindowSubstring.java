package com.algo.SlidingWindowTechnique;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        String res = "";
        int i = 0;
        int k = t.length(), j = t.length();
        while (j < s.length() && j - i >= k) {
            if (i!=0 && j - i == k) {
                i = j;
                j = j + k;
            }
            if (contains(s.substring(i, j), t)) {
                if (min > s.substring(i, j).length()) {
                    min = s.substring(i, j).length();
                    res = s.substring(i, j);
                }
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    private boolean contains(String str, String t) {
        int[] arr = new int[256];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int j = 0; j < t.length(); j++) {
            arr[t.charAt(j)]--;
            if (arr[t.charAt(j)] < 0)
                return false;
        }
        return true;

    }


    public static void main(String[] args){

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
