package com.algo.string;

public class ConvertBinaryStrToInt {

    public static void main(String[] args) {
        /*ConvertBinaryStrToInt convertBinaryStrToInt = new ConvertBinaryStrToInt();
        System.out.println(convertBinaryStrToInt.convertBinartToInt("1000001001001101100100000101011110110110011"));
        System.out.println(convertBinaryStrToInt.convertBinartToInt("110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
*/
        //System.out.println(convertBinaryStrToInt.convertIntToBinary(3));
        String s = addTwoBinary("11", "1");
        System.out.println(s);

    }

    private long convertBinartToInt(String str) {

        long num = 0;
        for (int i = 0; i < str.length(); i++) {

            num += (str.charAt(str.length() - 1 - i) - '0') * Math.pow(2, i);
        }
        return num;
    }

    private String convertIntToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static String addTwoBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int ai = a.length() - 1;
        int bj = b.length() - 1;
        int carry = 0;
        while (ai >= 0 && bj >= 0) {
            int anum = a.charAt(ai) - '0';
            int bnum = b.charAt(bj) - '0';
            int sum = anum + bnum + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            ai--;
            bj--;
        }
        while (ai >= 0 || bj >= 0) {
            if (ai >= 0) {
                int anum = a.charAt(ai) - '0';
                int sum = anum + carry;
                sb.append(sum % 2);
                carry = sum / 2;
                ai--;
            } else {
                int bnum = b.charAt(bj) - '0';
                int sum = bnum + carry;
                sb.append(sum % 2);
                carry = sum / 2;
                bj--;
            }
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
