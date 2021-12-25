package com.slums.hands.leetcode;

public class LeetCode_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
            if (fast == slow) {
                ListNode pr = head;
                while (pr != slow) {
                    pr = pr.next;
                    slow = slow.next;
                }
                return pr;
            }
        }
        return null;

    }
}
