package com.slums.hands.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        boolean bigger = nums1.length > nums2.length;
        int[] tmp = bigger ? nums2 : nums1;
        int[] target = bigger ? nums1 : nums2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tmp) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int[] tempArr = new int[target.length];
        int index = 0;
        for (int i : target) {
            Integer count = map.getOrDefault(i, 0);
            if (count > 0) {
                map.put(i, map.get(i) - 1);
                tempArr[index] = i;
                index++;
            }
        }
        return Arrays.copyOfRange(tempArr, 0, index);
    }
}
