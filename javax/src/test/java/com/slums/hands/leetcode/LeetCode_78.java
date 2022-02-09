package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/9 10:52
 * @version: 1.0
 */
public class LeetCode_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        int startIndex = 0;
        reback(result, tempResult, nums, startIndex);
        return result;
    }

    private void reback(List<List<Integer>> result, List<Integer> tempResult, int[] nums, int startIndex) {
        result.add(new ArrayList<>(tempResult));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            tempResult.add(nums[i]);
            reback(result, tempResult, nums, i + 1);
            tempResult.remove(tempResult.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
