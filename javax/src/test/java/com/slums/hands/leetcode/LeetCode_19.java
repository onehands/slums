package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 14:59
 * @version: 1.0
 */
public class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 双指针的思想
        // 定义一个快指针,定义一个慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 先让快指针走n步
        while (n-- != 0) {
            fast = fast.next;
        }
        // 如果快指针走到了最后说明删除的是第一个节点,就返回head.next就好
        if (fast == null) {
            return head.next;
        }
        // 使得slow每次都是在待删除的前一个节点, 所以要先让fast先走一步
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 因为已经保证了是待删除节点的前一个节点, 直接删除即可
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        head = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode prev = slow;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head.next;

    }

    @Test
    public void test() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(removeNthFromEnd3(node, 2));
    }

}
