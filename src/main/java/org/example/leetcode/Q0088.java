package org.example.leetcode;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author : jeymingwu
 * @date : 2021-07-12
 **/

public class Q0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0, j = 0; i < nums1.length && j < n; ++i) {
            if (nums1[i] > nums2[j]) {
                transfer(nums1, i);
                nums1[i] = nums2[j++];
                ++m;
            }
            if (i >= m) {
                nums1[i] = nums2[j++];
            }
        }
    }

    private void transfer(int[] nums, int index) {

        for (int i = nums.length - 1; i > index; --i) {
            nums[i] = nums[i - 1];
        }
    }

    public static void main(String[] args) {
        Q0088 q0088 = new Q0088();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = {2, 5, 6};
//        int[] num2 = {4, 5, 6};
        int n = 3;
        q0088.merge(nums1, m, num2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
