package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/5 15:42
 * @version: 1.0
 */
public class LeetCode_965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean result = true;
        if (root.left != null) {
            result = result && root.left.val == root.val && isUnivalTree(root.left);
        }
        if (root.right != null) {
            result = result && root.right.val == root.val && isUnivalTree(root.right);
        }
        return result;

    }
}
