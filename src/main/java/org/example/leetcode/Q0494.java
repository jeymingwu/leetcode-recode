package org.example.leetcode;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * https://leetcode-cn.com/problems/target-sum/
 *
 * @author : jeymingwu
 * @date : 2021-06-07
 **/

public class Q0494 {

    int ret = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return ret;
    }

    public void dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length && sum == target) {
            ret++;
            return;
        }
        if (index < nums.length) {
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }
}
