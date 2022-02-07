package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 12:52
 * @version: 1.0
 */
public class NewCoder_3 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast != null && fast == slow) {
                meet = slow;
                break;
            }
        }
        if (meet == null) {
            return null;
        }
        ListNode head = pHead;
        while (head != meet) {
            head = head.next;
            meet = meet.next;
        }
        return head;

    }
}
