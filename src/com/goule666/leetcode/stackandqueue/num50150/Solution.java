package com.goule666.leetcode.stackandqueue.num50150;

import java.util.Stack;

/**
 * @author niewenlong
 * @date 2022/12/7 19:17
 * @description 150. 逆波兰表达式求值
 * @leetCodeUrl <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/">...</a>
 **/
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int number1 = Integer.parseInt(stack.pop());
                int number2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(number2 + number1));
            } else if ("-".equals(token)) {
                int number1 = Integer.parseInt(stack.pop());
                int number2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(number2 - number1));
            } else if ("*".equals(token)) {
                int number1 = Integer.parseInt(stack.pop());
                int number2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(number2 * number1));
            } else if ("/".equals(token)) {
                int number1 = Integer.parseInt(stack.pop());
                int number2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(number2 / number1));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}