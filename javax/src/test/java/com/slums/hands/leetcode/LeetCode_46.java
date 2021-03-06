package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] flag = new int[nums.length];
        reback(nums, result, new ArrayList<>(), flag);
        return result;
    }

    private void reback(int[] nums, List<List<Integer>> result, ArrayList<Integer> temp, int[] flag) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                //回溯
                temp.add(nums[i]);
                reback(nums, result, temp, flag);
                //删除最后一个
                temp.remove(temp.size() - 1);
                flag[i] = 0;
            }
        }
    }

    // 回溯算法 方法一
    // 1、flag为数组数字是否被使用的标记
    // 可以优化：可以减少一半的工作量 [1,2,3]和[3,2,1]对称，重复计算


    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }
}
