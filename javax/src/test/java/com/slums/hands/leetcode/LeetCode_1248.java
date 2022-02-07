package com.slums.hands.leetcode;

import java.util.HashMap;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/6 21:27
 * @version: 1.0
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/de-liao-yi-wen-jiang-qian-zhui-he-an-pai-yhyf/
 *
 */
public class LeetCode_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //统计奇数个数，相当于我们的 presum
        int oddnum = 0;
        int count = 0;
        map.put(0, 1);
        for (int x : nums) {
            // 统计奇数个数
            oddnum += x & 1;
            // 发现存在，则 count增加
            if (map.containsKey(oddnum - k)) {
                count += map.get(oddnum - k);
            }
            //存入
            map.put(oddnum, map.getOrDefault(oddnum, 0) + 1);
        }
        return count;

    }
}
