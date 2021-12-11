package com.slums.hands.leetcode;

import com.slums.hands.service.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(result, root);
        return result;
    }

    public void inorderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(result, root.left);
        result.add(root.val);
        inorderTraversal(result, root.right);
    }

    @Test
    public void test() {
    }
}
