package org.example.leetcode;

/**
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-23
 **/

public class Q0701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode newVal = new TreeNode(val);

        if (root == null) {
            return newVal;
        }

        TreeNode node = root;

        while (node != null) {

            if (val < node.val && node.left == null) {
                node.left = newVal;
            } else if (val > node.val && node.right == null) {
                node.right = newVal;
            } else {
                node = node.val > val ? node.left : node.right;
            }
        }

        return root;
    }

}
