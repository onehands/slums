package com.slums.hands.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Integer> result = new ArrayList<>();
        fillList(result, root);
        int temp = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            if (temp >= result.get(i)) {
                return false;
            }
            temp = result.get(i);
        }
        return true;
    }

    private void fillList(List<Integer> result, TreeNode root) {
        if (root != null) {
            fillList(result, root.left);
            result.add(root.val);
            fillList(result, root.right);
        }
    }


}
