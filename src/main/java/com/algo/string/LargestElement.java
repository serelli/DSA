package com.algo.string;

import java.util.HashMap;
import java.util.Map;

public class LargestElement {


    public static void main(String[] args){

        LargestElement element = new LargestElement();
        System.out.println(element.solution("aaBabcDaA"));
        System.out.println(element.solution("Codility"));
        System.out.println(element.solution("WeTestCodErs"));
    }

    //"aaBabcDaA"
    private String solution(String S){
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<S.length();i++){
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
        }

        for(char ch = 'z'; ch>='a';ch--){
            int lowerCaseCount = map.getOrDefault(ch,0);
            int upperCaseCount = map.getOrDefault(Character.toUpperCase(ch),0);
            if(lowerCaseCount>0 && upperCaseCount>0 )
                return String.valueOf(Character.toUpperCase(ch));
        }
        return "NO";
    }
}
