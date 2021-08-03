package org.example.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-03
 **/

public class Q0057 {

    public int[] twoSum(int[] nums, int target) {

        // 方法一：哈希表法
//        int length = nums.length;
//        if (length < 2) {
//            return new int[]{};
//        }
//        Set<Integer> set = new HashSet<>();
//        set.add(nums[0]);
//
//        for (int i = 1; i < length; ++i) {
//            int diff = target - nums[i];
//            if (set.contains(diff)) {
//                return new int[]{diff, nums[i]};
//            } else {
//                set.add(nums[i]);
//            }
//        }
//
//        return new int[]{};

        // 方法二：双指针
        // 因数组是递增数组，可以用两指针从头部和从尾部判断；
        // 若两者相加比目标结果小，则头部前进一位；（目标结果 - 头部，小于尾部则说明头部不够）
        // 若两者相加比目标结果大，则尾部后退一位；（目标结果 - 头部，大于尾部则说明尾部过大）
        // 直至找出结果或头部指针比尾部指针大；
        int start = 0, end = nums.length - 1;

        while (start < end) {

            int diff = target - nums[start];
            if (diff > nums[end]) {
                --end;
            } else if (diff < nums[end]) {
                ++start;
            } else {
                return new int[]{nums[start], nums[end]};
            }
        }
        return new int[]{};
    }
}
