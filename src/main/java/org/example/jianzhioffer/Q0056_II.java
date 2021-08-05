package org.example.jianzhioffer;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-05
 **/
public class Q0056_II {

    public int singleNumber(int[] nums) {

        /**
         * 统计位数，再与3取余，最后得到结果；
         */
        int length = nums.length;
        int[] count = new int[32];
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < 32; ++j) {
                count[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }

        int res = 0;
        for (int i = 31; i >= 0; --i) {
            res <<= 1;
            res |= count[i] % 3;
        }
        return res;
    }
}
