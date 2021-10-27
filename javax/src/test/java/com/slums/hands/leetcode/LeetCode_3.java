package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> charIndex = new HashMap<>();

        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char charV = s.charAt(i);
            if (charIndex.containsKey(charV)) {
                j = Math.max(charIndex.get(charV) + 1, j);
            }
            charIndex.put(charV, i);
            result = Math.max(result, (i - j + 1));

        }
        return result;


    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abba"));
    }


}
