package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 21:30
 * @version: 1.0
 */
public class NewCoder_19 {
    public int FindGreatestSumOfSubArray(int[] array) {
        // dp[i] = Math.max(dp[i-1]+array[i], array[i]);
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = Math.max(array[i - 1] + array[i], array[i]);
            max = Math.max(array[i],max);

        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = new int[]{-2, -8, -1, -5, -9};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
