package com.slums.hands.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/11 14:54
 * @version: 1.0
 */
//找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
//说明：
//所有数字都是正整数。
//解集不能包含重复的组合。
//https://leetcode-cn.com/problems/combination-sum-iii/
public class LeetCode_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, k, n, 1, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int k, int n, int starkIndex, int sum) {
        if (sum == n && path.size() == k) {
            result.add(new ArrayList<>(path));
        }

        for (int i = starkIndex; i <= 9 && sum + i <= 9; i++) {
            path.add(i);
            sum = sum + i;
            dfs(result, path, k, n, starkIndex + 1, sum);
            sum = sum - i;
            path.remove(path.size() - 1);
        }
    }
}
