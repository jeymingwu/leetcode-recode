package org.example.jianzhioffer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-07-17
 **/

public class Q0042 {

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int length = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < length; ++i) {
            sum = Math.max(nums[i] + sum, nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}
