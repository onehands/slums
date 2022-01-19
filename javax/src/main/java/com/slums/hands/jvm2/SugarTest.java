package com.slums.hands.jvm2;

import java.util.Arrays;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/18 11:21
 * @version: 1.0
 */
public class SugarTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);//true
        System.out.println(e == f);//false
        System.out.println(c == (a + b));//true
        System.out.println(c.equals(a + b));//true
        System.out.println(g == (a + b));//true  var9 == (long)(var10 + var11)
        System.out.println(g.equals(a + b));//false
//        System.out.println(g == d);compile error
        System.out.println(g.equals(d));//false
    }
}
