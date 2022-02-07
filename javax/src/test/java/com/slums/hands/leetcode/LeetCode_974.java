package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 10:50
 * @version: 1.0
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class LeetCode_974 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            //被K整除
            int mod = (sum % k + k) % k;
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(subarraysDivByK(new int[]{5, 6}, 5));
    }
}
