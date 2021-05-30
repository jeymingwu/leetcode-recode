package org.example.leetcode;

/**
 * 342. 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * https://leetcode-cn.com/problems/power-of-four/
 *
 * @author : jeymingwu
 * @date : 2021-05-31
 **/

public class Q0342 {

    public static boolean isPowerOfFour(int n) {

        // 方法一：
//        if (n == 1 || n == 4) {
//            return true;
//        } else if (n > 4 && n % 4 == 0) {
//
//            while (n > 1) {
//                if (n % 4 != 0) {
//                    return false;
//                }
//                n /= 4;
//            }
//            return true;
//
//        } else {
//            return false;
//        }

        // 方法二：4 的幂肯定是 2 的幂，那么只要在 2 的幂的基础上判断该数被 3 取模是否余数为 1 即可。
        if (n < 0 || (n & (n - 1)) != 0) {
            return false;
        }
        return n % 3 == 1;
    }

    public static void main(String[] args) {

        System.out.println(Q0342.isPowerOfFour(-1));
        System.out.println(Q0342.isPowerOfFour(0));
        System.out.println(Q0342.isPowerOfFour(1));
        System.out.println(Q0342.isPowerOfFour(4));
        System.out.println(Q0342.isPowerOfFour(8));
        System.out.println(Q0342.isPowerOfFour(16));

    }
}
