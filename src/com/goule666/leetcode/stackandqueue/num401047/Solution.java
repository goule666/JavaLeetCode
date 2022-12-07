package com.goule666.leetcode.stackandqueue.num401047;

import java.util.Stack;

/**
 * @author niewenlong
 * @date 2022/12/7 19:17
 * @description 1047. 删除字符串中的所有相邻重复项
 * @leetCodeUrl <a href="https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/">...</a>
 **/
public class Solution {
    public String removeDuplicates(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek().equals(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.empty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("{[]}"));
    }
}