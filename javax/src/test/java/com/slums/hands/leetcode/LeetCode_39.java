package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/6 10:36
 * @version: 1.0
 */
//给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//
//candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//
//对于给定的输入，保证和为target 的不同组合数少于 150 个。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combination-sum
public class LeetCode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, int startIndex, ArrayList<Integer> tmp_list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = startIndex; start < candidates.length; start++) {
            tmp_list.add(candidates[start]);
            dfs(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> data = combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(data);
    }
}
