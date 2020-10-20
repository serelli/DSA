package com.algo.mathematical;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = recursion(n,map,new HashSet<Integer>());
        return result==1;
    }

    private int recursion(int n, Map<Integer,Integer> map, Set<Integer> set){

        if(n==1)
            return n;
        if(set.contains(n))
            return -1;
        int val=0;
        set.add(n);
        while(n>0){
            int temp = n%10;

            if(map.containsKey(temp)){
                val += map.get(temp);
            }else{
                val += temp*temp;
                map.put(temp,temp*temp);
            }
            n /= 10;
        }
        return recursion(val,map,set);

    }
    
    public static void main(String[] args ){
        HappyNumber num = new HappyNumber();
        System.out.println(num.isHappy(19));

    }
}
