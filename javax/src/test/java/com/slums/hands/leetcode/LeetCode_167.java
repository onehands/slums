package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/7 10:28
 * @version: 1.0
 */
public class LeetCode_167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            int rest = target - current;

            if (cache.containsKey(rest)) {
                return new int[]{cache.get(rest) + 1, i + 1};
            } else {
                cache.put(current, i);
            }
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] data = twoSum(new int[]{2, 7, 11, 15}, 9);
        if (data != null) {
            for (int datum : data) {
                System.out.println(datum);
            }
        }
    }
}
