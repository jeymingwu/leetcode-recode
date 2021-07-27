package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-27
 **/

public class Q0671 {

    public int findSecondMinimumValue(TreeNode root) {


        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int min = root.val, otherMin = Integer.MAX_VALUE;
        boolean flag = false;
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode poll = queue.poll();
            if (poll.val > min && poll.val <= otherMin) {
                flag = true;
                otherMin = poll.val;
            }
            if (poll.left != null || poll.right != null) {
                queue.offer(poll.left);
                queue.offer(poll.right);
            }

        }

        return !flag ? -1 : otherMin;
    }

}
