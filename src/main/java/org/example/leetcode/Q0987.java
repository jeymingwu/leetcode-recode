package org.example.leetcode;

import java.util.*;

/**
 * 987. 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 *
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 *
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 *
 * 返回二叉树的 垂序遍历 序列。
 *
 * https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * @author : jeymingwu
 * @date : 2021-07-31
 **/

public class Q0987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(0);

        // 整体思路：先广度优先搜索，得出同行的结果，然后再大小排序，最后再合并到结果中去；
        while (!queue.isEmpty()) {

            int size = queue.size();
            Map<Integer, List<Integer>> tempMap = new HashMap<>();

            while (size > 0) {

                TreeNode poll = queue.poll();
                Integer index = indexQueue.poll();

                List<Integer> list = tempMap.getOrDefault(index, new ArrayList<>());
                list.add(poll.val);
                tempMap.put(index, list);

                if (poll.left != null) {
                    queue.offer(poll.left);
                    indexQueue.offer(index - 1);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    indexQueue.offer(index + 1);
                }

                --size;
            }

            // 题目坑点：同行同列上结点的值需从小到大进行排序
            for (Map.Entry<Integer, List<Integer>> entry: tempMap.entrySet()) {
                Collections.sort(entry.getValue());
                List<Integer> orDefault = map.getOrDefault(entry.getKey(), new ArrayList<>());
                orDefault.addAll(entry.getValue());
                map.put(entry.getKey(), orDefault);
            }
        }

        return new ArrayList<>(map.values());
    }
}


