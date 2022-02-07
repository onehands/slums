package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/6 19:34
 * @version: 1.0
 */
public class LeetCode_405 {
    public String toHex2(int num) {
        String baseStr = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -1 * num;
        }
        while (num >= 16) {
            sb.append(baseStr.charAt(num % 16));
            num = num / 16;
        }
        sb.append(baseStr.charAt(num));
        if (flag) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public String toHex(int num_) {
        long num = num_;
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            num = (1L << 32) + num;
//            num = (long) (Math.pow(2, 32) + num);
        }

        while (num >= 16) {
            long u = num % 16;
            char c = (char) (u + '0');
            if (u >= 10) {
                c = (char) (u - 10 + 'a');
            }
            sb.append(c);
            num = num / 16;
        }
        char c = (char) (num + '0');
        if (num >= 10) {
            c = (char) (num - 10 + 'a');
        }
        sb.append(c);
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(toHex(16));
//        System.out.println(toHex(17));
        System.out.println(toHex(-1));
        ;
    }
}
