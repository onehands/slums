package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/6 16:42
 * @version: 1.0
 */
public class LeetCode_278 {
    static boolean isBadVersion(int version) {
        return 1 > 0;
    }

    public static int firstBadVersion(int n) {
        if (isBadVersion(0)) {
            return 0;
        }
        int begin = 1;
        int end = n;
        int index = (end - begin) / 2;

        while (index > begin && index < end) {
            boolean bad = isBadVersion(index);
            if (bad && !isBadVersion(index - 1)) {
                return index;
            }
            if (bad) {
                end = index - 1;
            } else {
                begin = index + 1;
            }
            index = (end - begin) / 2 + index;
        }
        return n == begin ? begin : end;
    }

    @Test
    public void test() {
    }

}
