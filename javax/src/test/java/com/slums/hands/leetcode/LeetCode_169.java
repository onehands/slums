package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int num : nums) {
            if (num == result) {
                count++;
            } else {

                count--;

                if (count <= 0) {
                    result = num;
                    count = 1;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(majorityElement(new int[]{1,3,1,1,4,1,1,5,1,1,6,2,2}));
    }


}
