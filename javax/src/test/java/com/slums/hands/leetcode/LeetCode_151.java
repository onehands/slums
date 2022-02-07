package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 16:01
 * @version: 1.0
 */
public class LeetCode_151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i].length()>0){
                sb.append(arr[i]);
                sb.append(" ");
            }


        }
        return sb.toString().trim();
    }
}
