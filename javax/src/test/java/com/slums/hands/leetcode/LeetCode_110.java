package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/25 19:43
 * @version: 1.0
 */
public class LeetCode_110 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth == -1) {
            return -1;
        }
        if (rightDepth == -1) {
            return -1;
        }
        return Math.abs(rightDepth - leftDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }
}
