package org.example.leetcode;

import java.util.*;

/**
 * 981. 基于时间的键值存储
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 存储键 key、值 value，以及给定的时间戳 timestamp。
 * 2. get(string key, int timestamp)
 *
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 *
 * https://leetcode-cn.com/problems/time-based-key-value-store/
 *
 * @author : jeymingwu
 * @date : 2021-07-10
 **/

public class Q0981 {

    class TimeMap {

        class Data {
            public List<String> value;
            public List<Integer> timestamp;
            public Integer minTimestamp = Integer.MAX_VALUE;

            public Data() {
                value = new ArrayList<>();
                timestamp = new ArrayList<>();
            }
        }

        private Map<String, Data> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            Data data = map.getOrDefault(key, new Data());
            if (data.minTimestamp > timestamp) {
                data.minTimestamp = timestamp;
            }
            data.value.add(value);
            data.timestamp.add(timestamp);
            map.put(key, data);
        }

        public String get(String key, int timestamp) {
            Data data = map.get(key);

            if (data == null || timestamp < data.minTimestamp) {
                return "";
            }

            int start = 0, end = data.value.size() - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (data.timestamp.get(mid) > timestamp) {
                    end = mid - 1;
                } else if (data.timestamp.get(mid) < timestamp) {
                    start = mid + 1;
                } else {
                    return data.value.get(mid);
                }
            }

            return data.value.get(start - 1);

//            int remarkTimestamp = data.timestamp.get(0);
//            int value = data.timestamp.get(0);
//            for (int i = 1; i < data.value.size(); ++i) {
//                int tmpTimestamp = data.timestamp.get(i);
//                if (tmpTimestamp > remarkTimestamp && tmpTimestamp <= timestamp) {
//                    remarkTimestamp = tmpTimestamp;
//                    value = data.value.get(i);
//                }
//            }

//            return value;
        }

    }
}
