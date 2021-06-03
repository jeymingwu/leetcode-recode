package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * https://leetcode-cn.com/problems/contiguous-array/
 *
 * @author : jeymingwu
 * @date : 2021-06-03
 **/

public class Q0525 {

    public int findMaxLength(int[] nums) {

//        int max = 0;
//
//        for (int i = 0; i < nums.length; ++i) {
//
//            int zero = 0, one = 0;
//
//
//            for (int j = i; j < nums.length; ++j) {
//
//                if (nums[j] == 0) {
//                    ++zero;
//                } else {
//                    ++one;
//                }
//
//                if (zero == one && zero > max) {
//                    max = zero;
//                }
//            }
//
//        }
//
//        return max * 2;

        // 前缀和 + 哈希表
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);

        int res = 0, sum = 0;

        for (int i = 0; i < nums.length; ++i) {

            if (nums[i] == 0) {
                --sum;
            } else {
                ++sum;
            }

            if (map.containsKey(sum)) {
                res = Math.max(i - map.get(sum), res);
            } else {
                map.put(sum, i);
            }
        }

        return res;
    }

}
