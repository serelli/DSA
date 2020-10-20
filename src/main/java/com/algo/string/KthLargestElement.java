package com.algo.string;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingInt;

public class KthLargestElement {

    public static void main(String[] args) throws IOException {

        List<String> paragraph = new ArrayList<>();
        File file = new File("/Users/sandeeperelli/IdeaProjects/interviewprep/src/main/resource/sample.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = br.readLine();
        while (str != null) {
            paragraph.addAll(Arrays.asList(str.split(" ")));
            str = br.readLine();
        }
        System.out.println(kthLargestElement(paragraph));
    }

    private static Map<Integer, Set<String>> kthLargestElement(List<String> paragraph) {

        /*Map<String, Long> collect =
                paragraph.stream().collect(Collectors.groupingBy(Function.identity(), counting()));*/

        Map<String, Integer> result =
                paragraph.stream().collect(Collectors.groupingBy(Function.identity(), summingInt(e -> 1)));

        Map<Integer, Set<String>> collect = result.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey,
                                Collectors.toSet())));
        
        return collect;

    }

}
