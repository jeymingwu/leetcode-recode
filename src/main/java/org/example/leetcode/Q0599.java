package org.example.leetcode;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 *
 * @author : jeymingwu
 * @date : 2021-06-04
 **/

public class Q0599 {

    public String[] findRestaurant(String[] list1, String[] list2) {

        if (list1 == null || list1.length <= 0 || list2 == null || list2.length <= 0) {
            return null;
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();


        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }

        int minIndex = Integer.MAX_VALUE;
        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                int tmp = i + map.get(list2[i]);
                if (tmp < minIndex) {
                    res.clear();
                    minIndex = tmp;
                    res.add(list2[i]);
                } else if (tmp == minIndex) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
