package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : jeymingwu
 * @date : 2021-07-12
 **/

public class Q0001 {

    public int[] twoSum(int[] nums, int target) {

        // 方法一：时间复杂度O(N)
//        int length = nums.length;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < length; ++i) {
//            map.put(nums[i], i);
//        }
//
//        for (int i = 0; i < length; ++i) {
//            int index = target - nums[i];
//            int tmp;
//            if (map.containsKey(index) && (tmp = map.get(index)) != i) {
//                return new int[]{i, tmp};
//            }
//        }
//        return null;

        // 方法一：改进

        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; ++i) {

            int index = target - nums[i];
            if (map.containsKey(index)) {
                return new int[]{map.get(index), i};
            }
            map.put(nums[i], i);
        }

        return null;

        // 方法二：时间复杂度O(N^2)
//        int length = nums.length;
//
//        for (int i = 0; i < length - 1; ++i) {
//
//            for (int j = i + 1; j < length; ++j) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//
//        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Q0001 q0001 = new Q0001();
        System.out.println(Arrays.toString(q0001.twoSum(nums, target)));
    }

}
