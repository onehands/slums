package com.slums.hands.service;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeUtil {
    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{5, 4, 6, null, null, 3, 7};
        TreeNode node = arrayToTreeNode(data);
        System.out.println(node);
    }
}
