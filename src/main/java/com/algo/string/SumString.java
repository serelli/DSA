package com.algo.string;

public class SumString {
    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int n1 = num1.length();
        int n2 = num2.length();
        int carry = 0;
        while (n1 > 0 && n2 > 0) {
            int ni1 =  num1.charAt(n1 - 1) -'0';
            int ni2 =  num2.charAt(n2 - 1)-'0';
            int sum = ni1 + ni2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            n1--;
            n2--;
        }
        if (n1 == 0) {
            while (n2 > 0) {
                int ni2 = num2.charAt(n2 - 1) -'0';
                int sum = ni2 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                n2--;
            }
        } else {
            while (n1 > 0) {
                int ni1 = num1.charAt(n1 - 1) -'0';
                int sum = ni1 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                n1--;
            }
        }
        if(carry!=0)sb.append(carry);
        return sb.reverse().toString();


    }
    public static void main(String[] args){
        SumString sumString = new SumString();
        String s = sumString.addStrings("1", "9");
        System.out.println(s);


    }
}