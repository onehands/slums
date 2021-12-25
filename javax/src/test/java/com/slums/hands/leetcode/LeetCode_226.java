package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int not_zero_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != not_zero_index) {
                    nums[not_zero_index] = nums[i];
                    nums[i] = 0;
                }
                not_zero_index++;
            }
        }
    }

    @Test
    public void test() {
//        int[] arr = new int[]{0, 1, 0, 3, 12};
//        moveZeroes2(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        int[] arr = new int[]{1, 0};
        moveZeroes2(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }


}
