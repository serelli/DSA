package com.algo.MultiThreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class HorribleSortAlgo {


    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4, 9, 1, 4, 8, 6, 0, 2, 9, 4, 2, 23, 3, 14, 64, 34);
        System.out.println(nums);

        sleepSort(nums);
    }

    private static void sleepSort(List<Integer> nums) {
        final CountDownLatch doneThreadLatch = new CountDownLatch(nums.size());
        final CountDownLatch readyThreadLatch = new CountDownLatch(1);
        nums.stream().map(num -> new Thread(new WorkerThread(readyThreadLatch, doneThreadLatch, num))).forEach(x -> x.start());
        readyThreadLatch.countDown();
        try {
            doneThreadLatch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}


class WorkerThread implements Runnable {

    CountDownLatch readThreadLatch;
    CountDownLatch doneThreadLatch;
    int num;

    public WorkerThread(CountDownLatch readyThreadLatch, CountDownLatch doneThreadLatch, int num) {
        this.doneThreadLatch = doneThreadLatch;
        this.readThreadLatch = readyThreadLatch;
        this.num = num;
    }

    @Override
    public void run() {

        try {
            readThreadLatch.await();
            Thread.sleep(num * 100);
            System.out.println(num);
            doneThreadLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
