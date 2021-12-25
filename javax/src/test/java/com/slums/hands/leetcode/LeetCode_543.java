package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        diameterOfBinaryTree1(root);
        return max;
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree1(root.left);
        int right = diameterOfBinaryTree1(root.right);
        if (left + right > max) {
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }

    @Test
    public void test() {
    }


}
