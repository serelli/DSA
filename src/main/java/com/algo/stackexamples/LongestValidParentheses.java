package com.algo.stackexamples;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("((((())))))("));
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j = j + 2) {
                if (isValid(s.substring(i, j))) max = Math.max(max, j - i);
            }
        }
        return max;
    }

    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
