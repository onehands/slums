package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/7 10:19
 * @version: 1.0
 */
public class LeetCode_977 {
    public int[] sortedSquares(int[] nums) {
//[-4,-1,0,3,10]
        int[] result = new int[nums.length];
        int left = 0;
        int right = result.length - 1;
        int index = result.length - 1;
        while (right >= left) {
            int rightValue = nums[right] * nums[right];
            int leftValue = nums[left] * nums[left];
            if (rightValue >= leftValue) {
                result[index] = rightValue;

                right--;
            } else {
                result[index] = leftValue;
                left++;
            }
            index--;
        }
        return result;
    }

    @Test
    public void test() {
        for (int i : sortedSquares(new int[]{-7,-3,2,3,11})) {
            System.out.println(i);
        }
    }
}
