package org.example.leetcode;

import java.util.*;

/**
 * 1743. 从相邻元素对还原数组
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 *
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 *
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 *
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 *
 * https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/
 *
 * @author : jeymingwu
 * @date : 2021-07-25
 **/

public class Q1743 {

    public int[] restoreArray(int[][] adjacentPairs) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] nums = new int[n];

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> value = entry.getValue();
            if (value.size() == 1) {
                nums[0] = e;
                break;
            }
        }

        nums[1] = map.get(nums[0]).get(0);
        for (int i = 2; i < n; ++i) {
            List<Integer> list = map.get(nums[i - 1]);
            nums[i] = nums[0] == list.get(0) ? list.get(1) : list.get(0);
        }

        return nums;
    }

    public static void main(String[] args) {

        int[][] nums = {
                {2, 1}, {3, 4}, {3, 2}
        };

        Q1743 q1743 = new Q1743();
        System.out.println(Arrays.toString(q1743.restoreArray(nums)));

    }
}
