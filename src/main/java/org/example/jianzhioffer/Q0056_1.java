package org.example.jianzhioffer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-05
 **/

public class Q0056_1 {

    public int[] singleNumbers(int[] nums) {

        /**
         * 整体解题思路：
         * 1.首先将整个数组的元素异或，找出两个不相同的数的异或的结果；
         * 2.根据异或的结果判断两个数哪个位上不同；（异或结果，两者相同为 0，相异为 1）
         * 3.根据位上的不同可将两个不同的数区分开，单独异或；（类似用与运算区分数的奇偶性）
         * 4.最后根据异或的性质，得到结果；
         */
        int  k = 0;
        for (int num : nums) {
            k ^= num;
        }

        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
