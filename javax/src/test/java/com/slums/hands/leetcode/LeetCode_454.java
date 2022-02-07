package com.slums.hands.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 16:36
 * @version: 1.0
 */
public class LeetCode_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int result = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int rest = -i - j;
                if (map.containsKey(rest)) {
                    result += map.get(rest);
                }
            }
        }
        return result;
    }
}
