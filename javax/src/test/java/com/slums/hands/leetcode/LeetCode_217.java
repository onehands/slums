package com.slums.hands.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/7 12:23
 * @version: 1.0
 */
public class LeetCode_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
