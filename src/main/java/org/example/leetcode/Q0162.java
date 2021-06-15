package org.example.leetcode;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * https://leetcode-cn.com/problems/find-peak-element/
 *
 * @author : jeymingwu
 * @date : 2021-06-15
 **/

public class Q0162 {

    public int findPeakElement(int[] nums) {

        // 方法一：
//        int max = 0;
//
//        for (int i = 1; i < nums.length - 1; ++i) {
//            if (nums[i] > nums[max]) {
//                max = i;
//            }
//        }
//
//        return max;

        // 方法二：
        int start = 0, end = nums.length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return mid;
    }

}
