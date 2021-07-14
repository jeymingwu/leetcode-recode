package org.example.leetcode;

/**
 * @author : jeymingwu
 * @date : 2021-07-14
 **/

public class Q1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int sum = 0;
        int max = Integer.MIN_VALUE, maxIndex = -1;
        int length = nums1.length;

        for (int i = 0; i < length; ++i) {
            int tmp = Math.abs(nums1[i] - nums2[i]);
            sum += tmp;
            if (tmp > max && tmp != 0) {
                max = tmp;
                maxIndex = i;
            }
        }

        if (maxIndex != -1) {
            sum -= max;
            int min = Integer.MAX_VALUE, minIndex = 0;
            for (int i = 0; i < length; ++i) {
                int tmp = Math.abs(nums1[i] - nums2[maxIndex]);
                if (i != maxIndex && tmp < min) {
                    min = tmp;
                    minIndex = i;
                }
            }
            sum += Math.abs(nums1[minIndex] - nums2[maxIndex]);
        }

        return (int) (sum % (Math.pow(10, 9) + 7));
    }

}
