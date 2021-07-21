package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author : jeymingwu
 * @date : 2021-07-21
 **/

public class Q0144 {

    public List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        // 方法一：遍历
//        List<Integer> list = new ArrayList<>();
//
//        if (root == null) {
//            return list;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode pop = stack.pop();
//            list.add(pop.val);
//            if (pop.right != null) {
//                stack.push(pop.right);
//            }
//            if (pop.left != null) {
//                stack.push(pop.left);
//            }
//        }
//
//        return list;

        // 方法二：递归
        if (root != null) {

            list.add(root.val);

            if (root.left != null) {
                preorderTraversal(root.left);
            }
            if (root.right != null) {
                preorderTraversal(root.right);
            }
        }

        return list;
    }
}
