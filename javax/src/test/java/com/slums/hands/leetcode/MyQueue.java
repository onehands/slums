package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/5 16:09
 * @version: 1.0
 */
public class MyQueue {
//    实现 MyQueue 类：
//
//    void push(int x) 将元素 x 推到队列的末尾
//    int pop() 从队列的开头移除并返回元素
//    int peek() 返回队列开头的元素
//    boolean empty() 如果队列为空，返回 true ；否则，返回 false

    Stack<Integer> stackA = new Stack<>();
    Stack<Integer> stackB = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stackA.push(x);
    }

    public int pop() {
        if (stackB.empty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        if (empty()) {
            return -1;
        }
        return stackB.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        int data = pop();
        stackB.push(data);
        return data;
    }

    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }

    @Test
    public void test() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());

        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
