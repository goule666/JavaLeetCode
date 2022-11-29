package com.goule666.leetcode.string.num40151;

import java.util.Arrays;

/**
 * @author niewenlong
 * @date 2022/11/29 11:34
 * @description 151. 反转字符串中的单词
 * @leetCodeUrl <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">...</a>
 **/
public class Solution {
    public String reverseWords(String s) {
        //remove
        char[] removeSpaceStrs = removeSpace(s.toCharArray());

        //reverse
        reverseChars(removeSpaceStrs, 0, removeSpaceStrs.length);


        //reverse words
        int start = 0;
        for (int i = 0; i < removeSpaceStrs.length; i++) {
            if (removeSpaceStrs[i] == ' ' || i == removeSpaceStrs.length - 1) {
                if (i == removeSpaceStrs.length - 1) {
                    i++;
                }
                reverseChars(removeSpaceStrs, start, i);
                start = i + 1;
            }
        }
        return new String(removeSpaceStrs);
    }

    public void reverseChars(char[] removeSpaceStrs, int start, int end) {
        char temp;
        int mid = ((end + start) / 2);
        for (int i = start; i < mid; i++) {
            temp = removeSpaceStrs[end - 1];
            removeSpaceStrs[end - 1] = removeSpaceStrs[i];
            removeSpaceStrs[i] = temp;
            end--;
        }
    }

    public char[] removeSpace(char[] chars) {
        int slowIndex = 0;

        for (int fastIndex = 0; fastIndex < chars.length; fastIndex++) {
            if (chars[fastIndex] != ' ') {
                if (slowIndex != 0) {
                    chars[slowIndex++] = ' ';
                }
                while (fastIndex <= chars.length - 1 && chars[fastIndex] != ' ') {
                    chars[slowIndex++] = chars[fastIndex++];
                }
            }
        }
        return Arrays.copyOf(chars, slowIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue "));
    }
}
