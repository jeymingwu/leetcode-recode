package org.example.jianzhioffer;

import org.example.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-10
 **/

public class Q0028 {

    public boolean isSymmetric(TreeNode root) {

        // 方法一：广度优先搜索
//        if (root == null || (root.left == null && root.right == null)) {
//            return true;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root.left);
//        queue.offer(root.right);
//
//        while (!queue.isEmpty()) {
//
//            TreeNode left = queue.poll();
//            TreeNode right = queue.poll();
//
//            if (left == null && right == null) {
//                continue;
//            } else if (left == null || right == null) {
//                return false;
//            } else if (left.val != right.val) {
//                return false;
//            } else {
//                queue.offer(left.left);
//                queue.offer(right.right);
//
//                queue.offer(left.right);
//                queue.offer(right.left);
//            }
//        }
//
//        return true;

        // 方法二：递归

        return root == null || recur(root.left, root.right);
    }

    boolean recur (TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null || left.val != right.val) {
            return false;
        } else {
            return recur(left.left, right.right) && recur(left.right, right.left);
        }

    }

}
