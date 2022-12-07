package com.goule666.leetcode.stackandqueue.num30020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author niewenlong
 * @date 2022/12/7 19:17
 * @description 20. 有效的括号
 * @leetCodeUrl <a href="https://leetcode.cn/problems/valid-parentheses/">...</a>
 **/
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(16);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek().equals(map.get(s.charAt(i)))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{[]}"));
    }
}