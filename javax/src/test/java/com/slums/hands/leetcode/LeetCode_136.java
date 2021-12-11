package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_136 {
    public int singleNumber(int[] nums) {
        return java.util.Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }


}
