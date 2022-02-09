package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/9 11:11
 * @version: 1.0
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        Arrays.sort(nums);
        reback(result, tempResult, 0, nums);
        return result;
    }

    private void reback(List<List<Integer>> result, List<Integer> tempResult, int index, int[] nums) {
        result.add(new ArrayList<>(tempResult));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i] - nums[i - 1]) {
                continue;
            }
            tempResult.add(nums[i]);
            reback(result, tempResult, i + 1, nums);
            tempResult.remove(tempResult.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{2, 2}));
    }
}
