package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/13 10:59
 * @version: 1.0
 */
public class LeetCode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode next = head.next;
        if (next == null) {
            return head;
        }
        ListNode theRest = next.next;
        next.next = head;
        head.next = swapPairs(theRest);
        return next;
    }
}
