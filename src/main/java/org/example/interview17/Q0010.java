package org.example.interview17;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 *
 * @author : jeymingwu
 * @date : 2021-07-09
 **/

public class Q0010 {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        Integer count = 0;

        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.getOrDefault(count, 0) < map.get(nums[i])) {
                count = nums[i];
            }
        }

        if (map.get(count) <= nums.length / 2) {
            return -1;
        } else {
            return count;
        }
    }
}
