package com.slums.hands.other;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/10 17:11
 * @version: 1.0
 */
public class A {
    private int a;
    public int b;
    private static int c;
    private static final int d;
    private final int e;

    public A() {
        e = 0;
    }

    static {
        d = 0;
    }

    class B {
        static final int int_v = 0;
        final String str = new String("");

        public void test() {
            System.out.println(a);
        }
    }

    public void test() {
        new Runnable() {
            private int d;

            @Override
            public void run() {
                System.out.println(c);
            }
        };
    }
}
