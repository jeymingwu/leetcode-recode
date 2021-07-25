package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-25
 **/

public class Q0098 {

    public boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    public boolean isValidBST(TreeNode root) {
        // 方法一：递归
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        // 方法二：搜索二叉树的中序遍历是升序的
        Deque<TreeNode> deque = new LinkedList<>();
        long last = Long.MIN_VALUE;

        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();

            if (root.val <= last) {
                return false;
            }
            last = root.val;
            root = root.right;
        }
        return true;
    }
}
