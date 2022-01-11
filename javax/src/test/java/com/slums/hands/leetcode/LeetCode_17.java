package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/11 15:05
 * @version: 1.0
 */
public class LeetCode_17 {
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder path = new StringBuilder();
        dfs(result, path, digits, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder path, String digits, int startIdnex) {
        if (startIdnex == digits.length()) {
            result.add(path.toString());
            return;
        }
        String str = numString[digits.charAt(startIdnex) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            dfs(result, path, digits, startIdnex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
//    private void dfs(List<String> result, StringBuilder path, String digits, int startIdnex) {
//        if (path.length() == digits.length() && path.length() > 0) {
//            result.add(path.toString());
//            return;
//        }
//        String str = numString[digits.charAt(startIdnex) - '0'];
//        for (int i = 0; i < str.length(); i++) {
//            path.append(str.charAt(i));
//            dfs(result, path, digits, startIdnex + 1);
//            path.deleteCharAt(path.length() - 1);
//        }
//    }

    @Test
    public void test() {
        System.out.println(letterCombinations(""));
    }
}



