package org.example.leetcode;

import java.util.Arrays;

/**
 * 274. H 指数
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
 *
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 *
 * https://leetcode-cn.com/problems/h-index/
 *
 * 解题思路：（来自于维基百科 https://zh.wikipedia.org/wiki/H%E6%8C%87%E6%95%B0）
 * 1.将其发表的所有SCI论文按被引次数从高到低排序；
 * 2.从前往后查找排序后的列表，只要当前的引用量大于当前的索引值，则H指数加1，最后得到的结果即为最终的H指数。
 *
 * @author : jeymingwu
 * @date : 2021-07-11
 **/

public class Q0274 {

    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int res = 0, count = citations.length;

        for (int i = 0; i < citations.length; ++i) {
            if (citations[i] > --count) {
                ++res;
            }
        }

        return res;
    }
}
