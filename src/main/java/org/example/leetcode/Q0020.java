package org.example.leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author : jeymingwu
 * @date : 2021-07-19
 **/

public class Q0020 {

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char x : chars) {

            switch (x) {
                case '(':
                case '{':
                case '[':
                    stack.push(x);
                    break;
                default:
                    if (stack.empty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if ((x == ')' && pop != '(') ||
                            (x == '}' && pop != '{') ||
                            (x == ']' && pop != '[')) {
                        return false;
                    }
            }
        }

        return stack.empty();
    }
}
