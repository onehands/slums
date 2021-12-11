package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 16:45
 * @version: 1.0
 */
public class LeetCode_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val < list2.val) {
            head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode current = head;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
                continue;
            }
            if (list1.val < list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        return head;
    }

    @Test
    public void test() {
//        [1,2,4]
//[1,3,4]
//        ListNode lists1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode lists2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        ListNode result = mergeTwoLists(lists1, lists2);
//        System.out.println(result);
        ListNode lists1 = new ListNode(1);
        ListNode lists2 = new ListNode(2);
        ListNode result = mergeTwoLists(lists1, lists2);
        System.out.println(result);
    }
}
