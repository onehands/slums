package com.slums.hands.leetcode;

import java.util.Arrays;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 17:37
 * @version: 1.0
 */
public class LeetCode_455 {
    /**
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int i = g.length - 1, j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (g[i] > s[j]) {
                i--;
            } else {
                i--;
                j--;
                result += 1;
            }
        }
        return result;


    }
}
