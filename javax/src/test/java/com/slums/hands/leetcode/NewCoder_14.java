package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 22:24
 * @version: 1.0
 */
public class NewCoder_14 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();

        if (pRoot == null) {
            return finalResult;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int sequence = 1;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> tempResult = new ArrayList<>();
            int size = queue.size();
            List<TreeNode> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                tempList.add(cur);
            }
            for (int i = 0; i < tempList.size(); i++) {
                TreeNode cur = tempList.get(i);
                tempResult.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }

            }


            if (sequence % 2 != 0) {

                finalResult.add(tempResult);
            } else {
                Collections.reverse(tempResult);
                finalResult.add(tempResult);
            }
            sequence = sequence + 1;
        }
        return finalResult;
    }

    @Test
    public void test() {
        System.out.println(Print(TreeNodeUtil.arrayToTreeNode(new Integer[]{8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15})));
    }
}
