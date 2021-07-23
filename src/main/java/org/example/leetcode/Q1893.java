package org.example.leetcode;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 *
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 *
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 *
 * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 *
 * @author : jeymingwu
 * @date : 2021-07-23
 **/

public class Q1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {

        int length = ranges.length;

        for (int i = 0; i < length; ++i) {

            int start = ranges[i][0];
            int end = ranges[i][1];

            if (left >= start && right <= end) {
                return true;
            }

            if (left < start && right >= start) {
                right = start - 1;
            }

            if (left <= end && right > end) {
                left = end + 1;
            }

            if (left > right) {
                return true;
            }
        }

        return false;
    }
}
