package com.goule666.leetcode.doublepointer.num20344;

/**
 * @author niewenlong
 * @date 2022/12/3 14:05
 * @description 344. 反转字符串
 * @leetCodeUrl <a href="https://leetcode.cn/problems/reverse-string/">...</a>
 **/
public class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverseChars(s, 0, s.length);
    }

    public void reverseChars(char[] s, int start, int end) {
        int mid = (start + end) / 2;
        char temp;
        for (int i = start; i < mid; i++) {
            temp = s[i];
            s[i] = s[end - 1];
            s[end - 1] = temp;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseString(new char[]{'h', 'a', 'p', 'p', 'y', 'y'});
    }
}
