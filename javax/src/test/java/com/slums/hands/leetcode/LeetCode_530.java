package com.slums.hands.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/25 20:45
 * @version: 1.0
 */
public class LeetCode_530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //中序遍历
        build(result, root);
        int min = Integer.MAX_VALUE;
        int pre = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, Math.abs(pre - result.get(i)));
        }
        return min;
    }

    private void build(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        build(result, root.left);
        result.add(root.val);
        build(result, root.right);
    }
}
