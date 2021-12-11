package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 15:54
 * @version: 1.0
 */
public class LeetCode_215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSort(int[] nums, int begin, int end, int k) {
        int c = quickSortPartition(nums, begin, end);
        if (k == c) {
            return nums[k];
        } else {
            return c < k ? quickSort(nums, c + 1, end, k) : quickSort(nums, begin, c - 1, k);
        }
    }

    private int quickSortPartition(int[] nums, int begin, int end) {
        int p = nums[begin];
        int big = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] > p) {
                big++;
                swap(nums, big, i);
            }

        }
        swap(nums, begin, big);
        return big;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(arr, 4));
        arr = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));

    }
}
