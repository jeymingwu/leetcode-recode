package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-24
 **/

public class Q0235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 方法一：双重遍历，分别找出该节点的路径
        // 公共祖先一定有相同的路径
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        TreeNode pNode = root, qNode = root;

        while (pNode.val != p.val || qNode.val != q.val) {
            pQueue.offer(pNode);
            qQueue.offer(qNode);

            if (pNode.val > p.val) {
                pNode = pNode.left;
            } else if (pNode.val < p.val) {
                pNode = pNode.right;
            }

            if (qNode.val > q.val) {
                qNode = qNode.left;
            } else if (qNode.val < q.val) {
                qNode = qNode.right;
            }
        }

        TreeNode node = null;
        while (!pQueue.isEmpty() || !qQueue.isEmpty()) {
            pNode = pQueue.poll();
            qNode = qQueue.poll();

            if (pNode == qNode) {
                node = pNode;
            } else {
                return node;
            }
        }
        return pNode;

        // 方法二：
        // 根据搜索二叉树的特性：
        // 若 p、q 与一节点比较一大一小，分别处于该节点左右两端，那么该节点就是结果；
        // 若 p、q 一遍偏于某边，则就一直遍历下去，直到出现上述情况或者遍历到 p 点或 q 点；
//        TreeNode node = root;
//
//        while (true) {
//            if (p.val < node.val && q.val < node.val) {
//                node = node.left;
//            } else if (p.val > node.val && q.val > node.val) {
//                node = node.right;
//            } else {
//                break;
//            }
//        }
//
//        return node;
    }
}
