package org.example.leetcode;

/**
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 *
 * @author : jeymingwu
 * @date : 2021-06-08
 **/

public class Q1049 {

//    private int res = Integer.MAX_VALUE;
//    private int[] stones;
//
//    public int lastStoneWeightII(int[] stones) {
//        this.stones = stones;
//        count(0, 0);
//        return res;
//    }
//
//    private void count(int index, int sum) {
//        if (index == this.stones.length) {
//            if (sum < res)
//                res = sum;
//            return;
//        }
//        count(index + 1, Math.abs(sum - stones[index]));
//        count(index + 1, Math.abs(sum + stones[index]));
//    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int m = (sum >> 1);
        int[] pre = new int[m + 1];
        for (int i = 1; i <= stones.length; ++i) {
            int[] curr = new int[m + 1];
            for (int j = 0; j <= m; ++j) {
                curr[j] = pre[j];
                if (j - stones[i - 1] >= 0)  {
                    curr[j] = Math.max(curr[j], pre[j - stones[i - 1]] + stones[i - 1]);
                }
            }
            pre = curr;
        }
        return sum - (pre[m] << 1);
    }

    public static void main(String[] args) {

//        int[] stones = {2, 7, 4, 1, 8, 1};
//        int[] stones = {31,26,33,21,40};
//
//        Q1049 q1049 = new Q1049();
//        System.out.println(q1049.lastStoneWeightII(stones));
    }
}
