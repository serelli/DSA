package com.algo.string;

import java.util.HashSet;
import java.util.Set;

public class StringSearchAlgorithm {

    public static void main(String[] args) {
       // search("AABA","AABAACAADAABAABA");
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        StringSearchAlgorithm obj = new StringSearchAlgorithm();
              //  obj.KMPSearch(pat, txt);
        Set<Integer> set = new HashSet<>();
        set.add(10);
        String s = obj.replaceAllPhrases(txt, set, 9, "AMMA");
System.out.println(s);
        System.out.println("ABABDABACD"+"AMMA");


    }

    public static int search(String pattern, String text) {

        int n = text.length();
        int m = pattern.length();

        for(int i =0; i<=n-m; i++){
            int j;
            for(j=0;j<m;j++){
                if(text.charAt(i+j)!=pattern.charAt(j)){
                    break;
                }
            }
            if (j==m) System.out.println(i);

        }

        return -1;
    }

    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    // build LPS Array with values (find Longest proper prefix which also a suffix)
    public void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public String replaceAllPhrases(String text, Set<Integer> set, int patternLen,String replace){

        int low =0;
        int curr =0;
        int high = text.length()-1;
        char[] chars = text.toCharArray();
        while(curr<=high){

            if(set.contains(curr)){
                for(int i =0;i<replace.length();i++) {
                    chars[low+i] = replace.charAt(i);
                }
                low = low+replace.length();
                curr = curr+ patternLen;
            }else{
                chars[low++] = chars[curr++];
            }
        }
        return new String(chars,0,low);
    }

}
