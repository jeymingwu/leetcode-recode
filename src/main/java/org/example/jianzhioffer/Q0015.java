package org.example.jianzhioffer;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-06-23
 **/

public class Q0015 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int cnt = 0;

        while (n != 0) {
            n &= n - 1;
            ++cnt;
        }

        return cnt;
    }

    public static void main(String[] args) {

        Q0015 q0015 = new Q0015();
        System.out.println(q0015.hammingWeight(9));


    }
}
