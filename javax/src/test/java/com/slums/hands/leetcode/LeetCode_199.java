package com.slums.hands.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_199 {
    public List<Integer> rightSideView(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            while (!stack.isEmpty()) {
                temp.add(stack.pop());
            }
            result.add(temp.get(temp.size() - 1).val);
            for (int i = temp.size() - 1; i >= 0; i--) {
                TreeNode treeNode = temp.get(i);
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
            }
        }

        return result;
    }
}
