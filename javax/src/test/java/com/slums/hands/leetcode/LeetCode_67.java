package com.slums.hands.leetcode;

import org.junit.Test;

public class LeetCode_67 {
    public String addBinary(String a, String b) {
//        return Integer.toBinaryString(
//                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
//        );
        if (a.length() > b.length()) {
            return addBinarySimple(a, b);
        } else {
            return addBinarySimple(b, a);
        }

    }

    private String addBinarySimple(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int plus = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int temp = plus;
            if (i >= 0) {
                temp = a.charAt(i--) - '0' + temp;
            }
            if (j >= 0) {
                temp = b.charAt(j--) - '0' + temp;
            }
            if (temp >= 2) {
                sb.append(temp % 2);
                plus = 1;
            } else {
                sb.append(temp);
                plus = 0;
            }
        }
        if (plus == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(addBinary("101", "1"));
    }
}
