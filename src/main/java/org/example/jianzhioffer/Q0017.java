package org.example.jianzhioffer;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-09
 **/

public class Q0017 {

    public int[] printNumbers(int n) {

        int pow = (int) Math.pow(10, n);

        int[] nums = new int[pow - 1];

        for (int i = 0; i < pow; ++i) {
            nums[i] = i + 1;
        }

        return nums;

    }
}
