package org.example.leetcode;

import java.util.Arrays;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组 answer 。
 *
 * https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 *
 * @author : jeymingwu
 * @date : 2021-06-01
 **/

public class Q1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        // 记录在吃到最喜欢的糖果前需要吃完多少糖果（不含最喜欢的糖果数）
        long[] sum = new long[candiesCount.length];
        sum[0] = 0;
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }

        boolean[] record = new boolean[queries.length];

        for (int i = 0; i < queries.length; ++i) {

            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            int favCount = candiesCount[type];

            long maxCount = (long) day * cap; // 最多能吃多少糖果
            long minCount = day; // 一天一颗，最少能吃多少糖果
            long targetCount = sum[type]; // 目标吃完多少糖果

            // 因 day 是从 0 开始计算，那么 maxCount > （targetCount - cap）表示若前一天能吃完目标糖果且至少多一个（即使每天吃最大分量任然有机会吃到喜爱的糖）
            // minCount < (targetCount + favCount) 表示目标糖果足够
            if (maxCount > (targetCount - cap) && minCount < (targetCount + favCount)) {
                record[i] = true;
            }
        }

        return record;
    }

    public static void main(String[] args) {

//        int[] candiesCount = {5,2,6,4,1};
//        int[] candiesCount = {24,41,16,36,6,38,8,43,43,45,17,13,4,44,43,6,10,38,5,23,3,30,5,14,20,31,24,19,32,7,3,20,15,46,8,39,18,21,41,48,39,26,16,46,6,13,10,18,46,25,28,34,31,26,13,8,32,32,49,26,7,46,19,2,24,19,26,22,39,24,48,10,17,10,38,41,48,1,29,30,1,1,27,36,29,37,11,31,5,24,9,33,9,36,3,33,46,49,36};
        int[] candiesCount = {5215,14414,67303,93431,44959,34974,22935,64205,28863,3436,45640,34940,38519,5705,14594,30510,4418,87954,8423,65872,79062,83736,47851,64523,15639,19173,88996,97578,1106,17767,63298,8620,67281,76666,50386,97303,26476,95239,21967,31606,3943,33752,29634,35981,42216,88584,2774,3839,81067,59193,225,8289,9295,9268,4762,2276,7641,3542,3415,1372,5538,878,5051,7631,1394,5372,2384,2050,6766,3616,7181,7605,3718,8498,7065,1369,1967,2781,7598,6562,7150,8132,1276,6656,1868,8584,9442,8762,6210,6963,4068,1605,2780,556,6825,4961,4041,4923,8660,4114};
//        int[][] queries = {{3,10,100}};
//        int[][] queries = {{39,466,2}};
        int[][] queries = {{91,244597,840227137}};

        Q1744 q1744 = new Q1744();
        boolean[] booleans = q1744.canEat(candiesCount, queries);
        System.out.println(Arrays.toString(booleans));

    }

}
