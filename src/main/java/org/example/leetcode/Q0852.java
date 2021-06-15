package org.example.leetcode;

/**
 * 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * @author : jeymingwu
 * @date : 2021-06-15
 **/

public class Q0852 {

    public int peakIndexInMountainArray(int[] arr) {

        if (arr.length < 3) {
            return 0;
        }

        // 方法一：
//        int max = 0;
//
//        for (int i = 1; i < arr.length - 1; ++i) {
//            if (arr[i] > arr[max] && arr[i] > arr[i + 1]) {
//                max = i;
//            }
//        }
//
//        return max;

        // 方法二：
        int start = 0, end = arr.length - 1;
        int mid = start + (end - start) / 2;
        int lastMid = mid;

        while (true) {
            if (arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
            if (lastMid == mid) {
                break;
            } else {
                lastMid = mid;
            }
        }
        return mid;
    }
}
