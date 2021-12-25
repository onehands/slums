package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/25 19:43
 * @version: 1.0
 */
public class LeetCode_111 {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null && root.right != null) {
            return leftDepth + 1;
        }
        if (root.left != null && root.right == null) {
            return rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;

    }
}
