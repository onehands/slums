package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/29 17:49
 * @version: 1.0
 */
public class LeetCode_203 {
    public ListNode removeElements(ListNode head, int val) {
        //
        ListNode emptyHead = new ListNode(-1);
        emptyHead.next = head;
        ListNode cur = emptyHead.next;
        ListNode prev = emptyHead;
        while (cur != null) {
            if (cur.val == val) {
                //remove
                prev.next = null;
                cur = cur.next;
            } else {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }

        }
        return emptyHead.next;
    }

    @Test
    public void test() {
//        ListNode lists1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode lists1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = removeElements(lists1, 7);
        System.out.println(result);
    }
}
