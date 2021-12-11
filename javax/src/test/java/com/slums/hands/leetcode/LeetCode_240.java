package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; ) {
            for (int j = 0; j < matrix[i].length; ) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    //换行
                    if (++j >= matrix[i].length) {

                        i++;
                        if (i >= matrix.length) {
                            return false;
                        }
                        j = j - 1;
                        while (matrix[i][j] >= target && j >= 1) {
                            j--;
                        }
                        continue;
                    }
                }
                //左下
                if (matrix[i][j] > target) {
                    i++;
                    if (i >= matrix.length) {
                        return false;
                    }
                    while (matrix[i][j] > target && j > 1) {
                        j--;
                    }
                    j = j > 0 ? j - 1 : j;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
//        [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
//        [[1,3,5,7,9],[2,4,6,8,10],[11,13,15,17,19],[12,14,16,18,20],[21,22,23,24,25]]
        int[][] a = new int[][]{new int[]{1, 3, 5, 7, 9},
                new int[]{2, 4, 6, 8, 10},
                new int[]{11, 13, 15, 17, 19},
                new int[]{12, 14, 16, 18, 20},
                new int[]{21, 22, 23, 24, 25}

        };
//        int[][] a = new int[][]{new int[]{1, 4, 7, 11, 15},
//                new int[]{2, 5, 8, 12, 19},
//                new int[]{3, 6, 9, 16, 22},
//                new int[]{10, 13, 14, 17, 24},
//                new int[]{18, 21, 23, 26, 30}
//
//        };
//        [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
//        int[][] a = new int[][]{new int[]{-5}

//        };
        System.out.println(searchMatrix(a, 11));
    }


}
