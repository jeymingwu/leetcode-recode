package org.example.leetcode;

/**
 *
 * 65. 有效数字
 * 有效数字（按顺序）可以分成以下几个部分：
 *
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 *
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 *
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 *
 * @author : jeymingwu
 * @date : 2021-06-20
 **/

public class Q0065 {

    public boolean isNumber(String s) {

        for (int i = 0; i < s.length(); ++i) {
            if (!((s.charAt(i) <= '9' && s.charAt(i) >= '1')
                    || s.charAt(i) == '+'
                    || s.charAt(i) == '-'
                    || s.charAt(i) == 'E'
                    || s.charAt(i) == 'e'
                    || s.charAt(i) == '.')) {
                return false;
            }
        }

        try {
            Double.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q0065 q0065 = new Q0065();
        System.out.println(q0065.isNumber("2"));
        System.out.println(q0065.isNumber("0089"));
        System.out.println(q0065.isNumber("-0.1"));
        System.out.println(q0065.isNumber("+3.14"));
        System.out.println(q0065.isNumber("4."));
        System.out.println(q0065.isNumber("-.9"));
        System.out.println("----------");
        System.out.println(q0065.isNumber("2e10"));
        System.out.println(q0065.isNumber("-90E3"));
        System.out.println(q0065.isNumber("3e+7"));
        System.out.println(q0065.isNumber("+6e-1"));
        System.out.println(q0065.isNumber("53.5e93"));
        System.out.println(q0065.isNumber("-123.456e789"));
        System.out.println("----------");
        System.out.println(q0065.isNumber("abc"));
        System.out.println(q0065.isNumber("1a"));
        System.out.println(q0065.isNumber("1e"));
        System.out.println(q0065.isNumber("e3"));
        System.out.println(q0065.isNumber("99e2.5"));
        System.out.println(q0065.isNumber("--6"));
        System.out.println(q0065.isNumber("-+3"));
        System.out.println(q0065.isNumber("95a54e53"));
    }
}
