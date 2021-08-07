package org.example.jianzhioffer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-07
 **/

public class Q0021 {

    public int[] exchange(int[] nums) {

//        for (int i = 0; i < nums.length; ) {
//
//            if ((nums[i] & 1) == 0) {
//
//                int oddIndex = -1;
//                for (int j = i + 1; j < nums.length; ++j) {
//                    if ((nums[j] & 1) == 1) {
//                        oddIndex = j;
//                        break;
//                    }
//                }
//
//                if (oddIndex == -1) {
//                    break;
//                }
//
//                int tmp = nums[i];
//                nums[i] = nums[oddIndex];
//                nums[oddIndex] = tmp;
//
//            } else {
//                ++i;
//            }
//        }
//
//        return nums;

        // 算法改进
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if ((nums[i] & 1) == 0) {
                // 偶数
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                ++i;
                continue;
            }

            if ((nums[j] & 1) == 1) {
                // 奇数
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                --j;
                continue;
            }
        }

        return nums;
    }
}
