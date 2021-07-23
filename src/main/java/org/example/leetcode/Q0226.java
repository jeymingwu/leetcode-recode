package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-23
 **/

public class Q0226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode poll = queue.poll();

            TreeNode node = poll.left;
            poll.left = poll.right;
            poll.right = node;

            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

        return root;
    }
}
