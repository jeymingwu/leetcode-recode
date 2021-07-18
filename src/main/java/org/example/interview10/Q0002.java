package org.example.interview10;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 *
 * @author : jeymingwu
 * @date : 2021-07-18
 **/

public class Q0002 {

    public List<List<String>> groupAnagrams(String[] strs) {

//        Map<String, List<String>> map = new HashMap<>();
//
//        for (int i = 0; i < strs.length; ++i) {
//
//            String str = strs[i];
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String sortedStr = String.valueOf(chars);
//
//            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
//            list.add(str);
//            map.put(sortedStr, list);
//        }
//
//        List<List<String>> list = new ArrayList<>();
//        Set<String> strings = map.keySet();
//        for (String s:strings) {
//            list.add(map.get(s));
//        }
//
//        return list;

        Map<String, List<String>> map = new HashMap<>();

        for (String str:strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Q0002 q0002 = new Q0002();
        List<List<String>> lists = q0002.groupAnagrams(strs);
        System.out.println(lists.toString());
    }
}
