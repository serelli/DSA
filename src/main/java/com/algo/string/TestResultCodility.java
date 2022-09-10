package com.algo.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestResultCodility {

    public int solution(String[] T, String[] R) {

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < T.length; i++) {
            char ch = T[i].charAt(T[i].length()-1);
            String str  =  ch>='a' && ch<='z'? T[i].substring(0, T[i].length() - 1): T[i];

            if (!map.containsKey(str) || map.get(str)) {
                    boolean flag = R[i].equals("OK");
                    map.put(str, flag);
            }
        }
        int test_groups_passed = Collections.frequency(map.values(), true);

        return (test_groups_passed * 100) / map.size();

    }


    public static void main(String[] args) {
        TestResultCodility testResultCodility = new TestResultCodility();
        System.out.println(testResultCodility.solution(new String[]{"test1a", "test2", "test1b", "test1c", "test3"}, new String[]{"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"}));


    }
}
