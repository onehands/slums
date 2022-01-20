package com.slums.hands.leetcode;

import org.junit.Test;

public class LeetCode_66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] p = new int[digits.length + 1];
        p[0] = 1;
        return p;
    }

    @Test
    public void test() {
        int[] result = plusOne(new int[]{9, 9});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
