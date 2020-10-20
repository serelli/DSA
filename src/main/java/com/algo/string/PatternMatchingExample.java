package com.algo.string;

public class PatternMatchingExample {

    public static void main(String[] args){
            PatternMatchingExample patternMatchingExample = new PatternMatchingExample();
            int index = patternMatchingExample.firstOccurenceIndex("elephants","ante");
            System.out.println(index);
    }

    public int firstOccurenceIndex(String str, String pattern){
        int s = str.length();
        int p = pattern.length();
        for(int i = 0; i<s-p+1;i++){
            int j;
            for(j = 0; j<p;j++){
                if(str.charAt(i+j)!=pattern.charAt(j)) break;
            }
             if(j==p) return i;
        }
        return -1;
    }
}
