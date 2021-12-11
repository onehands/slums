package com.slums.hands.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/10 15:33
 * @version: 1.0
 */
public class LeetCode_146 {
    class LRUCache {
        int capacity;
        private LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return map.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
