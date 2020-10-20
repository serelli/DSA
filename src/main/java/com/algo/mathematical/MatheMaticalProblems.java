package com.algo.mathematical;

public class MatheMaticalProblems {



    public static void main(String[] args){

       // System.out.println(fibonacciRec(9));
       // System.out.println(fibonacciDynamicProg(9));
        //System.out.println(isPrime(0));
        System.out.println(factorial(4));

    }

    //find nth element in a fibonacci series using recursive.
    // Time Complexity O(n) = O(n-1)+O(n-2) Space Complexity O(n)
    public static int fibonacciRec(int n){

        if(n<=1){
            return n;
        }

        return fibonacciRec(n-1)+ fibonacciRec(n-2);
    }

    //find nth element in a fibonacci series using iterative
    // Time Complexity O(n) Space Complexity O(1)
    public static int fibonacciIterative(int n){

        int a=0,b=1;
        for( int i=2;i<=n; i++){
            int temp = a+b;
            a=b;
            b= temp;
        }
        return b;

    }

    public static int fibonacciDynamicProg(int n){

        int[] cache = new int[n+2];

        cache[0]=0;
        cache[1] =1;

        for(int i=2; i<=n;i++){
            cache[i] = cache[i-1]+cache[i-2];
        }
        return cache[n];


    }

    public static boolean isPrime(int num){

        if(num%2 ==0 || num<=1)
            return false;
       int end = (int)Math.sqrt(num);
        for(int i=3; i<= end; i+=2){
            if(num%i==0)
                return false;
        }
        return true;
    }

    public static boolean isIntegerPalindrome(int num){
        int original = num;
        int sum =0;

        while(num>0){
            int temp = num% 10;
            sum= sum*10+temp;
            num = num/10;
        }
        System.out.println(sum);
        return sum==original? true: false;
    }

    public static int factorial(int num){
        int fact =1;

        while(num>0){
            fact*= num;
            num = num-1;
        }
        return fact;
    }

}
