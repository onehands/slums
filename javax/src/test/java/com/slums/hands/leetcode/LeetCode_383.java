package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 17:24
 * @version: 1.0
 */
public class LeetCode_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                if (count > 0) {
                    map.put(c, count - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(canConstruct("aa", "ab"));
    }
}
