package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 18:10
 * @version: 1.0
 * NC119 最小的K个数
 */
public class NewCoder_119 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i : input) {
            priorityQueue.add(i);
        }
        System.out.println(priorityQueue.size());
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while (!priorityQueue.isEmpty() && index < k) {
            index++;
            list.add(priorityQueue.remove());
        }
        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution_Insert(int[] input, int k) {
        for (int i = 1; i < input.length; i++) {
            int temp = input[i];
            int j = i;
            while (j > 0 && temp < input[j-1]) {
                input[j] = input[j - 1];
                j--;
            }
            if (j != i) {
                input[j] = temp;
            }

        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;

    }

    @Test
    public void test() {
        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
        System.out.println(GetLeastNumbers_Solution_Insert(input, 4));
    }
}
