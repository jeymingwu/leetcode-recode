package org.example.leetcode;

/**
 * 275. H 指数 II
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 *
 * https://leetcode-cn.com/problems/h-index-ii/
 *
 * @author : jeymingwu
 * @date : 2021-07-12
 **/

public class Q0275 {

    public int hIndex(int[] citations) {

        // 方法一：从头部开始逐个判断
//        int sum = 0;
//
//        for (int i = 0; i < citations.length; ++i) {
//            if (citations[i] > citations.length - 1 - i) {
//                ++sum;
//            }
//        }
//
//        return sum;

        // 方法二：从尾部开始逐个判断，直至不符合的跳出
        int n = citations.length;

        for (int i = n - 1; i >= 0; --i) {
            int t = n - 1 - i;
            if (citations[i] <= t) {
                return t;
            }

        }

        return citations[0] > n - 1 ? n : 0;
    }

    public static void main(String[] args) {
        Q0275 q0275 = new Q0275();
        int[] citations = {0,1,3,5,6};
        System.out.println(q0275.hIndex(citations));
    }

}
