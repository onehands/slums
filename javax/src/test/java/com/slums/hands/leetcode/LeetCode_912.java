package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.Random;

public class LeetCode_912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition2(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);

    }

    private int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];
        int mark = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                mark++;
                swap(nums, mark, i);
            }
        }
        swap(nums, mark, left);
        return mark;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int indexLeft = left;
        int indexRight = right;
        while (indexLeft != indexRight) {
            while (indexLeft < indexRight && nums[indexRight] > pivot) {
                indexRight--;
            }
            while (indexLeft < indexRight && nums[indexLeft] <= pivot) {
                indexLeft++;
            }

            if (indexLeft < indexRight) {
                swap(nums, indexLeft, indexRight);
            }
        }
        swap(nums, indexLeft, left);
        return indexLeft;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int getPivotIndex(int left, int right) {
        return new Random().nextInt(right - left + 1) + left;
    }

    @Test
    public void test() {
        int[] data = new int[]{5, 1, 1, 2, 0, 0};
        sortArray(data);
        for (int datum : data) {
            System.out.println(datum);
        }
    }
}
