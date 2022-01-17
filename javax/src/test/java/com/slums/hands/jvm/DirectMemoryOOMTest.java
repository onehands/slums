//package com.slums.hands.jvm;
//
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * @author: onehands
// * @description: sth
// * @date: 2022/1/14 17:24
// * @version: 1.0
// * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
// * not work,removed from jdk 9
// */
//public class DirectMemoryOOMTest {
//    private static final int _1MB = 1024 * 1024;
//
//    public static void main(String[] args) throws Exception {
//        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//        unsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
//        while (true) {
//            unsafe.allocateMemory(_1MB);
//        }
//    }
//}
