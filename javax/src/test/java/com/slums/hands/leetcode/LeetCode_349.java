package com.slums.hands.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/7 11:05
 * @version: 1.0
 */
public class LeetCode_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resultList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
                j++;
                if (resultList.isEmpty()) {
                    resultList.add(nums1[i]);
                } else {
                    if (resultList.get(resultList.size() - 1) != nums1[i]) {
                        resultList.add(nums1[i]);
                    }
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i1 = 0; i1 < result.length; i1++) {
            result[i1] = resultList.get(i1);
        }
        return result;


    }
}
