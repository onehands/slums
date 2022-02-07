package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 18:10
 * @version: 1.0
 * NC33 合并两个排序的链表
 */
public class NewCoder_33 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();

        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            } else {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            }
        }
        while (list1 != null) {
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        }
        return head.next;
    }

    @Test
    public void test() {

    }
}
