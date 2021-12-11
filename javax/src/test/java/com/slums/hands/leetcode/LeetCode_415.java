package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 17:58
 * @version: 1.0
 */
public class LeetCode_415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
            }
            int m1 = 0;
            if (j >= 0) {
                m1 = num2.charAt(j) - '0';
            }
            int sum = n1 + m1 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
