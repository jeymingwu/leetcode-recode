package org.example.jianzhioffer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-07-16
 **/

public class Q0053 {

    public int search(int[] nums, int target) {

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = end = mid;
                while (--start >= 0 && nums[start] == target) {
                }
                while (++end < nums.length && nums[end] == target) {
                }
                return end - start - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}
