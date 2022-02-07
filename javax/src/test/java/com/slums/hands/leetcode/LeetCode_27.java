package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 14:06
 * @version: 1.0
 */
public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }
}
