package org.example.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author : jeymingwu
 * @date : 2021-07-13
 **/

public class Q0121 {

    public int maxProfit(int[] prices) {

        // 方法一：暴力解法（超时）
//        int max = 0;
//
//        for (int i = prices.length - 1; i >= 0; --i) {
//
//            for (int j = i - 1; j >= 0; --j) {
//                int count = prices[i] - prices[j];
//                if (count > 0 && count > max) {
//                    max = count;
//                }
//            }
//        }
//
//        return max;

        // 方法二：动态规划
        // 每次记录是否为最低点，用当前值减去最低点判断是否最大收益

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; ++i) {

            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

}
