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

        // 方法一：用了广度优先搜索（杀鸡用牛刀，并不是最优解）
        // 二叉搜索树特征：
        // 1.任一节点均大于其的左子节点；
        // 2.任一节点均小于其的右子节点；

//        if (root == null) {
//            return null;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            while (size > 0) {
//                TreeNode poll = queue.poll();
//                if (poll.val == val) {
//                    return poll;
//                }
//                if (poll.left != null) {
//                    queue.offer(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.offer(poll.right);
//                }
//                --size;
//            }
//        }
//        return null;

        // 方法二：递归
//        if (root == null || root.val == val) {
//            return root;
//        }
//        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);

        // 方法三：迭代
        while (root != null && root.val != val) {

            root = root.val > val ? root.left : root.right;

        }

        return root;
    }

}
