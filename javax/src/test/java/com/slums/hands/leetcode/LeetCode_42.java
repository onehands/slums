package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/10 15:37
 * @version: 1.0
 */
public class LeetCode_42 {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            int rHeight = height[i];
            int lHeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                rHeight = Math.max(rHeight, height[j]);
            }
            for (int j = i - 1; j >= 0; j--) {
                lHeight = Math.max(lHeight, height[j]);
            }

            int h = Math.min(rHeight, lHeight) - height[i];
            sum += h;
        }
        return sum;
    }
}
