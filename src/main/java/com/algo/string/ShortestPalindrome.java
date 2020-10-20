package com.algo.string;

public class ShortestPalindrome {


    public static void main(String[] args){

    }

    private String shortestPalindrome(String str){

        int low = 0; int end = str.length()-1;
        int high = end;
        while(low<high){
            if(str.charAt(low)== str.charAt(high)){
                low++;
                high--;
            }else{
                low = 0;
                end--;
                high = end;
            }
        }
        return new StringBuilder(str.substring(end+1)).reverse()+str;
    }

    //aacecaaa -> aacecaaa#aaacecaa
    public String shortestPalindromeUsingKMP(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);

        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public int[] getTable(String s){
        int[] table = new int[s.length()];

        int index = 0;
        for(int i = 1; i < s.length(); ){
            if(s.charAt(index) == s.charAt(i)){
                table[i] = ++index;
                i++;
            } else {
                if(index > 0){
                    index = table[index-1];
                } else {
                    index = 0;
                    i ++;
                }
            }
        }
        return table;
    }
}
