package org.example.leetcode;

/**
 * @author : jeymingwu
 * @date : 2021-07-11
 **/

public class Q0053 {

    public int maxSubArray(int[] nums) {

        // 方法一：暴力计算
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nums.length; ++i) {
//            int sum = 0;
//            for (int j = i; j < nums.length; ++j) {
//                sum += nums[j];
//                if (sum > max) {
//                    max = sum;
//                }
//            }
//        }
//
//        return max;

        // 方法二：贪心算法
//        int pre = 0, sumAns = nums[0];
//        for (int i = 0; i < nums.length; ++i) {
//            pre = Math.max(pre + nums[i], nums[i]); // 若累加数值还不如本身的大，那么从该处起重新计算；
//            sumAns = Math.max(pre, sumAns);
//        }
//        return sumAns;

        // 方法三：动态规划

        int length = nums.length;

        if (nums == null || length <= 0) {
            return 0;
        }

        int[] dp = new int[length];

        dp[0] = nums[0];

        for (int i = 1; i < length; ++i) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int max = dp[0];
        for (int i = 1; i < length; ++i) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
