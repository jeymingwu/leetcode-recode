package org.example.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 *
 * @author : jeymingwu
 * @date : 2021-07-16
 **/

public class Q0034 {

    public int[] searchRange(int[] nums, int target) {

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = end = mid;
                while (--start >= 0 && nums[start] == target) {
                }
                while (++end < nums.length && nums[end] == target) {
                }
                return new int[]{start + 1, end - 1};
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

}
