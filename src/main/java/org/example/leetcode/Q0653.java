package org.example.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 *
 * @author : jeymingwu
 * @date : 2021-07-24
 **/

public class Q0653 {

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {
                --size;
                TreeNode poll = queue.poll();
                int diff = k - poll.val;
                if (set.contains(diff)) {
                    return true;
                } else {
                    set.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return false;
    }
}
