package com.algo.string;

import java.util.HashSet;
import java.util.Set;
import java.util.SplittableRandom;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int len = s.length()-1;
        int count =0;
        if(len<1)
            return count;
        

        while(len>=0 && s.charAt(len)==' ')
            len--;

        while(len>=0 && s.charAt(len)!=' ' ){
            count++;
            len--;
        }
        return count;
    }

    public static void main(String[] args){
        int i = solution(2,"1A 2F 1C");
        System.out.println(i);
    }

    public static int solution(int N, String S) {
        // write your code in Java SE 8
        String[] reservedSeatsArr = S.split(" ");
        Set<String> reservedSeatSet = new HashSet<>();
        for(String reservedSeat : reservedSeatsArr){
            reservedSeatSet.add(reservedSeat);
        }
        int available_3_familySeats = 0;

        for(int i=1; i<=N;i++){

           boolean t =  !reservedSeatSet.contains(i+'A');
            if(!reservedSeatSet.contains(i+'A') && !reservedSeatSet.contains(i+'B') &&
                    !reservedSeatSet.contains(i+'C')) available_3_familySeats++;

            if(!reservedSeatSet.contains(i+'H') && !reservedSeatSet.contains(i+'J') &&
                    !reservedSeatSet.contains(i+'K')) available_3_familySeats++;

            if((!reservedSeatSet.contains(i+'D') || !reservedSeatSet.contains(i+'G')) &&
                    (!reservedSeatSet.contains(i+'E') && !reservedSeatSet.contains(i+'F') )) available_3_familySeats++;
        }
        return available_3_familySeats;
    }
}
