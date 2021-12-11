package com.slums.hands.leetcode;

import java.util.Stack;

public class LeetCode_2119 {
    class CQueue {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> last = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            first.push(value);
        }

        public int deleteHead() {
            if (!last.isEmpty()) {
                return last.pop();
            }
            while (!first.isEmpty()) {
                last.add(first.pop());
            }
            if (last.isEmpty()) {
                return -1;
            } else {
                return last.pop();
            }
        }
    }
}
