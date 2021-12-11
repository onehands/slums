package com.slums.hands.leetcode;

import com.slums.hands.service.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_114 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        fillList(list, root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            prev.left = null;
            prev.right = list.get(i);
        }
    }

    private void fillList(List<TreeNode> list, TreeNode root) {
        if (root != null) {
            list.add(root);
            fillList(list, root.left);
            fillList(list, root.right);
        }

    }


}
