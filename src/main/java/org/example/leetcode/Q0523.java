package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 *
 * @author : jeymingwu
 * @date : 2021-06-02
 **/

public class Q0523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        // 方式一：暴力破解
//        for (int i = 0; i < nums.length; ++i) {
//
//            int sum = nums[i];
//
//            for (int j = i + 1; j < nums.length; ++j) {
//                sum += nums[j];
//                if (sum % k == 0) {
//                    return true;
//                }
//            }
//
//        }
//
//        return false;

        // 方式二：前缀和 + 同余定义
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];

            int v = 0;

            if (k != 0) {
                v = sum % k;
            }
            if (map.containsKey(v)) {
                if (i - map.get(v) > 1) {
                    return true;
                }
            } else {
                map.put(v, i);
            }
        }

        return false;
    }

}
