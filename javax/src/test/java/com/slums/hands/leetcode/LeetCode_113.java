package com.slums.hands.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/5 17:06
 * @version: 1.0
 */
public class LeetCode_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> totalResult = new ArrayList<>();
        List<Integer> singleResult = new ArrayList<>();
        pathSum(root, targetSum, singleResult, totalResult);
        return new ArrayList<>(totalResult);
    }


    public void pathSum(TreeNode root, int targetSum, List<Integer> singleResult, List<List<Integer>> totalResult) {
        if (root == null) {
            return;
        }
        singleResult.add(root.val);
        if (root.left == null && root.right == null) {
            //叶子结点
            if (targetSum == root.val) {
                //匹配
                ArrayList<Integer> toAdd = new ArrayList<>(singleResult);
                totalResult.add(toAdd);
            }
        } else {
            if (root.left != null) {
                pathSum(root.left, targetSum - root.val, singleResult, totalResult);
                singleResult.remove(singleResult.size() - 1);
            }
            if (root.right != null) {
                pathSum(root.right, targetSum - root.val, singleResult, totalResult);
                singleResult.remove(singleResult.size() - 1);
            }
        }

    }
}
