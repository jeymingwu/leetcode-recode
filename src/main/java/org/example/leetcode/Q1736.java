package org.example.leetcode;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 * https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 *
 * @author : jeymingwu
 * @date : 2021-07-24
 **/

public class Q1736 {

    public String maximumTime(String time) {

        char[] chars = time.toCharArray();

        for (int i = 0; i < chars.length; ++i) {

            if (chars[i] == '?') {

                switch (i) {
                    case 0:
                        if (chars[i + 1] == '?' || chars[i + 1] < '4') {
                            chars[i] = '2';
                        } else {
                            chars[i] = '1';
                        }
                        break;
                    case 1:
                        if (chars[i - 1] == '2') {
                            chars[i] = '3';
                        } else {
                            chars[i] = '9';
                        }
                        break;
                    case 3:
                        chars[i] = '5';
                        break;
                    case 4:
                        chars[i] = '9';
                        break;
                }
            }
        }

        return new String(chars);
    }
}
