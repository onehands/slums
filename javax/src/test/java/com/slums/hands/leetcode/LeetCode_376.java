package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 17:51
 * @version: 1.0
 */
public class LeetCode_376 {
    public int wiggleMaxLength(int[] nums) {
        int curDiff = 0;
        int preDiff = 0;
        int index = 1;
        int count = 0;
        while (index < nums.length) {
            curDiff = nums[index] - nums[index - 1];
            if ((curDiff < 0 && preDiff > 0) || (curDiff > 0 && preDiff < 0)) {
                preDiff = curDiff;
                count++;
            }
            index++;
        }
        return count;
    }
}
