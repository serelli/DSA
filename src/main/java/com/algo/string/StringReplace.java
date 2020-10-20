package com.algo.string;

public class StringReplace {

    public static void main(String[] args){

        String result = replace("x%20x%20", "%20", "c");
        System.out.println(result);
    }

    private static String replace(String s, String s1, String s2){

        char[] sArr = s.toCharArray();
        int j =0;
        int i=0;
        for( ;i<=sArr.length-3;){
            if(sArr[i]==s1.charAt(0) && sArr[i+1]==s1.charAt(1) && sArr[i+2]==s1.charAt(2)){
                 sArr[j++] = s2.charAt(0);
                 i = i+2;
            }else{
                sArr[j++] = sArr[i];
            }
            i++;
        }
        while(i<sArr.length){
            sArr[j++]=sArr[i++];
        }
        return  new String(sArr,0,j);
    }
}
