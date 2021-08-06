package org.example.jianzhioffer;

import org.example.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-06
 **/

public class Q0027 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode poll = queue.poll();
            if (poll.left != null || poll.right != null) {
                TreeNode temp = poll.left;
                poll.left = poll.right;
                poll.right = temp;
            }

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
