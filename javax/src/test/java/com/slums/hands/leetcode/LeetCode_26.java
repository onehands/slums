package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode_26 {
    public int removeElement(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int num = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                nums[num] = nums[i];
                pre = nums[i];
                num++;
            }
        }
        return num;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeElement(nums));
        Arrays.stream(nums).forEach(System.out::println);
    }
}
