package com.goule666.leetcode.hashtable.num10242;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author niewenlong
 * @date 2022/11/11 17:29
 * @description 242.有效的字母异位词
 * @leetCodeUrl <a href="https://leetcode.cn/problems/valid-anagram/">...</a>
 **/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return false;
        }
        Map<Character, Integer> hashMap = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            hashMap.compute(s.charAt(i), (oldK, oldV) -> {
                if (oldV == null) {
                    return 1;
                } else {
                    return ++oldV;
                }
            });
        }
        for (int i = 0; i < t.length(); i++) {
            if (hashMap.containsKey(t.charAt(i))) {
                hashMap.computeIfPresent(t.charAt(i), (oldK, oldV) -> oldV - 1);
            } else {
                return false;
            }
        }
        AtomicBoolean result = new AtomicBoolean(true);
        hashMap.forEach((k, v) -> {
            if (v != 0) {
                result.set(false);
            }
        });
        return result.get();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("ateee", "taee"));
    }
}
