package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 16:53
 * @version: 1.0
 * 209. 长度最小的子数组
 */
public class LeetCode_209 {
    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int[] temp = new int[nums.length + 1];
        int minLength = temp.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            temp[i + 1] = sum;
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[j] - temp[i] >= target) {
                    minLength = Math.min(minLength, j - i);
                }
            }
        }
        return minLength == temp.length ? 0 : minLength;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i + 1 - left);
                sum = sum - nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    @Test
    public void test() {
        System.out.println(minSubArrayLen(15
                , new int[]{1, 2, 3, 4, 5}));
    }
}
