package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @author : jeymingwu
 * @date : 2021-07-13
 **/

public class Q0350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        // 方法一：哈希表
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int length1 = nums1.length, length2 = nums2.length;
//
//        for (int i = 0; i < length1; ++i) {
//            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < length2; ++i) {
//            Integer tmp = map.getOrDefault(nums2[i], 0);
//            if (tmp > 0) {
//                map.put(nums2[i], tmp - 1);
//                list.add(nums2[i]);
//            }
//        }
//
//        int size = list.size();
//        int[] res = new int[size];
//        for (int i = 0; i < size; ++i) {
//            res[i] = list.get(i);
//        }
//        return res;

        // 方法一：哈希表（改进版）
//        if (nums1.length > nums2.length) {
//            return intersect(nums2, nums1);
//        }
//
//        int length1 = nums1.length, length2 = nums2.length;
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < length1; ++i) {
//            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
//        }
//
//        int index = 0;
//        int[] res = new int[length1];
//        for (int i = 0; i < length2; ++i) {
//            Integer count = map.getOrDefault(nums2[i], 0);
//            if (count > 0) {
//                res[index++] = nums2[i];
//                count--;
//                if (count > 0) {
//                    map.put(nums2[i], count);
//                } else {
//                    map.remove(nums2[i]);
//                }
//            }
//        }
//
//        return Arrays.copyOfRange(res, 0, index);


        // 方法二：排序 + 双指针
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
//        int length1 = nums1.length, length2 = nums2.length;
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0, j = 0; i < length1 && j < length2;) {
//
//            if (nums1[i] == nums2[j]) {
//                list.add(nums1[i]);
//                ++i;
//                ++j;
//            } else if (nums1[i] > nums2[j]) {
//                ++j;
//            } else {
//                ++i;
//            }
//
//        }
//
//        int size = list.size();
//        int[] res = new int[size];
//        for (int i = 0; i < size; ++i) {
//            res[i] = list.get(i);
//        }
//        return res;

        // 方法二：排序 + 双指针（改进版）
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0;
        int[] res = new int[nums1.length];

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {

            if (nums1[i] == nums2[j]) {
                res[index++] = nums1[i];
                ++i;
                ++j;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                ++i;
            }

        }

        return Arrays.copyOfRange(res, 0, index);

    }

}
