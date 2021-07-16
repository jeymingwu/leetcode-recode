package org.example.leetcode;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author : jeymingwu
 * @date : 2021-07-16
 **/

public class Q0242 {

    public boolean isAnagram(String s, String t) {

        int length = s.length();
        if (length != t.length()) {
            return false;
        }

        int[] number = new int[32];

        for (int i = 0; i < length; ++i) {
            number[s.charAt(i) - 'a']++;
            number[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 32; ++i) {
            if (number[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
