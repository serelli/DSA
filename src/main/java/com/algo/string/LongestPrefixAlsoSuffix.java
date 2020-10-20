package com.algo.string;


// Java program to find length of the longest
// prefix which is also suffix
class LongestPrefixAlsoSuffix {

    static int longestPrefixSuffix(String s)
    {
        int n = s.length();

        if(n < 2) {
            return 0;
        }

        int len = 0;
        int i = n/2;

        while(i < n) {
            if(s.charAt(i) == s.charAt(len)) {
                ++len;
                ++i;
            }
            else
            {
                if(len == 0) { // no prefix
                    ++i;
                }
                else
                {
                    // search for shorter prefixes
                    --len;
                }
            }
        }

        return len;

    }

    // Driver code
    public static void main (String[] args)
    {
        String s = "blablabla";
        System.out.println(longestPrefixSuffix(s));
    }
}
