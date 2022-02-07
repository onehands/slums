package com.slums.hands.leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 15:56
 * @version: 1.0
 */
public class NewCoder_45 {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        List<Integer> preResult = new ArrayList<>();
        preOrder(root, preResult);
        List<Integer> midResult = new ArrayList<>();
        midOrder(root, midResult);
        List<Integer> postResult = new ArrayList<>();
        postOrder(root, postResult);
        int[][] result = new int[3][preResult.size()];
        int[] pre = new int[preResult.size()];
        int[] mid = new int[preResult.size()];
        int[] post = new int[preResult.size()];

        for (int i = 0; i < preResult.size(); i++) {
            pre[i] = preResult.get(i);
            mid[i] = midResult.get(i);
            post[i] = postResult.get(i);
        }
        result[0] = pre;
        result[1] = mid;
        result[2] = post;
        return result;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    public void midOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }

    public void postOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }
    }

    @Test
    public void test() {
        Integer[] data = new Integer[]{14, 8, 5, 2, 13, 17, 19, 38, 4, 24, 25, 39, null, 22, 29, 30, null, 10, 34, null, 9, null, 16, 23, null, 15, null, 27, 3, null, 26, 11, null, 18, 35, 31, 33, 28, null, null, null, null, null, null, null, 20, null, null, null, null, null, null, null, 12, 40, 41, null, null, 1, null, null, null, null, 7, null, null, 37, null, 21, null, null, null, 32, null, null, null, 6, 36};

        System.out.println(new Gson().toJson(threeOrders(TreeNodeUtil.arrayToTreeNode(data))));
    }
}
