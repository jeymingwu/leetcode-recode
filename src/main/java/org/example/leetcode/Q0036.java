package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * @author : jeymingwu
 * @date : 2021-07-15
 **/

public class Q0036 {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; ++i) {
            Set<Integer> xSet = new HashSet<>();
            Set<Integer> ySet = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                int num = board[i][j] - '0';
                if (num >= 0 && num <= 9) {
                    if (xSet.contains(num)) {
                        return false;
                    } else {
                        xSet.add(num);
                    }
                }

                num = board[j][i] - '0';
                if (num >= 0 && num <= 9) {
                    if (ySet.contains(num)) {
                        return false;
                    } else {
                        ySet.add(num);
                    }
                }
            }
        }

        for (int a = 0 ; a < 3; ++a) {
            for (int b = 0; b < 3; ++b) {
                Set<Integer> set = new HashSet<>();
                for (int i = 3 * b; i < 3 + 3 * b; ++i) {
                    for (int j = 3 * a; j < 3 + 3 * a; ++j) {
                        int num = board[i][j] - '0';
                        if (num >= 0 && num <= 9) {
                            if (set.contains(num)) {
                                return false;
                            } else {
                                set.add(num);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        for (int a = 0 ; a < 3; ++a) {
            for (int b = 0; b < 3; ++b) {
                for (int i = 3 * b; i < 3 + 3 * b; ++i) {
                    for (int j = 3 * a; j < 3 + 3 * a; ++j) {
                        System.out.print(i + "," + j + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}
