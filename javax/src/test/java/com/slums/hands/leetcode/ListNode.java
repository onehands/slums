package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 14:55
 * @version: 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "→" + next;
    }
    public static ListNode extracted(int[] l1_arr) {
        ListNode l1 = null;
        ListNode current = null;
        for (int i : l1_arr) {
            if (l1 == null) {
                l1 = new ListNode(i);
                current = l1;
            } else {
                ListNode next = new ListNode(i);
                current.next = next;
                current = next;
            }
        }
        return l1;
    }

    public static void print(ListNode node) {
        if (node != null) {
            System.out.print(node.val);
            print(node.next);
        } else {
            System.out.println();
        }
    }
}
