package com.algo.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithOutRepeatingCharacters {

    public static void main(String[] args) {

        System.out.println(longestUniqueSubsttr("seandeep"));

    }

    //Time complexity : O(2n)=O(n). In the worst case each character will be visited twice by i and j.
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /* The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index.
     Then we can skip the characters immediately when we found a repeated character.
     The reason is that if s[j] have a duplicate in the range [i, j) with index j1
     we don't need to increase i little by little. We can skip all the elements in the range [i, j1] and let i to be j1+1
     directly.*/
    public static int lengthOfLongestSubString1(String s) {

        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

/*  The previous implements all have no assumption on the charset of the string s.
    If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.*/

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    static final int NO_OF_CHARS = 256;

    static int longestUniqueSubsttr(String str)
    {
        int n = str.length();
        int cur_len = 1;    // length of current substring
        int max_len = 1;    // result
        int prev_index;        //  previous index

        int visited[] = new int[NO_OF_CHARS];

        /* Initialize the visited array as -1, -1 is
         used to indicate that character has not been
         visited yet. */
        for (int i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

        /* Mark first character as visited by storing the
             index of first   character in visited array. */
        visited[str.charAt(0)] = 0;

        /* Start from the second character. First character is
           already processed (cur_len and max_len are initialized
         as 1, and visited[str[0]] is set */
        for(int i = 1; i < n; i++)
        {
            prev_index = visited[str.charAt(i)];

            /* If the current character is not present in
           the already processed substring or it is not
              part of the current NRCS, then do cur_len++ */
            if(prev_index == -1 || i - cur_len > prev_index)
                cur_len++;

            /* If the current character is present in currently
               considered NRCS, then update NRCS to start from
               the next character of previous instance. */
            else
            {
                /* Also, when we are changing the NRCS, we
                   should also check whether length of the
                   previous NRCS was greater than max_len or
                   not.*/
                if(cur_len > max_len)
                    max_len = cur_len;

                cur_len = i - prev_index;
            }

            // update the index of current character
            visited[str.charAt(i)] = i;
        }

        // Compare the length of last NRCS with max_len and
        // update max_len if needed
        if(cur_len > max_len)
            max_len = cur_len;

        return max_len;
    }
}
