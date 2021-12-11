package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_155 {

    class MinStack {
        ListNode node = null;

        public MinStack() {

        }

        public void push(int val) {
            if (node == null) {
                node = new ListNode(val, node);
            } else {
                node = new ListNode(val, Math.min(val, node.min), node);
            }

        }

        public void pop() {
            node = node.prev;
        }

        public int top() {
            return node.val;
        }

        public int getMin() {
            return node.min;
        }
    }

    class ListNode {
        public int val;
        public int min = 0;
        public ListNode prev;

        @Override
        public String toString() {
            return String.valueOf(val);
        }

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.prev = next;
        }

        ListNode(int val, ListNode prev) {
            this.val = val;
            this.prev = prev;
            this.min = val;
        }

        public ListNode extracted(int[] l1_arr) {
            ListNode l1 = null;
            ListNode current = null;
            for (int i : l1_arr) {
                if (l1 == null) {
                    l1 = new ListNode(i);
                    current = l1;
                } else {
                    ListNode next = new ListNode(i);
                    current.prev = next;
                    current = next;
                }
            }
            return l1;
        }

        public void print(ListNode node) {
            if (node != null) {
                System.out.print(node.val);
                print(node.prev);
            } else {
                System.out.println();
            }
        }
    }

}
