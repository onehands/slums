package com.slums.hands.leetcode;

public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }
}
