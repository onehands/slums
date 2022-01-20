package com.slums.hands.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LambdaTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> System.out.println("test"));
        executor.submit(() -> System.out.printf("test%s", "123"));

    }
}
