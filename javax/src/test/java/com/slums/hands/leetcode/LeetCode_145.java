package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_145 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fillList(list, root);
        return list;
    }

    private void fillList(List<Integer> list, TreeNode root) {
        if (root != null) {
            fillList(list, root.left);
            fillList(list, root.right);
            list.add(root.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    @Test
    public void test() {
        Integer[] data = new Integer[]{1,null,2,3};
        postorderTraversal(TreeNodeUtil.arrayToTreeNode(data));

    }

}
