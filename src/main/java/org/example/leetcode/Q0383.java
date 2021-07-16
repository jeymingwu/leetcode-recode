package org.example.leetcode;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * https://leetcode-cn.com/problems/ransom-note/
 *
 * @author : jeymingwu
 * @date : 2021-07-16
 **/

public class Q0383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] number = new int[32];

        for (int i = 0; i < magazine.length(); ++i) {
            ++number[magazine.charAt(i) - 'a'];
        }

        for (int i = 0; i < ransomNote.length(); ++i) {
            int index = ransomNote.charAt(i) - 'a';
            if (number[index] > 0) {
                --number[index];
            } else {
                return false;
            }
        }

        return true;
    }
}
