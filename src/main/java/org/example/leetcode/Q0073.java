package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 *
 * @author : jeymingwu
 * @date : 2021-07-15
 **/

public class Q0073 {

    public void setZeroes(int[][] matrix) {

        // 方法一：
//        List<Integer[]> list = new ArrayList<>();
//
//        for (int i = 0; i < matrix.length; ++i) {
//            for (int j = 0; j < matrix[i].length; ++j) {
//                if (matrix[i][j] == 0) {
//                    Integer[] nums = new Integer[2];
//                    nums[0] = i;
//                    nums[1] = j;
//                    list.add(nums);
//                }
//            }
//        }
//
//        for (int i = 0; i < list.size(); ++i) {
//            Integer[] nums = list.get(i);
//            for (int j = 0; j < matrix[nums[0]].length; ++j) {
//                matrix[nums[0]][j] = 0;
//            }
//            for (int j = 0; j < matrix.length; ++j) {
//                matrix[j][nums[1]] = 0;
//            }
//        }

        // 方法二：
        int m = matrix.length, n = matrix[0].length;

        boolean[] x = new boolean[m];
        boolean[] y = new boolean[n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    x[i] = y[j] = true;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (x[i] || y[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
