package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_72 {
    public void sortColors(int[] nums) {
        int[] a = new int[3];
        for (int i : nums) {
            a[i] = a[i] + 1;
        }
        int allIndex = 0;
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < a[i]; i1++) {
                nums[allIndex] = i;
                allIndex++;
            }
        }

    }

    @Test
    public void test() {
        sortColors(null);
    }


}
