package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/6 16:42
 * @version: 1.0
 */
public class LeetCode_35 {
    public int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;

        while (end > begin) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 定义target在左闭右开的区间里，[left, right)  target
        while (left < right) { // 因为left == right的时候，在[left, right)是无效的空间
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                right = middle; // target 在左区间，在[left, middle)中
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，在 [middle+1, right)中
            } else { // nums[middle] == target
                return middle; // 数组中找到目标值的情况，直接返回下标
            }
        }
        return right;
    }


    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }


}
