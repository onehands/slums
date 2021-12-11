package com.slums.hands.service;

public class ListNode {
    public int val;
    public ListNode next;

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
