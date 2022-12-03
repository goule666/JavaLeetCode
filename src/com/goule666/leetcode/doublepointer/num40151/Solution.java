package com.goule666.leetcode.doublepointer.num40151;

import java.util.Arrays;

/**
 * @author niewenlong
 * @date 2022/12/3 14:33
 * @description 151. 反转字符串中的单词
 * @leetCodeUrl <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">...</a>
 **/
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //remove space
        char[] chars = removeSpace(s.toCharArray());

        //reverse all words
        reverseString(chars, 0, chars.length - 1);

        //reverse words
        int leftIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                //need reverse
                reverseString(chars, leftIndex, i - 1);
                leftIndex = i + 1;
            }

            if (i == chars.length - 1) {
                reverseString(chars, leftIndex, i);
            }
        }
        return new String(chars);

    }

    public void reverseString(char[] chars, int start, int end) {
        char temp;
        int mid = (start + end) / 2;
        for (int i = start; i <= mid; i++) {
            temp = chars[i];
            chars[i] = chars[end];
            chars[end] = temp;
            end--;
        }
    }

    public char[] removeSpace(char[] chars) {
        char space = ' ';
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != space) {
                if (index != 0) {
                    chars[index++] = space;
                }
                while (i < chars.length && chars[i] != space) {
                    chars[index++] = chars[i++];
                }
            }
        }
        return Arrays.copyOf(chars, index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the  sky is blue "));
    }
}
