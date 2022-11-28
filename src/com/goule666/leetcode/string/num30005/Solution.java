package com.goule666.leetcode.string.num30005;

/**
 * @author niewenlong
 * @date 2022/11/28 20:50
 * @description 题目：剑指Offer 05.替换空格
 * @leetCodeUrl <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">...</a>
 **/
public class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder param = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                param.append("  ");
            }
        }
        char[] chars = param.toString().toCharArray();
        int leftIndex = s.length() - 1;
        int rightIndex = chars.length - 1;
        for (int i = 0; i < s.length(); i++) {
            if (chars[leftIndex] == ' ') {
                chars[rightIndex--] = '0';
                chars[rightIndex--] = '2';
                chars[rightIndex--] = '%';
            } else {
                chars[rightIndex--] = chars[leftIndex];
            }
            leftIndex--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("we are ha"));
    }
}
