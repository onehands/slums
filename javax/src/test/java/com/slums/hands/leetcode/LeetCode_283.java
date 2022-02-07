package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_283 {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int not_zero_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != not_zero_index) {
                    nums[not_zero_index] = nums[i];
                    nums[i] = 0;
                }
                not_zero_index++;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        for (int i = 0, j = 0; i < nums.length && j <= i; i++) {
            if (nums[i] != 0) {
                if (nums[j] == 0) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    @Test
    public void test() {
//        int[] arr = new int[]{0, 1, 0, 3, 12};
//        moveZeroes2(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        int[] arr = new int[]{1, 0, 1};
        moveZeroes3(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }


}
