package com.slums.hands.leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 11:29
 * @version: 1.0
 */
public class LeetCode_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> lineData = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    lineData.add(1);
                    continue;
                }
                lineData.add(resultList.get(i - 1).get(j - 1) + resultList.get(i - 1).get(j));
            }
            if (lineData.size() > 0) {
                resultList.add(lineData);
            }
        }
        return resultList;
    }

    @Test
    public void test() {
        System.out.println(new Gson().toJson(generate(5)));
        ;
    }
}
