package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 14:48
 * @version: 1.0
 */
public class LeetCode_844 {
    public boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1, tIndex = t.length() - 1;
        int sSkip = 0, tSkip = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0) {
                if (s.charAt(sIndex) == '#') {
                    sSkip += 1;
                    sIndex--;
                } else if (sSkip > 0) {
                    sIndex -= 1;
                    sSkip -= 1;
                } else {
                    break;
                }
            }

            while (tIndex >= 0) {
                if (t.charAt(tIndex) == '#') {
                    tSkip += 1;
                    tIndex--;
                } else if (tSkip > 0) {
                    tSkip -= 1;
                    tIndex -= 1;
                } else {
                    break;
                }
            }
            if (tIndex >= 0 && sIndex >= 0) {
                if (t.charAt(tIndex) != s.charAt(sIndex)) {
                    return false;
                }
            } else {
                if (tIndex >= 0 || sIndex >= 0) {
                    return false;
                }
            }
            tIndex--;
            sIndex--;
        }

        return tIndex <= 0 && sIndex <= 0;
    }

    @Test
    public void test() {
        System.out.println(backspaceCompare("nzp#o#g",
                "b#nzp#o#g"));
    }
}
