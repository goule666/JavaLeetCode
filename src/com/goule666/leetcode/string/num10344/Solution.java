package com.goule666.leetcode.string.num10344;

/**
 * @author niewenlong
 * @date 2022/11/28 19:56
 * @description 344. 反转字符串
 * @leetCodeUrl <a href="https://leetcode.cn/problems/reverse-string/">...</a>
 **/
public class Solution {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[s.length - i - 1];
            s[s.length - i - 1] = s[i];
            s[i] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
