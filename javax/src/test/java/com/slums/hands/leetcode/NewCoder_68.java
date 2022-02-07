package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 20:25
 * @version: 1.0
 * NC68 跳台阶
 */
public class NewCoder_68 {
    public int jumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int[] dp = new int[target];

        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];

    }
}
