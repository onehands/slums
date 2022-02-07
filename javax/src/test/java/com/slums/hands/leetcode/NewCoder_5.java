package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 12:52
 * @version: 1.0
 * NC5 二叉树根节点到叶子节点的所有路径和
 */
public class NewCoder_5 {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        dfs(result, temp, root);
        int resultInt = 0;
        for (List<Integer> integers : result) {
            for (int i = integers.size() - 1; i >= 0; i--) {
                resultInt += Math.pow(10, integers.size() - 1 - i) * integers.get(i);
            }
        }
        return resultInt;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (root.left != null) {
            temp.add(root.left.val);
            dfs(result, temp, root.left);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            dfs(result, temp, root.right);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test() {
        Integer[] data = new Integer[]{1, 2, 0, 3, 4};

        System.out.println(sumNumbers(TreeNodeUtil.arrayToTreeNode(data)));
    }
}
