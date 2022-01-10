package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/30 11:07
 * @version: 1.0
 */
public class LeetCode_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] flag = new int[nums.length];
        Arrays.sort(nums);
        reback(nums, result, new ArrayList<>(), flag);
        return result;
    }

    // 回溯算法
    // 1、flag为数组数字是否被使用的标记
    public static void reback(int[] nums, List<List<Integer>> result, List<Integer> temp, int[] flag) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        int lastUsed = Integer.MIN_VALUE;
        for (int i = 0, length = nums.length; i < length; i++) {
            if (flag[i] == 0 && nums[i] != lastUsed) {// 去重：如果当前数与上次递归的数字相同，continue
                flag[i] = 1;
                temp.add(nums[i]);
                reback(nums, result, temp, flag);
                lastUsed = nums[i];
                temp.remove(temp.size() - 1);
                flag[i] = 0;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{2, 1, 2, 4}));
    }
}
