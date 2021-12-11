package com.slums.hands.leetcode;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 11:02
 * @version: 1.0
 */
public class LeetCode_566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if (mat.length == 0) {
            return mat;
        }
        if (mat[0].length == 0) {
            return mat;
        }
        if (r * c == 0) {
            return mat;
        }
        int sourceSize = mat.length * mat[0].length;
        if (sourceSize != r * c) {
            return mat;
        }

        int[][] target = new int[r][c];
        int[] data = new int[c];
        int len = 0;
        int hi = 0;
        for (int[] ints : mat) {
            for (int m = 0; m < mat[0].length; m++) {
                data[len] = ints[m];
                len++;
                if (len == c) {
                    len = 0;
                    target[hi] = data;
                    hi++;
                    data = new int[c];
                }
            }
        }
        return target;
    }

    @Test
    public void test() {
//        , r = 1, c = 4
//        int[][] data = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
        int[][] data = new int[][]{new int[]{1, 2, 3, 4}};
        data = matrixReshape(data, 2, 2);
        System.out.println(new Gson().toJson(data));

    }
}
