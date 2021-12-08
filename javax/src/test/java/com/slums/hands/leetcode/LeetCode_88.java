package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/8 11:24
 * @version: 1.0
 */
public class LeetCode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = nums1.length - 1;
        while (index >= 0) {
            if (i < 0) {
                nums1[index] = nums2[j];
                index--;
                j--;
                continue;
            }
            if (j < 0) {
                nums1[index] = nums1[i];
                index--;
                i--;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                nums1[index] = nums2[j];
                j--;
            } else {
                nums1[index] = nums1[i];
                i--;
            }
            index--;
        }

    }

    @Test
    public void test() {
//        [1,2,3,0,0,0]
//        3
//                [2,5,6]
//        3
        int[] source = new int[]{1, 2, 3, 0, 0, 0};
        merge(source, 3, new int[]{2, 5, 6}, 3);
        for (int i : source) {
            System.out.println(i);
        }
    }
}
