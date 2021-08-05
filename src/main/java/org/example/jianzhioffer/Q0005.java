package org.example.jianzhioffer;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-05
 **/
public class Q0005 {

    public String replaceSpace(String s) {

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
