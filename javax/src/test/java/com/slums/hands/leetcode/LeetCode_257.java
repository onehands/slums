package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/25 20:02
 * @version: 1.0
 */
public class LeetCode_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, result, "");
        return result;
    }

    public void binaryTreePaths(TreeNode root, List<String> result, String preStr) {
        if (preStr.length() == 0) {
            preStr = root.val + "";

        } else {
            preStr = preStr + "->" + root.val;
        }
        if(root.left==null&&root.right==null){
            result.add(preStr);
            return;
        }
        if(root.left!=null){
            binaryTreePaths(root.left, result, preStr);

        }
        if(root.right!=null){
            binaryTreePaths(root.right, result, preStr);
        }

    }

    @Test
    public void test() {
        Integer[] data = new Integer[]{1, 2, 3, null, 5};
        List<String> result = binaryTreePaths(TreeNodeUtil.arrayToTreeNode(data));
        System.out.println(result);
    }
}
