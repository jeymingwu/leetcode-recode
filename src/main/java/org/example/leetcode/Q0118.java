package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 *
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @author : jeymingwu
 * @date : 2021-07-15
 **/

public class Q0118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; ++j) {
                if (i <= 1) {
                    list.add(1);
                } else if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }

            lists.add(list);
        }

        return lists;
    }

}
