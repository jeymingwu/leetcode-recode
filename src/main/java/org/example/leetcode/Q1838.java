package org.example.leetcode;

/**
 * @author : jeymingwu
 * @date : 2021-07-19
 **/

public class Q1838 {

    public int maxFrequency(int[] nums, int k) {

        int length = nums.length;
        int[] sums = new int[length];

        int sum = 1, maxSum = sum;

        for (int i = 1; i < length; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int index = 0, maxIndex = 0, i = 1; i < length; ) {

            int tmpSum = sums[i] + nums[i];
            if (index != 0) {
                tmpSum -= sums[index];
            }
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
            int count = i - index + 1;
            int diff = nums[maxIndex] * count - tmpSum;
            if (diff <= k) {
                ++i;
                ++sum;
                maxSum = Math.max(sum, maxSum);
            } else {
                ++index;
                maxIndex = Math.max(maxIndex, index);
                i = i == index ? i + 1 : i;
                sum = 1;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Q1838 q1838 = new Q1838();
//        System.out.println(q1838.maxFrequency(new int[]{1, 2, 4}, 5));
//        System.out.println(q1838.maxFrequency(new int[]{3, 9, 6}, 2));
//        System.out.println(q1838.maxFrequency(new int[]{9940,9995,9944,9937,9941,9952,9907,9952,9987,9964,9940,9914,9941,9933,9912,9934,9980,9907,9980,9944,9910,9997}, 7925));
        System.out.println(q1838.maxFrequency(new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966}, 3056));

    }
}
