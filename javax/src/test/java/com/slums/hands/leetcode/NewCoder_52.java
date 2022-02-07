package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 21:56
 * @version: 1.0
 */
public class NewCoder_52 {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        //'(',')','{','}','['和']'
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char preValue = stack.pop();
                if (c == ')' && preValue != '(') {
                    return false;
                }
                if (c == '}' && preValue != '{') {
                    return false;
                }
                if (c == ']' && preValue != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        System.out.println(isValid("]"));
    }
}
