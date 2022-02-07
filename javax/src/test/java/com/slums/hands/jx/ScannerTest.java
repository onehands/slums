package com.slums.hands.jx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/5 12:07
 * @version: 1.0
 */
public class ScannerTest {
    public static void main(String[] args) {
//        try (Scanner scan = new Scanner(System.in)) {
//            // next方式接收字符串
//            System.out.println("next方式接收：");
//            // 判断是否还有输入
//            while (scan.hasNext()) {
//                String str1 = scan.next();
//                System.out.println("输入的数据为：" + str1);
//            }
//        }
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> data = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input == -1) {
                    break;
                }
                data.add(input);
            }
            data.sort(Comparator.comparingInt(o -> o));
            //            data.sort(Comparator.reverseOrder());
            data.sort(Comparator.comparingInt(o -> o));
            for (int i : data) {
                System.out.println(i);
            }

        }

    }
}
