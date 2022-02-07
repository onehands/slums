package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/6 20:47
 * @version: 1.0
 * 560. 和为 K 的子数组
 */
public class LeetCode_560 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int a = 0; a < nums.length; a++) {
            int sum = nums[a];
            if (sum == k) {
                result++;
            }
            for (int b = a + 1; b < nums.length; b++) {
                sum = sum + nums[b];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int key = sum - k;
            if (map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(key, map.getOrDefault(k, 0) + 1);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }
}
