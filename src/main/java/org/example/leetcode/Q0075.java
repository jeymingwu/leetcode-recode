package org.example.leetcode;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author : jeymingwu
 * @date : 2021-07-28
 **/

public class Q0075 {

    public void sortColors(int[] nums) {

        // 方法一：快速排序
//        Arrays.sort(nums);

        // 方法二：冒泡
//        int length = nums.length;
//        for (int i = 0; i < length; ++i) {
//
//            for (int j = i + 1; j < length; ++j) {
//
//                if (nums[i] > nums[j]) {
//                    nums[i] = nums[i] + nums[j];
//                    nums[j] = nums[i] - nums[j];
//                    nums[i] = nums[i] - nums[j];
//                }
//            }
//        }

        // 方法三：遍历交换（单指针）
        int index = 0;
        int length = nums.length;

        for (int i = 0; i < length; ++i) {

            if (nums[i] == 0) {
                int tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = index; i < length; ++i) {

            if (nums[i] == 1) {
                int tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
