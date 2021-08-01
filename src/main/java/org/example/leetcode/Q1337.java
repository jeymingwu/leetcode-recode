package org.example.leetcode;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 *
 * @author : jeymingwu
 * @date : 2021-08-01
 **/

public class Q1337 {

    public int[] kWeakestRows(int[][] mat, int k) {

        int length = mat.length;
        int[] sums = new int[length];
        for (int i = 0; i < length; ++i) {

            int sum = 0;
            int tmpLength = mat[i].length;
            for (int j = 0; j < tmpLength; ++j) {

                if (mat[i][j] == 0) {
                    break;
                }
                sum += mat[i][j];
            }
            sums[i] = sum;
        }

        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {

            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < length; ++j) {
                if (min > sums[j]) {
                    min = sums[j];
                    index = j;
                }
            }

            res[i] = index;
            sums[index] = Integer.MAX_VALUE;
        }

        return res;
    }

}
