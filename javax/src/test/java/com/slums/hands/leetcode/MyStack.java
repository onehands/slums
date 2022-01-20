package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        if (size == 0) {
            return -1;
        }
        if (size == 1) {
            return queue.poll();
        }
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        int top = pop();
        queue.offer(top);
        return top;
    }

    public boolean empty() {
        return queue.size() == 0;
    }

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
