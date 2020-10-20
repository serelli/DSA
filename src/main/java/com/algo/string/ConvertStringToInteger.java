package com.algo.string;

public class ConvertStringToInteger {
    public int myAtoi(String str) {

        char[] arr = str.toCharArray();
        boolean isNegative = false;
        int num = 0;
        int startIndex = 0;
        while(startIndex<=arr.length-1 && arr[startIndex]==' ') startIndex++;
        while(startIndex<=arr.length-1){
            if(arr[startIndex]=='-')
                isNegative = true;
            else if(arr[startIndex]<'9' && arr[startIndex]>'0'){
                num = num*10+(int)arr[startIndex++];
            }else {
                return 0;
            }
        }
        return isNegative? -1 * num: num;
    }
    public static void main(String[] args){
        ConvertStringToInteger convertStringToInteger = new ConvertStringToInteger();
        System.out.println(convertStringToInteger.myAtoi("42"));

    }
}
