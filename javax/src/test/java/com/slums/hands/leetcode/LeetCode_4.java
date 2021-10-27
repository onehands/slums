package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            if (nums2.length == 0) {
                return 0;
            }
            if (nums2.length == 1) {
                return nums2[0];
            }
        }
        if (nums2.length == 0) {
            if (nums1.length == 1) {
                return nums1[0];
            }
        }
        int maxLength = nums1.length + nums2.length;
        boolean flag = maxLength % 2 == 0;
        if (flag) {
            maxLength = (maxLength) / 2 + 1;
        } else {
            maxLength = (maxLength - 1) / 2 + 1;
        }
        int[] resultArr = new int[maxLength];
        int numa = 0, numb = 0;
        for (int i = 0; i < maxLength; i++) {
            int value_a = Integer.MAX_VALUE;
            if (numa < nums1.length) {
                value_a = nums1[numa];
            }
            int value_b = Integer.MAX_VALUE;
            if (numb < nums2.length) {
                value_b = nums2[numb];
            }
            if (value_a < value_b) {
                resultArr[i] = value_a;
                numa++;
            } else {
                resultArr[i] = value_b;
                numb++;
            }
        }
        if (flag) {
            return (resultArr[resultArr.length - 1] + resultArr[resultArr.length - 2]) / 2.0;
        } else {
            return resultArr[resultArr.length - 1];
        }
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


}
