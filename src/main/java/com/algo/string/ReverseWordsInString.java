package com.algo.string;

import java.util.Arrays;

public class ReverseWordsInString {



    public static void main(String[] args){
          ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        String resultStr = reverseWordsInString.reverseWords("F R  I   E    N     D      S      ");

        System.out.println("result : "+resultStr);


    }

    private String reverseWords(String str){
        if(str==null || str.length()<2)
            return str;
        String[] words = str.split(" ");
        System.out.println(Arrays.toString(words));
        StringBuilder sb = new StringBuilder();
        int i = words.length-1;
        while(i>=0) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]);
                if (i!= 0) sb.append(" ");
            }
            i--;
        }

        return sb.toString();
    }
}
