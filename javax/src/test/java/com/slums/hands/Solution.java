package com.slums.hands;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 14:30
 * @version: 1.0
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target_num = target - nums[i];
            if (map.containsKey(target_num)) {
                return new int[]{i, map.get(target_num)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void testTwoSums() {
        int[] a = new int[]{2, 7, 11, 15};
        Solution solution = new Solution();
        System.out.println(solution.twoSum2(a, 9));
    }


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
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode current = null;
        int tmp = 0;
        while (l1 != null || l2 != null) {

            if (l1 != null) {
                tmp = tmp + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                tmp = tmp + l2.val;
                l2 = l2.next;
            }

            int target = (tmp) % 10;
            tmp = tmp / 10;
            if (listNode == null) {
                listNode = new ListNode(target);
                current = listNode;
            } else {
                ListNode next = new ListNode(target);
                current.next = next;
                current = next;
            }

        }
        current.next = new ListNode(tmp);

        return listNode;
    }

    @Test
    public void addTwoNumbers() {
        int[] l1_arr = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] l2_arr = new int[]{9, 9, 9, 9};

        ListNode l1 = extracted(l1_arr);
        ListNode l2 = extracted(l2_arr);

        ListNode result = addTwoNumbers(l1, l2);
        printNode(result);
        System.out.println(result);
    }

    void printNode(ListNode node) {
        if (node != null) {
            System.out.print(node.val);
            printNode(node.next);
        } else {
            System.out.println();
        }
    }

    private ListNode extracted(int[] l1_arr) {
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


}