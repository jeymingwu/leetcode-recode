package org.example.jianzhioffer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-02
 **/

public class Q0010 {

    public int fib(int n) {

        // 方法一：递归；超时
//        if (n == 0) {
//            return 0;
//        } else if (n == 1) {
//            return 1;
//        } else {
//            return (fib(n - 1) + fib(n - 2)) % 1000000007;
//        }

        int one = 0, two = 1, sum;

        for (int i = 0; i < n; ++i) {
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }

        return one;
    }

}
