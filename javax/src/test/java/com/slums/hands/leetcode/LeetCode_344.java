package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/9 11:15
 * @version: 1.0
 */
public class LeetCode_344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
