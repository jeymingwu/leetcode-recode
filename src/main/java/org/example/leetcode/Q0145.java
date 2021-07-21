package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author : jeymingwu
 * @date : 2021-07-21
 **/

public class Q0145 {

//    public List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        // 方法一：递归
//        if (root != null) {
//
//            if (root.left != null) {
//                postorderTraversal(root.left);
//            }
//            if (root.right != null) {
//                postorderTraversal(root.right);
//            }
//            list.add(root.val);
//        }
//
//        return list;

        // 方法二：迭代

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.empty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        return list;
    }
}
