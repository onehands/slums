package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_62 {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j];
            }
        }
        return result[m - 1][n - 1];

    }

    @Test
    public void test() {
    }


}
