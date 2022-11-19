package com.goule666.leetcode.hashtable.num70383;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author niewenlong
 * @date 2022/11/19 22:06
 * @description 383. 赎金信
 * @leetCodeUrl <a href="https://leetcode.cn/problems/ransom-note/">...</a>
 **/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0 || magazine == null || magazine.length() == 0) {
            return false;
        }
        Map<Character, Integer> ransomNoteMap = new HashMap<>(16);
        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            ransomNoteMap.put(key, ransomNoteMap.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char key = magazine.charAt(i);
            if (ransomNoteMap.containsKey(key)) {
                ransomNoteMap.put(key, Math.max(0, ransomNoteMap.getOrDefault(key, 0) - 1));
            }
        }
        AtomicBoolean result = new AtomicBoolean(true);
        ransomNoteMap.forEach((k, v) -> {
            if (v != 0) {
                result.set(false);
            }
        });
        return result.get();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("aa", "ab"));
    }
}
