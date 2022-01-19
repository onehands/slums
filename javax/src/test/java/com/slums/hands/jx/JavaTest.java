package com.slums.hands.jx;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/19 14:39
 * @version: 1.0
 */
public class JavaTest {
    @Test
    public void intLongTest() {
        int b = 2147483647;
        long c = b * 2;
//        System.out.println(a);
        System.out.println(c);
    }

    @Test
    public void compareTest() {
        List<Integer> list = Arrays.asList(1, 3, 1, 4, 1);
        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.naturalOrder());

        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        list.sort(Integer::compareTo);
        System.out.println(list);
    }

    @Test
    public void treeTest() {
        Map<Integer, String> user = new TreeMap<>(Comparator.naturalOrder());
        user.put(12, "name_12");
        user.put(2, "name_12");
        user.put(10, "name_10");
        user.put(8, "name_8");
        user.put(18, "name_18");
        System.out.println(user);
    }
}
