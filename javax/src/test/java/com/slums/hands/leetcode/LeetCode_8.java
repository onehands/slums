package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_8 {
    /**
     * char优化string
     * char比较
     *
     * @param s
     */
    public int myAtoi(String s) {
        s = s.trim();
        String[] stringArr = s.split("");
        int result = 0;
        int flag = 0;
        int i = 0;

        if ("-".equals(stringArr[0])) {
            flag = -1;
            i = 1;
        } else if ("+".equals(stringArr[0])) {
            flag = 1;
            i = 1;
        } else {
            flag = 1;
        }
        for (; i < stringArr.length; i++) {
            int value = 0;
            try {
                value = Integer.parseInt(stringArr[i]);
            } catch (NumberFormatException e) {
                return flag * result;
            }
            if (result > (Integer.MAX_VALUE - value) / 10) {
                return flag < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + value;
        }
        return flag * result;
    }

    @Test
    public void test() {
        System.out.println(myAtoi("42"));
    }


}
