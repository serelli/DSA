package com.algo.string;

public class RemoveConsecutiveDuplicateCharsFromString {

    public static void main(String[] args) {
        RemoveConsecutiveDuplicateCharsFromString removeConsecutiveDuplicateCharsFromString = new RemoveConsecutiveDuplicateCharsFromString();
        /*System.out.println(removeConsecutiveDuplicateCharsFromString.removeConsecutiveDuplicateCharacters("aaaaabbbbbb").equals("ab"));
        System.out.println(removeConsecutiveDuplicateCharsFromString.removeConsecutiveDuplicateCharacters("geeksforgeeks").equals("geksforgeks"));
        System.out.println(removeConsecutiveDuplicateCharsFromString.removeConsecutiveDuplicateCharacters("aabccba").equals("abcba"));

        System.out.println(removeConsecutiveDuplicateCharsFromString.removeConsecutiveDuplicateCharacters("aaabjjjezzzzziiij"));
        System.out.println(removeConsecutiveDuplicateCharsFromString.removeConsecutiveDuplicateCharacters("aaabccffff"));*/
        
        System.out.println(removeConsecutiveDuplicateCharsFromString.removeOnlySpecifiedCharDuplicate("**bdj****ef******",'*'));

    }

    private String removeConsecutiveDuplicateCharacters(String str) {

        char[] chArr = str.toCharArray();

        /*int j = 0;
        for(int i=0; i<chArr.length-1;i++){
            if(chArr[i]!=chArr[i+1]){
                chArr[++j]= chArr[i+1];
            }
        }*/

        int j = 0;
        for (int i = 1; i < chArr.length; i++) {
            if (chArr[j] != chArr[i]) {
                j++;
                chArr[j] = chArr[i];
            }
        }
        return new String(chArr, 0, j + 1);

    }

    private String removeOnlySpecifiedCharDuplicate(String str, char ch) {

        char[] original = str.toCharArray();

        boolean firstIndex = true;                                
        int j=0;
        for (int i = 0; i < original.length; i++) {
            if(original[i]==ch) {
                if (firstIndex) {
                    original[j++] = original[i];
                    firstIndex = false;
                }
            }else{
                original[j++] = original[i];
                firstIndex = true;
            }
        }
        return new String(original,0,j);
    }
}
