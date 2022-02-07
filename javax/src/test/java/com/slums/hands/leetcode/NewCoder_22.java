package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 21:47
 * @version: 1.0
 * NC22 合并两个有序的数组
 */
public class NewCoder_22 {
    public void merge(int A[], int m, int B[], int n) {
        int index = A.length - 1;
        m = m - 1;
        n = n - 1;
        while (index >= 0 && m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                A[index] = A[m];
                m--;
            } else {
                A[index] = B[n];
                n--;
            }
            index--;
        }
        while (n >= 0) {
            A[n] = B[n];
            n--;
        }
    }

    @Test
    public void test() {
        merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }
}
