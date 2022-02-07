package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 12:52
 * @version: 1.0
 * NC8 二叉树中和为某一值的路径(二)
 */
public class NewCoder_8 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> tempResult = new ArrayList<>();
        dfs(result, tempResult, root, expectNumber, 0);
        return result;

    }

    private void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempResult, TreeNode root, int expectNumber, int upperSum) {
        if (root == null) {
            return;
        }
        tempResult.add(root.val);
        if (root.left == null && root.right == null && upperSum + root.val == expectNumber) {
            result.add(new ArrayList<>(tempResult));
            tempResult.remove(tempResult.size() - 1);
            return;
        }
        if (root.left != null) {
            dfs(result, tempResult, root.left, expectNumber, upperSum + root.val);
        }
        if (root.right != null) {
            dfs(result, tempResult, root.right, expectNumber, upperSum + root.val);
        }
        tempResult.remove(tempResult.size() - 1);
    }

    @Test
    public void test() {
        Integer[] data = new Integer[]{10, 5, 12, 4, 7};
        System.out.println(FindPath(TreeNodeUtil.arrayToTreeNode(data), 22));
    }
}
