package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 12:52
 * @version: 1.0
 * NC6 二叉树中的最大路径和
 */
public class NewCoder_6 {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // write code here
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        max = Math.max(max, left + right + root.val);
        return Math.max(root.val + left, root.val + right);
    }

    @Test
    public void test() {
        Integer[] data = new Integer[]{10, -2, -3};

        System.out.println(maxPathSum(TreeNodeUtil.arrayToTreeNode(data)));
    }
}
