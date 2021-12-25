package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/25 21:35
 * @version: 1.0
 */
public class LeetCode_701 {
    TreeNode parent = null;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode parent = new TreeNode(0);
        if (root == null) {
            return new TreeNode(val);
        }
        doInsert(root, val);
        return root;
    }

    private void doInsert(TreeNode cur, int val) {
        if (cur == null) {
            TreeNode node = new TreeNode(val);
            if (val > parent.val) {
                parent.right = node;
            } else {
                parent.left = node;
            }
            return;
        }
        parent = cur;
        if (cur.val > val) {
            doInsert(cur.left, val);
        }
        if (cur.val < val) {
            doInsert(cur.right, val);
        }

    }
}
