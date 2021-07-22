package org.example.leetcode;

import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-22
 **/

public class Q0104 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth = 0, maxDepth = Integer.MIN_VALUE;
        TreeNode prev = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {

            TreeNode pop = stack.pop();

            if (prev != null && (pop.left == prev || pop.right == prev)) {
                --depth;
            } else {
                if (pop.right != null) {
                    stack.push(pop);
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop);
                    stack.push(pop.left);
                }
                ++depth;
            }
            prev = pop;
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }

    public static void main(String[] args) {

        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        Q0104 q0104 = new Q0104();
        System.out.println(q0104.maxDepth(t1));

    }
}
