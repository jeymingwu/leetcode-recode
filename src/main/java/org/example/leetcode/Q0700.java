package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-23
 **/

public class Q0700 {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.val == val) {
                    return poll;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                --size;
            }
        }
        return null;
    }

}
