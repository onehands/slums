package com.slums.hands.leetcode;

import org.junit.Test;

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
    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(swapPairs(head));
    }
}
