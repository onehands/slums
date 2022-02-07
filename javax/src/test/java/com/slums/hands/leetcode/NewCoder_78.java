package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 14:54
 * @version: 1.0
 * NC78 反转链表
 */
public class NewCoder_78 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode res = ReverseList(head.next);
            head.next.next = head;
            head.next = null;
            return res;
        }
    }

    @Test
    public void test() {
        ListNode l = new ListNode(1, new ListNode(2,new ListNode(3)));
        System.out.println(ReverseList(l));
    }
}
