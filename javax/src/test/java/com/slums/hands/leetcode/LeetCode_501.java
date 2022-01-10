package com.slums.hands.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/5 16:52
 * @version: 1.0
 */
public class LeetCode_501 {
    List<Integer> result = new ArrayList<>();
    int currentCount = 0;
    int currentValue = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        fillResult(root);

        int[] toReturn = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            toReturn[i] = result.get(i);
        }
        return toReturn;

    }

    private void fillResult(TreeNode root) {
        //中序遍历
        if (root == null) {
            return;
        }
        fillResult(root.left);
        if (root.val == currentValue) {
            currentCount++;
        } else {
            currentCount = 1;
            currentValue = root.val;
        }
        if (currentCount == maxCount) {
            result.add(root.val);
        } else if (currentCount > maxCount) {
            maxCount = currentCount;
            result.clear();
            result.add(root.val);
        }
        fillResult(root.right);
    }
}
