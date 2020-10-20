package com.algo.string;

public class ValidPalindrome {


    public boolean isPalindrome(String s) {

        int[] memo = new int[256];
        for(int i=0;i<10;i++){
            memo[i+'0']= 1000+i;
        }
        for(int i =0;i<26;i++){
            memo['a'+i]=i+1;
            memo['A'+i] =i+1;
        }

        int i=0;
        int j = s.length()-1;
        while(i<j){
            while(i<j && memo[s.charAt(i)]==0 ){
                i++;
            }
            while(i<j && memo[s.charAt(j)]==0 ){
                j--;
            }
            if(memo[s.charAt(i)]!=memo[s.charAt(j)])
                return false;
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args){
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrome("race a car");
    }
}
