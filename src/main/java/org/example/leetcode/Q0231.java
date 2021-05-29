package org.example.leetcode;

/**
 * 231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 *
 * @author : jeymingwu
 * @date : 2021-05-30
 **/

public class Q0231 {

    public static boolean isPowerOfTwo(int n) {

        // 方法一
//        if (n < 1) {
//            return false;
//        } else if (n > 2) {
//
//            while (n > 1) {
//                if (n % 2 == 0) {
//                    n /= 2;
//                } else {
//                    return false;
//                }
//            }
//            return true;
//
//        } else {
//            return true;
//        }

        // 方法二：
        // 2的幂在二进制中总是最高位为1，其他位为0；
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(Q0231.isPowerOfTwo(-1));
        System.out.println(Q0231.isPowerOfTwo(0));
        System.out.println(Q0231.isPowerOfTwo(1));
        System.out.println(Q0231.isPowerOfTwo(2));
        System.out.println(Q0231.isPowerOfTwo(20));
        System.out.println(Q0231.isPowerOfTwo(64));
    }
}
