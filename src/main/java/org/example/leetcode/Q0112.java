package org.example.leetcode;

import java.util.Stack;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author : jeymingwu
 * @date : 2021-07-23
 **/

public class Q0112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // 方法一：迭代，深度优先
//        if (root == null) {
//            return false;
//        }
//
//        int sum = 0;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        TreeNode prep = null;
//
//        while (!stack.empty()) {
//
//            TreeNode pop = stack.pop();
//
//            if (prep != null && (pop.left == prep || pop.right == prep || pop == prep)) {
//                sum -= pop.val;
//            } else {
//                sum += pop.val;
//                if (pop.left == null && pop.right == null && sum == targetSum) {
//                    return true;
//                } else {
//                    stack.push(pop);
//                    if (pop.right != null) {
//                        stack.push(pop.right);
//                    }
//                    if (pop.left != null) {
//                        stack.push(pop.left);
//                    }
//                }
//            }
//            prep = pop;
//        }
//
//        return false;

        // 方法二：递归，深度优先
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
