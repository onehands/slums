package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 15:33
 * @version: 1.0
 */
public class LeetCode_92 {
    //    head = [1,2,3,4,5], left = 2, right = 4  [1,4,3,2,5]
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        if (head == null) {
            return head;
        }
        int index = 1;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode current = head;
        ListNode pre = null;
        ListNode last = null;
        while (index <= right) {
            if (index == left) {
                leftNode = current;
            } else if (index < left) {
                pre = current;
            }

            current = current.next;
            index++;
        }
        rightNode = current;
        ListNode newHead = reverseBetween(leftNode, rightNode, current);
        if (pre != null) {
            pre.next = newHead;
            return head;
        } else {
            return newHead;
        }
    }

    public ListNode reverseBetween(ListNode head, ListNode tail, ListNode nextSub) {
//        ListNode pre = null;
//        ListNode cur = head;
//        if (cur != tail) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head.next = nextSub;
        return pre;
    }

    //[1,2,3,4,5] 2 4
    @Test
    public void test() {
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = new ListNode(3, new ListNode(5));
        System.out.println(reverseBetween(listNode, 1, 2));
        //[1,4,3,2,5]
    }
}
