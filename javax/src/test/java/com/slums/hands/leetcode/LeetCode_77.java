package com.slums.hands.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/11 14:35
 * @version: 1.0
 */
public class LeetCode_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(result, temp, n, k, 1);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int n, int k, int startIndex) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

//        for (int i = startIndex; i <= n; i++) {
        for (int i = startIndex; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            dfs(result, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
