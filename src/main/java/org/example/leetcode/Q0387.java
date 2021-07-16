package org.example.leetcode;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author : jeymingwu
 * @date : 2021-07-16
 **/

public class Q0387 {

    public int firstUniqChar(String s) {

        int[] number = new int[32];
        int length = s.length();

        for (int i = 0; i < length; ++i) {
            ++number[s.charAt(i) - 'a'];
        }

        for (int i = 0; i < length; ++i) {
            if (number[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
