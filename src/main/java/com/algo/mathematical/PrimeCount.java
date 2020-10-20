package com.algo.mathematical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeCount {


    public static void main(String[] args) {

        PrimeCount primeCount = new PrimeCount();
        System.out.println(primeCount.findPrime(100));
    }


    private List<Integer> findPrime(int num) {

        boolean[] isPrime = new boolean[num];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < num; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < num; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < num; i++) {
            if (isPrime[i]) result.add(i);
        }
        return result;
    }

}
