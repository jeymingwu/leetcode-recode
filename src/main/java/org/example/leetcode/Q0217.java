package org.example.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @author : jeymingwu
 * @date : 2021-07-11
 **/

public class Q0217 {

    public boolean containsDuplicate(int[] nums) {

        // 方法一：
//        Arrays.sort(nums);
//
//        for (int i = 1; i < nums.length; ++i) {
//            if (nums[i - 1] == nums[i]) {
//                return true;
//            }
//        }
//
//        return false;

        // 方法二：
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
