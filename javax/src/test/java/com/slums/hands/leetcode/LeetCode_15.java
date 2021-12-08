package com.slums.hands.leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_15 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return result;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int curr = nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = curr + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(curr, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> result
                = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(new Gson().toJson(result));
    }

}
