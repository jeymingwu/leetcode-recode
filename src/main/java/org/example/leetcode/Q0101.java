package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-23
 **/

public class Q0101 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {

            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if (leftNode == null && rightNode == null) {
                continue;
            } else if (leftNode == null || rightNode == null) {
                return false;
            } else if (leftNode.val != rightNode.val) {
                return false;
            } else {
                queue.offer(leftNode.left);
                queue.offer(rightNode.right);

                queue.offer(leftNode.right);
                queue.offer(rightNode.left);
            }

        }

        return true;
    }
}
