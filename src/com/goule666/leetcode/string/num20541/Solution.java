package com.goule666.leetcode.string.num20541;


/**
 * @author niewenlong
 * @date 2022/11/28 20:05
 * @description 541. 反转字符串II
 * @leetCodeUrl <a href="https://leetcode.cn/problems/reverse-string-ii/">...</a>
 **/
public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i = i + 2 * k) {
            String s1 = s.substring(i, Math.min(i + 2 * k, s.length()));

            char temp;
            char[] chars = s1.toCharArray();
            int len = Math.min(s1.length(), k);
            for (int j = 0; j < len / 2; j++) {
                temp = chars[len - j - 1];
                chars[len - j - 1] = chars[j];
                chars[j] = temp;
            }
            result.append(new String(chars));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("a", 2));
    }
}
