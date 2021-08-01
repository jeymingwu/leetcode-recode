package org.example.interview;

import java.util.Arrays;

/**
 * 面试题3. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-02
 **/

public class Q0003 {

    public int findRepeatNumber(int[] nums) {

        // 方法一：排序
//        Arrays.sort(nums);
//        int length = nums.length;
//        for (int i = 1; i < length; ++i) {
//
//            if (nums[i] == nums[i - 1]) {
//                return nums[i];
//            }
//        }
//
//        return -1;

        // 方法二：数组、哈希表
        int length = nums.length;
        int[] remark = new int[length];

        for (int i = 0; i < length; ++i) {
            if (remark[nums[i]] == 0) {
                ++remark[nums[i]];
            } else {
                return nums[i];
            }
        }

        return -1;
    }
}
