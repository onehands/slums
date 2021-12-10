package com.slums.hands.leetcode;


/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/9 11:15
 * @version: 1.0
 */
public class LeetCode_557 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char[] charArr = arr[i].toCharArray();
            reverseString(charArr);
            sb.append(charArr);

            if (i != arr.length - 1) {
                sb.append(" ");

            }
        }
        return sb.toString();
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
