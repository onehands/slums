package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/9 11:28
 * @version: 1.0
 */
public class LeetCode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int maxIndex = Math.max(nums1.length, nums2.length);
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < maxIndex; i++) {

            if (i >= nums1.length) {

            } else {
                set.add(nums1[i]);
            }
            if (i >= nums2.length) {

            } else {
                if (set.contains(nums2[i])) {
                    list.add(nums2[i]);
                }
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            result[i] = integer;
            i++;
        }
        return result;
    }

    @Test
    public void test() {
        intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }
}
