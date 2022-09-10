package com.algo.MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class HorribleSortAlgoUsingExecutorService {


    public static void main(String[] args){

        List<Integer> nums = Arrays.asList(4, 9, 1, 4, 8, 6, 0, 2, 9, 4, 2, 23, 3, 14, 64, 34);
        System.out.println(nums);
        final List<Integer> result = new ArrayList<>();
        sleepSort12(nums, result);
        System.out.println(result);
    }

    private static void sleepSort12(List<Integer> nums, List<Integer> result) {

        List<Callable<Boolean>> callables = nums.stream().map(num -> new Callable<Boolean>(){public Boolean call(){
            try {
                Thread.sleep(num*100);
                System.out.println(num);
                result.add(num);
            }catch (InterruptedException ex)      {
                System.out.println(ex);
            }
        return true; }}).collect(Collectors.toList());

        ExecutorService executorService = Executors.newFixedThreadPool(nums.size());
        try {
            executorService.invokeAll(callables);
        }catch (InterruptedException ex)  {

        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(30000,TimeUnit.MILLISECONDS);
        }catch (InterruptedException ex)  {

        }


    }
}
