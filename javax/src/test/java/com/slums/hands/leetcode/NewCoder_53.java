package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 22:05
 * @version: 1.0
 */
public class NewCoder_53 {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode fast = fakeHead;
        while (n >= 1) {
            fast = fast.next;
            n--;
        }
        ListNode slow = fakeHead;
        ListNode pre = slow;
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return fakeHead.next;
    }

    @Test
    public void test() {
        ListNode d = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(d, 2));
    }
}
