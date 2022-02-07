package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> charIndex = new HashMap<>();

        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char charV = s.charAt(i);
            if (charIndex.containsKey(charV)) {
                j = Math.max(charIndex.get(charV) + 1, j);
            }
            charIndex.put(charV, i);
            result = Math.max(result, (i - j + 1));

        }
        return result;


    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcadea123456"));
    }


}
