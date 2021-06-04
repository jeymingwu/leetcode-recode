package org.example.leetcode;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author : jeymingwu
 * @date : 2021-06-04
 **/

public class Q0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; ++i) {
            nums[i] = nums1[i];
        }

        int index = nums1.length;
        for (int i = 0; i < nums2.length; ++i) {
            nums[index++] = nums2[i];
        }

        Arrays.sort(nums);

        int mid = nums.length / 2;

        if (nums.length % 2 == 0) {
            return ((double) (nums[mid] + nums[mid - 1])) / 2;
        } else {
            return nums[mid];
        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[0];
        int[] num2 = new int[1];
        num2[0] = 1;

        Q0004 q0004 = new Q0004();
        System.out.println(q0004.findMedianSortedArrays(num1, num2));
    }
}
