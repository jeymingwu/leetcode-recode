package org.example.leetcode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author : jeymingwu
 * @date : 2021-07-21
 **/

public class Q0094 {

    public List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        // 方法一：递归
//        if (root != null) {
//
//            if (root.left != null) {
//                inorderTraversal(root.left);
//            }
//
//            list.add(root.val);
//
//            if (root.right != null) {
//                inorderTraversal(root.right);
//            }
//        }
//
//        return list;

        // 方法二：迭代

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;

        while (treeNode != null || !stack.isEmpty()) {

            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            treeNode = stack.pop();
            list.add(treeNode.val);
            treeNode = treeNode.right;
        }


        return list;
    }
}
