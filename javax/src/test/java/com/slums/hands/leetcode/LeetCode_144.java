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


}
