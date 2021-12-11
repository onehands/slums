package com.slums.hands.leetcode;

import com.slums.hands.service.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_206 {
    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    public ListNode reverseList(ListNode prev, ListNode now) {
        if (now == null) {
            return prev;
        } else {
            ListNode next_1 = now.next;
            now.next = prev;
            prev = now;
            now = next_1;
            return reverseList(prev, now);
        }
    }

    public ListNode reverseList2(ListNode head) {
        ListNode result = null;
        if (head != null) {
            Stack<ListNode> stack = new Stack<>();
            stack.push(new ListNode(head.val));
            while (head.next != null) {
                stack.push(new ListNode(head.next.val));
                head = head.next;
            }
            ListNode first = null;
            while (!stack.isEmpty()) {
                if (first == null) {
                    first = stack.pop();
                    result = first;
                } else {
                    ListNode next = stack.pop();
                    first.next = next;
                    first = next;
                }
            }
        }
        return result;

    }

    public ListNode reverseList3(ListNode head) {
        ListNode last = head;
        ListNode prev = null;
        while (last != null) {
            ListNode temp = last.next;
            last.next = prev;
            prev = last;
            last = temp;
        }
        return prev;
    }

    @Test
    public void test() {
        ListNode head = ListNode.extracted(new int[]{1, 2, 3, 4, 5});
        ListNode.print(reverseList3(head));
    }


}
