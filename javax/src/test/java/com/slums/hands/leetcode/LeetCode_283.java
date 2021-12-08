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
        for (int i = 0, j = 1; i < nums.length && j < nums.length; ) {
            //[0,1,0,3,12]
            if (nums[i] != 0) {
                i++;
            }
            if (nums[j] != 0 && nums[i] == 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
            j++;
        }
    }

    @Test
    public void test() {
        int[] data = new int[]{2, 1};
        moveZeroes(data);
        for (int i : data) {
            System.out.println(i);
        }
    }


}
