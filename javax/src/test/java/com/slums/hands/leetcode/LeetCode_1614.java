package com.slums.hands.leetcode;

import java.util.Stack;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/24 17:15
 * @version: 1.0
 */
public class LeetCode_1614 {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char char_v = s.charAt(i);
            if (char_v == '(') {
                stack.push(char_v);
                max = Math.max(max, stack.size());
            }
            if (char_v == ')') {
                stack.pop();
            }
        }
        return max;

    }
}
