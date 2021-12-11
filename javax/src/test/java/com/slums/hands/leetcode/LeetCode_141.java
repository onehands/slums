package com.slums.hands.leetcode;

import com.slums.hands.service.ListNode;
import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_141 {
    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode nodeFast = head.next;
        ListNode nodeSlow = head;
        while (nodeFast != nodeSlow) {
            if (nodeFast == null || nodeSlow == null || nodeFast.next == null) {
                return false;
            }
            nodeFast = nodeFast.next.next;
            nodeSlow = nodeSlow.next;
        }
        return true;
    }

    @Test
    public void test() {
    }


}
