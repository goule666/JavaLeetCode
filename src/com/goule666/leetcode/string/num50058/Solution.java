package com.goule666.leetcode.string.num50058;

/**
 * @author niewenlong
 * @date 2022/11/29 11:34
 * @description 剑指 Offer 58 - II. 左旋转字符串
 * @leetCodeUrl <a href="https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/">...</a>
 **/
public class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        //reverse left
        reverseChars(chars, 0, n);
        //reverse right
        reverseChars(chars, n, s.length());
        //reverse all
        reverseChars(chars, 0, s.length());
        return new String(chars);
    }

    public void reverseChars(char[] chars, int start, int end) {
        int mid = (start + end) / 2;
        char temp;
        for (int i = start; i < mid; i++) {
            temp = chars[end - 1];
            chars[end - 1] = chars[i];
            chars[i] = temp;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
    }
}
