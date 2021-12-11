package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_2114 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                int temp = nums[i];
                nums[temp] = temp;
                nums[i] = nums[temp];
            }
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        byte[] result = new byte[nums.length];
        for (int num : nums) {
            if (result[num] == 1) {
                return num;
            }
            result[num] = 1;

        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(findRepeatNumber(new int[]{1, 0, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }
}
