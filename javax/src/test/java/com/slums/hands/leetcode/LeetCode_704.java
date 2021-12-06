package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/6 16:42
 * @version: 1.0
 */
public class LeetCode_704 {
    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int begin, int end) {

        int length = end - begin + 1;
        if (length == 0) {
            return -1;
        }
        int mid = length / 2 + begin;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return search(nums, target, mid + 1, end);
        } else {
            return search(nums, target, begin, mid - 1);
        }
    }

    public static int search2(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int mid = (end - begin + 1) / 2;
        while (mid >= begin && mid <= end) {
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                begin = mid + 1;
            }
            mid = begin + (end - begin + 1) / 2;
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

}
