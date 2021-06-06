package org.example.leetcode;

/**
 * 474. 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 *
 * @author : jeymingwu
 * @date : 2021-06-06
 **/

public class Q0474 {

    public int findMaxForm(String[] strs, int m, int n) {

//
//        for (int i = 1; i < strs.length + 1; ++i) {
//            count[i] = strs[i - 1].length();
//        }
//
//        int[][] res = new int[strs.length + 1][m + n + 1];
//
//        for (int i = 1; i < strs.length + 1; ++i) {
//
//            for (int j = count[i]; j < m + n + 1; ++j) {
//
//                res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - count[i]] + 1);
//            }
//
//        }
//
//        return res[strs.length][m + n];

        int[][] dp = new int[m + 1][n + 1];

        for (String str:strs) {

            int one = 0, zero = 0;
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == '0') {
                    ++zero;
                } else {
                    ++one;
                }
            }

            for (int i = m; i >= one; --i) {
                for (int j = n; j >= one; --j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};

        Q0474 q0474 = new Q0474();
        System.out.println(q0474.findMaxForm(strs, 4, 3));

        /*

        ["10","0001","111001","1","0"] 4 3

         */

    }

}
