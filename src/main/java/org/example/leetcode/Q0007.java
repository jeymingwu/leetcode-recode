package org.example.leetcode;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author : jeymingwu
 * @date : 2021-06-05
 **/

public class Q0007 {

    public int reverse(int x) {

        int res = 0;

        while (x != 0) {
            int tmp = res;
            res = res * 10 + x % 10;
            x /= 10;
            if (res / 10 != tmp) { // 溢出判断
                return 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Q0007 q0007 = new Q0007();
        System.out.println(q0007.reverse(123));
        System.out.println(q0007.reverse(-123));
        System.out.println(q0007.reverse(-1234));
        System.out.println(q0007.reverse(120));
        System.out.println(q0007.reverse(0));
    }

}
