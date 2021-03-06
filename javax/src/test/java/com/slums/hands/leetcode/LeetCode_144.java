package com.slums.hands.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fillList(list, root);
        return list;
    }

    private void fillList(List<Integer> list, TreeNode root) {
        if (root != null) {
            list.add(root.val);
            fillList(list, root.left);
            fillList(list, root.right);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return list;
    }


}
