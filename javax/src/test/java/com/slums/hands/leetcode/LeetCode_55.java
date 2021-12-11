package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 17:09
 * @version: 1.0
 */
public class LeetCode_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
